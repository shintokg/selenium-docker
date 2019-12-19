pipeline {
    // master executor should be set to 0
    agent any
    environment {
        //M2_HOME="/Users/shigovin/Downloads/apache-maven-3.6.2"
        //PATH="$PATH:/Users/shigovin/Downloads/apache-maven-3.6.2/bin/"
      }
    stages {
        stage('Build Jar') {
            steps {
                //sh
                sh "mvn clean package -DskipTests"
            }
        }
        stage('Build Image') {
            steps {
                //sh
                sh "docker build -t='shintokg/selenium-docker' ."
            }
        }
        stage('Push Image') {
            steps {
			    withCredentials([usernamePassword(credentialsId: 'dockerhub', passwordVariable: 'pass', usernameVariable: 'user')]) {
                    //sh
			        sh "docker login --username=${user} --password=${pass}"
			        sh "docker push shintokg/selenium-docker:latest"
			    }
            }
        }
    }
}