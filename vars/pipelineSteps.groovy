import com.mycompany.jenkinslib.Repository

def call() {
    pipeline {
        agent any
        
        environment {
            REPO_URL = 'https://github.com/YOUR_ORG_NAME/YOUR_REPO_NAME.git'
            BRANCH = 'main'
            BUILD_TOOL = 'maven'   // Can be maven or gradle
            TEST_TOOL = 'maven'    // Can be maven or gradle
            DEPLOY_TOOL = 'default'  // Use default or other deploy tool
        }

        stages {
            stage('Clone') {
                steps {
                    script {
                        def repo = new Repository(env.REPO_URL, env.BRANCH, env.BUILD_TOOL, env.TEST_TOOL, env.DEPLOY_TOOL)
                        repo.cloneRepo(this)
                    }
                }
            }

            stage('Build') {
                steps {
                    script {
                        def repo = new Repository(env.REPO_URL, env.BRANCH, env.BUILD_TOOL, env.TEST_TOOL, env.DEPLOY_TOOL)
                        repo.buildRepo(this)
                    }
                }
            }

            stage('Test') {
                steps {
                    script {
                        def repo = new Repository(env.REPO_URL, env.BRANCH, env.BUILD_TOOL, env.TEST_TOOL, env.DEPLOY_TOOL)
                        repo.testRepo(this)
                    }
                }
            }

            stage('Deploy') {
                steps {
                    script {
                        def repo = new Repository(env.REPO_URL, env.BRANCH, env.BUILD_TOOL, env.TEST_TOOL, env.DEPLOY_TOOL)
                        repo.deployRepo(this)
                    }
                }
            }
        }
    }
}
