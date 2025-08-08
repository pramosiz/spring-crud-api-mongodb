pipeline {
    agent any

    stages {

        stage('Read pom.xml') {
            steps {
                echo '*******************'
                echo 'Reading pom.xml ...'
                echo '*******************'
                script {
                    pom = readMavenPom(file: 'business-domain/mongo-api/pom.xml')
                    env.DOCKER_IMAGE_NAME = pom.getName()
                    env.DOCKER_IMAGE_VERSION = pom.getVersion()
                }
                echo "Building ${DOCKER_IMAGE_NAME}:${DOCKER_IMAGE_VERSION}"
            }
        }

        stage('Environment check') {
			steps {
				echo '*******************'
				echo 'Environment check...'
				echo '*******************'
				echo '----- All environment variables:'
				sh   'printenv | sort'
				echo '----- Jenkinsfile environment variables:'
				echo "DOCKER_IMAGE_NAME=${DOCKER_IMAGE_NAME}"
				echo "DOCKER_IMAGE_VERSION=${DOCKER_IMAGE_VERSION}"
				echo '----- Other checks...'
				sh   '''#!/bin/bash
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
