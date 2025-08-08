pipeline {
    agent any

    environment {
        MONGO_API_DIR = 'business-domain/mongo-api'
        MODULE_PATH = '${MONGO_API_DIR}/pom.xml'
        POM = readMavenPom(file: "${MODULE_PATH}")
        DOCKER_IMAGE_NAME = POM.getName()
        DOCKER_IMAGE_VERSION = POM.getVersion()
    }

    stages {

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

        stage('Generate Docker image') {
            steps {
                sh  '''#!/bin/bash
                    echo '************************'
                    echo 'Generate Docker image...'
                    echo '************************'
                '''
                sh '''
                    cd ${MONGO_API_DIR}
                    docker build -t ${DOCKER_IMAGE_NAME}:${DOCKER_IMAGE_VERSION} .
                    docker tag ${DOCKER_IMAGE_NAME}:${DOCKER_IMAGE_VERSION} ${DOCKER_IMAGE_NAME}:latest
                    docker save ${DOCKER_IMAGE_NAME}:latest -o ${DOCKER_IMAGE_NAME}-${DOCKER_IMAGE_VERSION}.tar.gz
                    docker rmi ${DOCKER_IMAGE_NAME}:${DOCKER_IMAGE_VERSION}
                    docker rmi ${DOCKER_IMAGE_NAME}:latest
                '''
                echo "Docker image ${DOCKER_IMAGE_NAME}:${DOCKER_IMAGE_VERSION} generated successfully."
            }
        }
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