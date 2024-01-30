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
                  sh 'docker build -t dioneousseynou/java-spring:v1 .'
                  sh 'docker login -u $USERNAME -p $PASSWORD'
                  sh 'docker push dioneousseynou/java-spring:v1'
                }

                }
            }
        }
    }
}