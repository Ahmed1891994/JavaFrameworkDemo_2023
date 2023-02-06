pipeline {
    // master executor should be set to 0
    agent any
    stages {
        stage('Build Jar') {
            steps {
                bat "mvn clean install -Denv=prod"
            }
        }
        stage('Build Image') {
            steps {
                bat "docker-compose up -d"
                bat "docker build -t=selenium-docker ."
            }
        }
        stage('Push Image') {
            steps {
			    withCredentials([usernamePassword(credentialsId: 'dockerhub_cred', passwordVariable: 'pass', usernameVariable: 'user')]) {
			        bat "docker login --username=${user} --password=${pass}"
			        bat "docker tag selenium-docker ${user}/selenium-docker:selenium-docker"
			        bat "docker images"
			        bat "docker push ${user}/selenium-docker:selenium-docker"
			    }                           
            }
        }
    }
}