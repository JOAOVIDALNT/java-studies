### Planejamento

- [x] Conectar db
- [x] Tratar exceções
- [x] Implementar swagger
- [ ] Implementar DTO e Mapeamento
- [ ] Modificar gerenciamento de Status para Enum com strategy
- [ ] Implementar HATEOAS (?)
- [ ] Estudar e implementar Spring Security
- [ ] Estudar e implementar testes


#### Tratmento de exceções
- Utilizei handlers e uma exceção personalizada, implementei com a ajuda do artigo: https://www.linkedin.com/pulse/tratando-erros-e-exce%C3%A7%C3%B5es-com-spring-boot-tiago-perroni/?originalSubdomain=pt

#### Documentação Swagger
- Documentei utilizando o springdoc openapi, basta inserir a dependencia e ele já gera a documentação através dos endpoints de controller. Também é possível personalizar as informações do projeto no arquivo starter