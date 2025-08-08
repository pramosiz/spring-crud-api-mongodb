pipeline {
    agent any

    environment {
        MODULE_PATH = 'business-domain/mongo-api/pom.xml'
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
