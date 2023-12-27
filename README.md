# Nunes Sports

Aqui nesse projeto você é capaz de adicionar um produto, edita-lo, listar todos os produtos existentes no banco de dados e pode realizar a exclusão de um produto.

## Ferramentas que utilizei

 - Linguagem de programação Java
 - Spring Boot
 - Spring Data JPA (utilizando o banco MySQL)
 - Lombok
 - Thymeleaf
 - Bootstrap

### Modificar o application.properties

Você deve fazer a alteração do `spring.datasource.username` e `spring.datasource.password`.

```
spring.jpa.hibernate.ddl-auto=update
spring.datasource.url=jdbc:mysql://localhost:3306/db_nunes_sports
spring.datasource.username=root
spring.datasource.password=password
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
#spring.jpa.show-sql: true
```