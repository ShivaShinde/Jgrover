pipeline {
    agent any
    stages {
        stage('Compile stage') {
            steps {
                maven(maven: 'Maven_3.5.3') {
                    bat "mvn -version"
                }
            }
        }
    }
}
