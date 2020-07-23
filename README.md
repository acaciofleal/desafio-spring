# desafio-spring

-- Desenvolvido com Spring Framework (Maven, Spring Boot, JPA, Validation API, Sprint Data - Criteria API + CRUD Repository, Http Client, Model Mapper)
--- Executar "Run As" ou "Debug As" Java Application a classe DesafioSpringApplication.java
-- As APIs estão expostas para visualização no link: http://localhost:8080/desafiospring/swagger-ui.html e são:
---- /pessoa (GET) - Consulta de Pessoa por filtros: Nome , cpf. Retorno paginado.
---- /pessoa (POST) - Cadastro de uma nova Pessoa com todos nome, cpf e data de nascimento
---- /pessoa/{id} (GET) - Recuperar de forma detalhada todas as informações de uma Pessoa por ID
---- /pessoa/{id} (PUT) - Alterar parcial ou totalmente as informações de uma Pessoa por ID
---- /pessoa/all (GET) - Recupera todos as Pessoa sem filtros;