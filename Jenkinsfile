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

        stage('Deploy to Staging') {
            steps {
                echo "Deploying application to staging environment..."

                // Ensure staging directory exists
                bat 'if not exist C:\\staging mkdir C:\\staging'
                bat 'if not exist C:\\staging\\demo-java-app mkdir C:\\staging\\demo-java-app'

                // Download artifact from Nexus to staging folder
                // ⬇⬇⬇ REPLACE YOUR_NEXUS_PASSWORD with your real Nexus admin password ⬇⬇⬇
                bat 'curl -u admin:Simu@1710 -o "C:\\staging\\demo-java-app\\demo-java-app-1.1.jar" "http://localhost:8081/repository/demo-releases/com/example/demo-java-app/1.1/demo-java-app-1.1.jar"'

                echo "Application copied to staging."
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
