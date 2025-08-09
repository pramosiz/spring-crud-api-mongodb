pipeline {
    agent any

    environment {
        // It can't reference $ variables
        MONGO_API_DIR = 'business-domain/mongo-api'
    }

    stages {

        stage('Read pom.xml') {
            steps {
                sh '''#!/bin/bash
                    echo '*******************'
                    echo 'Reading pom.xml...'
                    echo '*******************'
                '''
                script {
                    env.MODULE_PATH = "${MONGO_API_DIR}/pom.xml"
                    def pom = readMavenPom(file: "${MODULE_PATH}")
                    env.DOCKER_IMAGE_NAME = pom.getName()
                    env.DOCKER_IMAGE_VERSION = pom.getVersion()
                }
                echo "Building ${DOCKER_IMAGE_NAME}:${DOCKER_IMAGE_VERSION}"
            }
        }

        stage('Environment check') {
			steps {
                sh '''#!/bin/bash
                    echo '*******************'
                    echo 'Environment check...'
                    echo '*******************'
                    '''
                sh '''#!/bin/bash
                    echo '----- All environment variables:'
                    printenv | sort
                    '''
                sh '''#!/bin/bash    
                    echo '----- Jenkinsfile environment variables:'
                    echo 'DOCKER_IMAGE_NAME=${DOCKER_IMAGE_NAME}'
                    echo 'DOCKER_IMAGE_VERSION=${DOCKER_IMAGE_VERSION}'
                '''
				echo '----- Other checks...'
				sh  '''#!/bin/bash
					echo "----- JAVA VERSION"
					java -version
					echo "----- MAVEN VERSION"
					mvn -version
					 ''' 
			}
		}

        stage ('Build') {
			steps {
                sh  '''#!/bin/bash
                    echo '*******************'
                    echo 'Building...'
                    echo '*******************'
                '''
                echo "Building ${DOCKER_IMAGE_NAME}:${DOCKER_IMAGE_VERSION}"
				sh "mvn -f ${MODULE_PATH} clean install -DskipTests"
			}
		}

		stage('Test') {
			steps {
                sh  '''#!/bin/bash
                    echo '*******************'
                    echo 'Testing...'
                    echo '*******************'
                '''
				echo "Testing ${DOCKER_IMAGE_NAME}:${DOCKER_IMAGE_VERSION}"
				sh "mvn -f ${MODULE_PATH} test"
			}
		}

        stage('SonarQube Analysis') {
            steps {
                sh  '''#!/bin/bash
                    echo '*********************'
                    echo 'SonarQube analysis...'
                    echo '*********************'
                '''
                withSonarQubeEnv('sonarqube-test') { // Same name in Manage Jenkins > Configure System
                    sh "mvn -f ${MODULE_PATH} sonar:sonar"
                }
            }
        }

        // TODO PRAMOSI: Fix Docker problem
        // stage('Generate Docker image') {
        //     steps {
        //         sh  '''#!/bin/bash
        //             echo '************************'
        //             echo 'Generate Docker image...'
        //             echo '************************'
        //         '''
        //         sh '''
        //             cd ${MONGO_API_DIR}
        //             docker build -t ${DOCKER_IMAGE_NAME}:${DOCKER_IMAGE_VERSION} .
        //             docker tag ${DOCKER_IMAGE_NAME}:${DOCKER_IMAGE_VERSION} ${DOCKER_IMAGE_NAME}:latest
        //             docker save ${DOCKER_IMAGE_NAME}:latest -o ${DOCKER_IMAGE_NAME}-${DOCKER_IMAGE_VERSION}.tar.gz
        //             docker rmi ${DOCKER_IMAGE_NAME}:${DOCKER_IMAGE_VERSION}
        //             docker rmi ${DOCKER_IMAGE_NAME}:latest
        //         '''
        //         echo "Docker image ${DOCKER_IMAGE_NAME}:${DOCKER_IMAGE_VERSION} generated successfully."
        //     }
        // }
    }

    post {
        success {
            echo "✅ Pipeline completado correctamente."
        }
        failure {
            echo "❌ Algo ha fallado en el pipeline."
        }
        always {
            echo "🔚 Pipeline finalizado."
        }
    }
}