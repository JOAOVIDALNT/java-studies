### Estrutura

- criaremos 3 microserviços
> user-api para cadastro de usuários

> product-api para cadastro de produtos

> shopping api para o serviço de compras

- depois trabalharemos na comunicação desses microsserviços

A user-api será responsável por manter os dados dos usuários da aplicação,
alguns serviços que estarão disponíveis nela serão a criação e exclusão de
usuários e a validação da existência de um usuário. A product-api conterá todos
os produtos cadastrados em nossa aplicação e terá serviços como cadastrar
produtos e recuperar informações de um produto, como preço e descrição.
Finalmente, a shopping-api será utilizada para o cadastro de compras na
aplicação. Assim, para realizar uma compra, a shopping-api receberá
informações sobre o usuário que está fazendo a compra e uma lista de produtos,
e todos esses dados precisarão ser validados na user-api e na product-api.

O desenvolvimento dos três microsserviços terá o mesmo padrão, que são as
camadas Controller, Service e Repository. Além disso, teremos as entidades que
representam as tabelas dos banco de dados e os Data Transfer Objects (DTO),
que são as classes utilizadas para receber e enviar informações entre os
microsserviços e também para o front-end. Todas essas camadas serão
explicadas no decorrer deste e dos próximos capítulos.

