pipeline {
    agent any
    stages {
        stage('Initialize') {
            steps {
                sh '''
               java -version
               echo "running some echo commands"
               echo "PATH = ${PATH}"
               echo "M2_HOME = ${M2_HOME}"
               mvn --version 
               '''
            }
        }
    }}

//        tools {
//            maven 'Maven_3.5.3'
//        }
//
//        stage('Compile Stage') {
//            steps{
//                bat "mvn clean compile"
//                }
//            }
//        }
