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
                         archiveArtifacts (artifacts: 'build/pretty-cucumber/**')
                         publishHTML (target: [
                               allowMissing: false,
                               alwaysLinkToLastBuild: false,
                               keepAll: true,
                               reportDir: 'build/pretty-cucumber/cucumber-html-reports',
                               reportFiles: 'overview-features.html',
                               reportName: "Cucumber reports"
                             ])
                    }
                }
            }
        }
    }
}