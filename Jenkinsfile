pipeline {
    agent any

    tools {
        jdk 'JDK21'
        maven 'Maven3'
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }
        stage('Build & Test') {
            steps {
                bat 'mvn -B clean package'
            }
        }
    }
    post {
        success {
            archiveArtifacts artifacts: 'target/**/*.jar', fingerprint: true
        }
    }
}
