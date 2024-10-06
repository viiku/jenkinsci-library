def call(String testTool = 'maven') {
    echo "Running tests using ${testTool}"

    if (testTool == 'maven') {
        sh 'mvn test'
    } else if (testTool == 'gradle') {
        sh './gradlew test'
    } else {
        error("Unsupported test tool: ${testTool}")
    }
}
