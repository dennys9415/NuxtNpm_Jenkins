pipeline {
    agent { label 'linux' }

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
                echo "the image that is build is dennys9415/draft:dev"

                script {
                    gv.build()
                }
            }        
        }
        stage('Login') {
            steps{
                echo 'Login to the Docker Hub Account'
                echo "Docker Hub Account owned by Dennys"
//                sh 'echo $DOCKER_CRED_PSW | docker login -u $DOCKER_CRED_USR --password-stdin'
                script {
                    gv.login()
                }
            }        
        }
        stage('Push') {
            steps{
                echo 'Pushing the App in a Docker Image'
//                sh 'docker push lcubestudios/messaging_backend:latest'
                script {
                    gv.push()
//                    gv.logout()
                }
            }        
        }
//        stage('SSH') {
//            steps{
//                echo 'command with ssh'
//                sh "ssh root@45.79.139.42 '/home/messaging_backend/staging/script.sh'"
//            }        
//        }
    }
    post {
        always{
            echo 'Login Out of the Account'
            sh 'docker logout'
//            script {
//               gv.logout()
//            }
//
        }
    }
}
