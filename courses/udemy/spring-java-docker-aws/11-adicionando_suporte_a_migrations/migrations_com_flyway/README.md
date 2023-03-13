### Migrations

> executar as migrations sem subir a aplicação: 'mvn clean package spring-boot:run -DskipTests'


> após adicionar o plugin de flyway ao pom, basta executar no terminal o comando 'mvn flyway:migrate' para executar a migração do banco de dados sem precisar subir a aplicação
> - um problema comum na migração com flyway é o hashcode não equivaler com o disposto no banco de dados, podendo ocorrer apenas por um espaço a mais ou a menos

> no ambiente de testes não é problema apagar a tabela e iniciar uma nova migração do zero, caso seja necessário é possivel se aprofundar em migrações.