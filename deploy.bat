.\gradlew bootBuildImage
docker image save docker.io/library/rapid-fullstack-demo:0.0.1-SNAPSHOT | docker -H "ssh://root@116.202.111.54" image load
ssh root@116.202.111.54 docker-compose up -d
pause