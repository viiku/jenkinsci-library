package com.mycompany.jenkinslib

class Repository implements Serializable {
    String repoUrl
    String branch
    String buildTool
    String testTool
    String deployTool

    Repository(String repoUrl, String branch = 'main', String buildTool = 'maven', String testTool = 'maven', String deployTool = 'default') {
        this.repoUrl = repoUrl
        this.branch = branch
        this.buildTool = buildTool
        this.testTool = testTool
        this.deployTool = deployTool
    }

    // Method to clone the repository
    def cloneRepo(script) {
        script.echo "Cloning repository: ${repoUrl} on branch: ${branch}"
        
        script.checkout([
            $class: 'GitSCM',
            branches: [[name: "*/${branch}"]],
            userRemoteConfigs: [[url: repoUrl]]
        ])
    }

    // Method to build the repository
    def buildRepo(script) {
        script.echo "Building repository using ${buildTool}"
        if (buildTool == 'maven') {
            script.sh 'mvn clean install'
        } else if (buildTool == 'gradle') {
            script.sh './gradlew build'
        } else {
            script.error("Unsupported build tool: ${buildTool}")
        }
    }

    // Method to test the repository
    def testRepo(script) {
        script.echo "Running tests using ${testTool}"
        if (testTool == 'maven') {
            script.sh 'mvn test'
        } else if (testTool == 'gradle') {
            script.sh './gradlew test'
        } else {
            script.error("Unsupported test tool: ${testTool}")
        }
    }

    // Method to deploy the repository
    def deployRepo(script) {
        script.echo "Deploying repository using ${deployTool}"
        if (deployTool == 'default') {
            script.sh 'echo "Deploying using default tool"'
        } else {
            script.error("Unsupported deploy tool: ${deployTool}")
        }
    }
}
