docker build -t jenkins-pablo:v1.0 -f infrastructure/jenkins/Dockerfile infrastructure/jenkins/.
docker run -d \
  --name jenkins \
  -p 8090:8090 \
  -p 50000:50000 \
  -e JENKINS_OPTS="--httpPort=8090" \
  -v /Users/pabloramosizquierdo/Desktop/Pablo/Dockers/Jenkins/jenkins_home:/var/jenkins_home \
  jenkins-pablo:v1.0