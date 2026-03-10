pipeline {
    agent any

    stages {

        stage('Checkout') {
            steps {
                echo "Pulling repository..."
                checkout scm
            }
        }

        stage('Build JAR') {
            steps {
                echo "Building Maven project..."
                sh 'mvn -DskipTests clean package'
            }
        }

        stage('Build Docker Image') {
            steps {
                echo "Building Docker image..."
                sh 'docker build -t aroush/sum-product-fx .'
            }
        }

        stage('Docker Compose Up') {
            steps {
                echo "Starting containers..."
                sh 'docker compose down || true'
                sh 'docker compose up -d'
            }
        }

        stage('Verify Containers') {
            steps {
                echo "Listing running containers..."
                sh 'docker ps'
            }
        }
    }

    post {
        always {
            echo "Pipeline finished."
        }
    }
}
