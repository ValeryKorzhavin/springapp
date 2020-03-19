
.DEFAULT_GOAL := build-run

run:
	java -jar ./target/springapp-*.jar

clean:
	rm -rf ./target

build-run: build run

build:
	./mvnw clean package

update:
	./mvnw versions:update-properties versions:display-plugin-updates

test:
	./mvnw clean test

apply-migration:
	 ./mvnw clean compile liquibase:update -DskipTests=true
