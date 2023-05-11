build:
  mvn -DskipTests clean package

run:
  mvn -DskipTests spring-boot:run

test-run:
  mvn -DskipTests spring-boot:test-run

# Stop and remove all containers started by Testcontainers
stop-remove:
  docker ps --filter "label=org.testcontainers=true" -aq | xargs docker stop | xargs docker rm