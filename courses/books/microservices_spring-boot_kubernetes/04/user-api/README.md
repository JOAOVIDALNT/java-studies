## Oque desenvolvi nesse capítulo?

-


### Anotações

Para configurar a aplicação para acessar o banco de dados, será necessário
adicionar três novas dependências. A primeira é o spring-boot-starter-data-jpa,
que é a versão do Spring Data já pronta para ser utilizada com o Spring Boot. A
segunda é o org.flywaydb, que faz as migrações do banco de dados. Se você não
conhece as migrações, o box a seguir apresenta esse conceito. A última
dependência é o org.postgresql, que possui o conector para o PostgreSQL. Essas
configurações são iguais para os três microsserviços.

#### Migrações
A ideia de migrações é manter as mudanças do modelo de dados versionadas e
reproduzíveis. A atualização de banco de dados sempre foi um problema, já que
os scripts normalmente não são mantidos junto ao código-fonte da aplicação e a
aplicação deles era feita de forma manual. Com as migrações, os scripts são
mantidos junto ao código-fonte e as mudanças são aplicadas no banco de dados
automaticamente assim que a aplicação for implantada. Neste livro usaremos o
Flyway (https://flywaydb.org) para o gerenciamento de migrações.

Vamos usar o conceito de migrações para a criação do banco de dados. Para isso,
devemos criar um arquivo sql dentro da pasta /src/main/resources/db/migrations,
com o nome V1__create_user_table.sql. O V1 é para indicar a ordem dos scripts,
o que é importante porque sempre que subirmos a nossa aplicação o Spring
verificará se uma migração já foi aplicada no banco de dados; se sim, a migração
será ignorada, caso contrário, ela será executada no banco de dados. Por
enquanto teremos apenas uma migração, mas nos próximos capítulos
acrescentaremos mais scripts para explicar melhor como funciona o processo de
migrações.