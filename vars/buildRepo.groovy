def call(String buildTool = 'maven') {
    echo "Building repository using ${buildTool}"

    if (buildTool == 'maven') {
        sh 'mvn clean install'
    } else if (buildTool == 'gradle') {
        sh './gradlew build'
    } else {
        error("Unsupported build tool: ${buildTool}")
    }
}
