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
                sh "mvn -Dmaven.test.failure.ignore=true clean package"
            }

            post {
                success {
                    junit '**/target/surefire-reports/TEST-*.xml'
                    archiveArtifacts 'target/*.jar'
                }
            }
        }

        stage('Build and Push Docker Image') {
            steps {
                script {
                    // Build the Docker image
                    docker.build('dioneousseynou/employe-ci-cd:latest')

                    // Login to Docker Hub
                    docker.withRegistry('https://registry.hub.docker.com', 'docker-hub-credentials') {
                        // Push the Docker image to Docker Hub
                        docker.image('dioneousseynou/employe-ci-cd:latest').push()
                    }
                }
            }
        }

        stage('Deploy with Docker Compose') {
            steps {
                // Run Docker Compose to deploy the services
                sh 'docker-compose up -d'
            }
        }
    }

    post {
        always {
            // Clean up resources if needed
            sh 'docker-compose down'
        }
    }
}
