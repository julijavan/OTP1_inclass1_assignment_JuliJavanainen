pipeline {
    agent any
    tools {
        maven 'maven3'
    }
    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/julijavan/OTP1_inclass1_assignment_JuliJavanainen'
            }
        }
        stage('Build') {
            steps {
                bat 'mvn clean install'
            }
        }
        stage('Test') {
            steps {
                bat 'mvn test'
            }
        }
        stage('Code Coverage') {
            steps {
                bat 'mvn jacoco:report'
            }
        }
        stage('Publish Test Results') {
            steps {
                junit '**/target/surefire-reports/*.xml'
            }
        }
        stage('Publish Coverage Report') {
            steps {
                jacoco()
            }
        }
            stage('Docker Build') {
                steps {
                    bat 'docker build -t julijav/temperature-converter:latest .'
                }
            }
            stage('Docker Push') {
                steps {
                    withCredentials([usernamePassword(credentialsId: 'dockerhub-creds', usernameVariable: 'DOCKER_USER', passwordVariable: 'DOCKER_PASS')]) {
                        bat 'docker login -u %DOCKER_USER% -p %DOCKER_PASS%'
                        bat 'docker push julijav/temperature-converter:latest'
                    }
                }
            }
            stage('Build Docker Image') {
                steps {
                    bat '"C:\\Users\\julij\\AppData\\Local\\Programs\\DockerDesktop\\resources\\bin\\docker.exe" build -t %IMAGE_NAME%:latest .'
                }
            }
            stage('Push to Docker Hub') {
                steps {
                    bat '"C:\\Users\\julij\\AppData\\Local\\Programs\\DockerDesktop\\resources\\bin\\docker.exe" login -u %DOCKERHUB_CREDENTIALS_USR% -p %DOCKERHUB_CREDENTIALS_PSW%'
                    bat '"C:\\Users\\julij\\AppData\\Local\\Programs\\DockerDesktop\\resources\\bin\\docker.exe" push %IMAGE_NAME%:latest'
                }
            }
        }
    }
