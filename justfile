build:
  mvn -DskipTests clean package

run:
  mvn -DskipTests spring-boot:run

test-run:
  mvn -DskipTests spring-boot:test-run 