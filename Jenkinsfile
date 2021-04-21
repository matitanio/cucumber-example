pipeline {
    agent any
    stages {
        stage('Test') {
            steps {
                script{
                    sh './gradlew cucumber'
                }
            }
        }
    }
}