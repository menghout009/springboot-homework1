pipeline {
     agent {
          label 'agent-spring'
     }
     environment{
          DOCKER_IMAGE = "spring-api"
     }
     tools{
          maven 'Maven'
     }
     stages{
            stage("Checkout") {
            steps {
                // Checkout the source code from the Git repository
                checkout scm
            }
        }
          stage("Build"){
               steps{
                    echo "Building..."
                    sh "mvn clean install -Dmaven.test.skip=true"

                    echo "Building Docker Image"
                    sh "docker build -t \${DOCKER_IMAGE} ."
               }
          }
          stage("Test"){
               steps{
                    echo " Ot Dg Test Mx Te *_*"
               }
          }
          stage("Deploy") {
               steps {
                    script {
                         def existingContainerId = sh(script: 'docker ps -aq -f name="${DOCKER_IMAGE}"', returnStdout: true)
                         echo "existingContainerId : ${existingContainerId}"
                         if (existingContainerId) {
                              echo "Removing existing container ${existingContainerId}"
                              sh "docker rm -f ${existingContainerId}"
                         } else {
                              echo "No existing container found."
                         }
                         echo "Deploying container..."
                         sh "docker run -d -p 8080:8080 --name \${DOCKER_IMAGE} \${DOCKER_IMAGE}"
                         sh "docker ps | grep \${DOCKER_IMAGE}"
                    }
               }
               }
     }
}