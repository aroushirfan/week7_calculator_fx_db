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
                bat 'mvn -DskipTests clean package'
            }
        }

        stage('Build Docker Image') {
            steps {
                echo "Building Docker image..."
                bat 'docker build -t yourdockerhubusername/sum-product-fx .'
            }
        }

        stage('Docker Compose Up') {
            steps {
                echo "Starting containers..."
                bat 'docker compose down || true'
                bat 'docker compose up -d'
            }
        }

        stage('Verify Containers') {
            steps {
                echo "Listing running containers..."
                bat 'docker ps'
            }
        }
    }

    post {
        always {
            echo "Pipeline finished."
        }
    }
}