pipeline {
    agent any
    stages {
        stage('Test') {
            steps {
                script{
                    try{
                        sh './gradlew -Dcucumber.reporting.config.file=src/test/resources/cucumber-reporting.properties cucumber'
                    }
                    finally{
                         archive (includes: 'build/pretty-cucumber')
                         publishHTML (target: [
                               allowMissing: false,
                               alwaysLinkToLastBuild: false,
                               keepAll: true,
                               reportDir: 'cucumber-html-reports',
                               reportFiles: 'overview-features.html',
                               reportName: "Cucumber reports"
                             ])
                    }
                }
            }
        }
    }
}