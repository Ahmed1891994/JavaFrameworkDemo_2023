@echo off
docker run -d -p 8080:8080 -p 50000:50000 -v "%cd%/jenkins:/var/jenkins_home" jenkins/jenkins:lts
timeout /t 150
echo 33dcc0a85f8cb70a17ebe1fc500da582b29f8718afea917cca269ae3a0bc183b > secret-file
curl -sO http://localhost:8080/jnlpJars/agent.jar
java -jar agent.jar -jnlpUrl http://localhost:8080/manage/computer/machineX/jenkins-agent.jnlp -secret @secret-file -workDir "c:\jenkins"