pipeline {
    // master executor should be set to 0
    agent any
    stages {
        stage('Build Jar') {
            steps {
                //sh
                bat "mvn clean install -Denv=prod"
                bat "docker-compose up -d"
            }
        }
        stage('Build Image') {
            steps {
                //sh
                //bat "docker-compose up -d"
                bat "docker build -t=selenium-docker/selenium-docker ."
            }
        }
        stage('Push Image') {
            steps {
			    withCredentials([usernamePassword(credentialsId: 'dockerhub_cred', passwordVariable: 'pass', usernameVariable: 'user')]) {
                    //sh
                    bat "echo ${user}"
                    bat "echo ${pass}"
			        bat "docker login --username=${user} --password=${pass}"
			        bat "docker push selenium-docker/selenium-docker:latest"
			    }                           
            }
        }
    }
}