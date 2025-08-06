docker run -d \
    -p 27017:27017 \
    -e MONGO_INITDB_ROOT_USERNAME=admin \
    -e MONGO_INITDB_ROOT_PASSWORD=admin \
    -v /Users/pabloramosizquierdo/Desktop/Pablo/Dockers/MongoDB/data:/data/db \
    --name mongodb mongodb/mongodb-community-server:6.0.10-ubi9