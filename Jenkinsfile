pipeline {
    agent { label 'lcubes-demo-server' }

    options {
    buildDiscarder(logRotator(numToKeepStr: '5'))
    }

    environment {
        DOCKER_CRED = credentials('dennys9415-docker')
    }
    stages {
        stage('Init') {
            steps{
                echo "loading the function file"
                script{
                    gv = load "script.groovy"
                }                
            }        
        }
        stage('Build') {
            steps{
                echo "making the building of a new image"
                //echo "the image that is build is dennys9415/draft:dev"
                script {
                    gv.build()
                }
            }        
        }
        stage('Login') {
            steps{
                echo 'Login to the Docker Hub Account'
                //echo "Docker Hub Account owned by Dennys"
                script {
                    gv.login()
                }
            }        
        }
        stage('Push') {
            steps{
                //echo 'Pushing the App in a Docker Image'
                script {
                    gv.push()
                }
            }        
        }
//        stage('SSH') {
//            steps{
//                echo 'command with ssh'
//                script {
//                    gv.ssh()
//                }
//            }        
//        }
        stage('GitHub') {
            steps{
                //echo 'Pushing the App in a Docker Image'
                script {
                    gv.gitHub()
                    script2.sh
                }
                echo 'Done!'
            }        
        }
    }
    post {
        always{
            echo 'Login Out of the Account'
            sh 'docker logout'
        }
    }
}
