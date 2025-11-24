pipeline {
    agent any

    tools {
        jdk 'JDK21'        // JDK name from Jenkins Global Tool Configuration
        maven 'Maven3'     // Maven name from Jenkins Global Tool Configuration
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build & Deploy to Nexus') {
            steps {
                // Use your local settings.xml so Maven knows Nexus credentials
                bat 'mvn -B -s "C:\\Users\\Aerika\\.m2\\settings.xml" clean deploy'
            }
        }
    }

    post {
        success {
            archiveArtifacts artifacts: 'target/*.jar', fingerprint: true
        }
        always {
            junit 'target/surefire-reports/*.xml'
        }
    }
}
