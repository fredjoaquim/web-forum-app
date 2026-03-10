# ForumHub API

API REST desenvolvida com Spring Boot para gerenciamento de tópicos de fórum.

## Tecnologias
- Java 21
- Spring Boot
- Spring Security
- JPA / Hibernate
- H2 Database

## Endpoints

GET /topicos
POST /topicos
GET /topicos/{id}
PUT /topicos/{id}
DELETE /topicos/{id}

## Autenticação

A API utiliza autenticação baseada em token Bearer.

## Execução

mvn spring-boot:run
