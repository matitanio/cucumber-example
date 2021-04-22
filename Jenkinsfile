pipeline {
    agent any
    stages {
        stage('Test') {
            steps {
                script{
                    try{
                        File file = new File("src/test/resources/cucumber-reporting.properties")
                        file.append("\nversion=${BUILD_NUMBER}")
                        file.close()
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