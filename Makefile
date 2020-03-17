
.DEFAULT_GOAL := build

clean:
	rm -rf ./target

build:
	./mvnw clean package

update:
	./mvnw versions:update-properties versions:display-plugin-updates

test:
	./mvnw clean test

generate-migration:
	 ./mvnw clean compile liquibase:update -DskipTests=true
