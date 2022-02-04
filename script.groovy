def build() {
    echo "the image that is build is dennys9415/draft:dev"
    //sh 'docker build -t dennys9415/draft:dev .'
    echo"creating folder dennyselgrandioso"
    sh 'mkdir dennyselgrandioso'
}

def login() {
    echo "Docker Hub Account owned by Dennys"
    //sh 'echo $DOCKER_CRED_PSW | docker login -u $DOCKER_CRED_USR --password-stdin'
}

def push() {
    echo 'Pushing the App in a Docker Image'
    //sh 'docker push dennys9415/draft:dev'
}

def ssh() {
    sh "ssh root@45.79.139.42 '/home/messaging_backend/staging/script.sh'"
}

def gitHub() {
    echo "GitHub Function running"
    //sh script_github.sh
    sh ./script2.sh
}

def logout() {
    echo 'Login Out of the Account'
    sh 'docker logout'
}

return this
