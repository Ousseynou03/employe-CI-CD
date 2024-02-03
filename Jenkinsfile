pipeline {
    agent any

    tools {
        // Install the Maven version configured as "M3" and add it to the path.
        maven "jenkins-maven"
    }

    stages {
        stage('Checkout') {
            steps {
                // Get some code from a GitHub repository
                git branch: 'develop', url: 'https://github.com/Ousseynou03/employe-CI-CD.git'
            }
        }

        stage('Build') {
            steps {
                sh "mvn package -DskipTests"
            }

        }

        stage('Build and Push Docker Image') {
            steps {
                script {
                echo "building docker image....."
                withCredentials([usernamePassword(credentialsId: 'dockerhub_id', usernameVariable: 'USERNAME', passwordVariable: 'PASSWORD')]) {

                  sh 'echo $PASSWORD'

                  echo USERNAME

                  echo "username is $USERNAME"
                  sh '/usr/local/bin/docker --version'
                  sh '/usr/local/bin/docker ps'
                  sh '/usr/local/bin/docker build -t dioneousseynou/java-spring:v1 .'
                  sh 'echo $PASSWORD |/usr/local/bin/docker login -u $USERNAME --password-stdin'
                  sh '/usr/local/bin/docker push dioneousseynou/java-spring:v1'
                  sh '/usr/local/bin/docker compose -d up'
                }

                }
            }
        }
    }
}
