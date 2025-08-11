docker run -d \
  --network mongo-api \
  -p 9090:9090 \
  -v ./infrastructure/prometheus/prometheus.yaml:/etc/prometheus/prometheus.yaml \
  -v /Users/pabloramosizquierdo/Desktop/Pablo/Tecnologias/Dockers/Prometheus/data:/prometheus \
  --name prometheus prom/prometheus:v3.5.0