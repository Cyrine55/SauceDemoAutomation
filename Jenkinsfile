pipeline {
    agent any

    tools {
        // Install the Maven version configured as "M3" and add it to the path.
        maven "MAVEN_HOME"
    }

    stages {
        stage('Build') {
            steps {
                // Get some code from a GitHub repository
                git 'https://github.com/Cyrine55/SauceDemoAutomation.git/'

                // Run Maven on a Unix agent.
               // sh "mvn -Dmaven.test.failure.ignore=true clean package"

                // To run Maven on a Windows agent, use
                 bat "mvn -Dmaven.test.failure.ignore=true clean test"
            }
        }
          stage('Rapport de test') {
              steps {
                  cucumber buildStatus: "UNSTABLE",
                      fileIncludePattern: "**/cucumber.json",
                  jsonReportDirectory:'target'
              }
        }

    }
}