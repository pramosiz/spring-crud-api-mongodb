pipeline {
    agent any

    stages {

        stage('Read pom.xml') {
            steps {
                echo '*******************'
                echo 'Reading pom.xml ...'
                echo '*******************'
                script {
                    pom = readMavenPom(file: 'pom.xml')
                    env.DOCKER_IMAGE_NAME = pom.getName()
                    env.DOCKER_IMAGE_VERSION = pom.getVersion()
                }
                echo "Building ${DOCKER_IMAGE_NAME}:${DOCKER_IMAGE_VERSION}"
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
