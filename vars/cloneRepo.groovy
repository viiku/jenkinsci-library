def call(String repoUrl, String branch = 'main') {

    try {
        echo "Cloning repository: ${repoUrl} on branch: ${branch}"
        
        checkout([
            $class: 'GitSCM',
            branches: [[name: "*/${branch}"]],
            userRemoteConfigs: [[url: repoUrl]]
        ])
    } catch (Exception e) {
        println("Failed to clone repository: ${e.message}")
    }

}
