### Content Negotioation

- O que é content negotiation?

é a capacidade do servidor rest de prover diferentes objetos: Json, xml, yml, csv, pdf, png, etc..

pode estar relacionado a idioma também, como por exemplo prover a response em diferentes idiomas.

> Server-driven -> quem define a capacidade de prover os serviços

> Agent-driven -> responsável por escolher como ele quer consumir, ou seja, quero consumir em json, yml ou csv. Sempre vai depender do que o servidor prove.

- Content negotiation é a capacidade de servir diferentes formatos da mesma informação

> implementaremos apenas a nível de formato: json, xml e yml.

> sobre content negotiation e suas implementações -> https://www.baeldung.com/spring-mvc-content-negotiation-json-xml


> ### Acesso via query param:
> http://localhost:8080/api/person/v1?mediaType=xml