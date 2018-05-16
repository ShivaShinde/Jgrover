pipeline {
    agent any

tools {
        maven 'Maven_3.5.3'
    }

    stages {
        stage('Compile Stage') {
            steps{
                bat "mvn clean compile"
                }
            }
        }


}
