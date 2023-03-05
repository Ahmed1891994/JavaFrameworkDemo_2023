# 📝Selenium JAVA Test Automation Framework
- This project is an open-source Test automation Framework that allows you to perform multiple actions to test a web application's functionality, behaviour, 
which provides easy to use syntax, and easy to setup environment according to the needed requirements for testing
- This project is based on Selenium WebDriver, TestNG Runner, and Maven

## 📝Features
- Support Running Testing on Following Browsers: Chrome, Firefox, & Edge
- Support Cross-Browsing Mode
- Support Running on Selenium Grid
- Generate Allure Report automatically after Test Execution with screenshots
- Support being Dockerized
- Support Logs using log4j
- Support being being run on jenkins Pipelines

Website URL: [herokuapp](https://the-internet.herokuapp.com/)

## 📝 Installation
[Java(JDK)](https://www.oracle.com/java/technologies/downloads/)

[Eclipse](https://www.eclipse.org/downloads/)

[Maven](https://maven.apache.org/download.cgi)

[Allure](https://github.com/allure-framework/allure2/releases)

[GIT](https://git-scm.com/downloads)

[LogExpert](https://github.com/zarunbal/LogExpert/releases/tag/v1.9.0)

## 📝 The main Frameworks included in the project:
* Page Object Model (POM) design pattern
* TESTNG as testing framework

## 📝 Framework  covers
* The URL and Browser Configuration are defined in the respective settings.properties
* SOLID java Princibles Specially (Single responsibility + open/closed)
* Pom.xml will add JAR files and libraries needed by Project and build the project
* listeners
* Reporting using Allure
* Web Driver Manager
* Logging using log4j
* aeonbits.owner library for flexible configuration framework
* Handle Different Environment (DEV,UAT,PROD)

## 📝 How To Run
### Run Locally
* Dev environment  -> mvn clean test or mvn clean test -Denv=dev
* UAT environment  -> mvn clean test -Denv=uat
### Run On Grid
* You need first to run docker-compose up in project path as this will Prepare the Grid
* PROD environment -> mvn clean test -Denv=prod
### Run From Docker container
*  you need to get the jar files mvn clean package -Denv=prod
*  then run a jenkinsfile in master it will do the show
*  now all data needed being dockerized then pushed to docker hub
*  then from the branch run the other jenkinsfile from another pipeline.
*  then it will pull the container from docker hub then run the Tests and save results and logs

## Using Docker
[Download Jenkins](https://www.jenkins.io/download/)

Add plugins : maven integration , blueocean , git
## Docker Builder
to make a pipline for building project and upload project container to dockerhub
* Create pipline
* Choose script pipline from SCM
* Put github link https://github.com/Ahmed1891994/JavaFrameworkDemo_2023.git
* Don't forget to add the global credintial which has id DockerHub for the Dockerhub website
* Put Branch Specifier main
* Put Script Path "Jenkinsfile"

## Docker Runner
to make a pipline for running project and get project container from dockerhub
* Create pipline
* Choose script pipline from SCM
* Put github link https://github.com/Ahmed1891994/JavaFrameworkDemo_2023.git
* Don't forget to add the global credintial which has id DockerHub for the Dockerhub website
* Put Branch Specifier TestcasesRunner
* Put Script Path "JenkinsFileaTests/Jenkinsfile"
