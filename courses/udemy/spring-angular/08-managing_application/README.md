### Application Properties
- O arquivo application.properties pode conter diferentes padrões de acordo com o ambiente
ex:
application-dev.properties -> para ambiente de desenvolvimento
application-prd.properties -> para ambiente de produção

#### Definir o nome da aplicação
> spring.application.name=MyApp
- também é possível utilizar a variavel de ambiente =${APP_NAME.default_name} | SET APP_NAME=name antes de rodar o jar

- ou definir via cli quando subir o jar java -jar spring-boot.....jar --spring.application.name=name
