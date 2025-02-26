pipeline {
    agent any
    triggers { 
      githubPush() 
   }
    environment {
        DOCKER_IMAGE_NAME = 'dhruvikpatel48/calculator'
        GITHUB_REPO_URL = 'https://github.com/LazyShot-stack/CalculatorSPE.git'
    }

    stages {
        stage('Checkout') {
            steps {
                script {
                     git branch: 'master', url: "${GITHUB_REPO_URL}", credentialsId: "GithubCred"
                }
            }
        }

           stage('Run Unit Tests') {
            steps {
                script {
                    sh 'mvn test -Dtest=MyTest'
                }
            }
        }
        stage('Clean & Build Java Project') {
            steps {
                script {
                    sh 'mvn clean package'
                }
            }
        }

        stage('Build Docker Image') {
            steps {
                script {
                    // Build Docker image
                    docker.build("${DOCKER_IMAGE_NAME}", '.')
                }
            }
        }

        stage('Push Docker Images') {
            steps {
                script{
                    docker.withRegistry('', 'DockerHubCred') {
                    sh 'docker push dhruvikpatel48/calculator'
                    }
                 }
            }
        }

     stage('Run Ansible Playbook') { 
        steps {
            script {
              withEnv(["ANSIBLE_HOST_KEY_CHECKING=False"]) {   
                ansiblePlaybook(
                    playbook: 'deploy.yaml',
                    inventory: 'inventory'
                )
            }
        }
    }
 }
}
 post {
        success {
            mail to: 'dhruvikpatel48@gmail.com',
                 subject: "Application Deployment SUCCESS: Build ${env.JOB_NAME} #${env.BUILD_NUMBER}",
                 body: "The build was successful!"
        }
        failure {
            mail to: 'dhruvikpatel48@gmail.com',
                 subject: "Application Deployment FAILURE: Build ${env.JOB_NAME} #${env.BUILD_NUMBER}",
                 body: "The build failed."
        }
        always {
            cleanWs()
        }
      }
    }
