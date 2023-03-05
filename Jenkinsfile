pipeline {
    // master executor should be set to 0
    agent any
    stages {
        stage('Build Jar') {
            steps {
                bat "mvn clean install -DskipTests"
            }
        }
        stage('Build Image') {
            steps {
                bat "docker build -t=selenium-docker ."
            }
        }
        stage('Push Image') {
            steps {
			    withCredentials([usernamePassword(credentialsId: 'DockerHub', passwordVariable: 'pass', usernameVariable: 'user')]) {
			        bat "echo %pass%| docker login -u %user% --password-stdin"
			        bat "docker tag selenium-docker %user%/selenium-docker:selenium-docker"
			        bat "docker images"
			        bat "docker push %user%/selenium-docker:selenium-docker"
			    }                           
            }
        }
    }
}
