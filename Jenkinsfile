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
                    bat echo this.env['user']
                    bat echo this.env['pass']
			        bat "docker login --username=this.env['user'] --password=this.env['pass']"
			        bat "docker push selenium-docker/selenium-docker:latest"
			    }                           
            }
        }
    }
}