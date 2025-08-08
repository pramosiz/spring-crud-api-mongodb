pipeline {
    agent any

    environment {
        POM = readMavenPom(file: 'business-domain/mongo-api/pom.xml')
        DOCKER_IMAGE_NAME = POM.getName()
        DOCKER_IMAGE_VERSION = POM.getVersion()
    }

    stages {

        stage('Read pom.xml') {
            steps {
                sh '''#!/bin/bash
                    echo '*******************'
                    echo 'Reading pom.xml ...'
                    echo '*******************'
                    '''
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
