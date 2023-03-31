## Oque desenvolvi nesse capítulo?

- Criamos o projeto spring boot do zero, adicionando parent, dependencia e setando a classe de inicialização
- Criamos a classe DTO e Controller para manipular users instanciados em uma lista na controller


### Anotações

#### Protocolo HTTP

O HTTP é o principal protocolo da Web, ele define como deve ser feita uma
requisição para uma aplicação, incluindo a URL, os parâmetros, os cabeçalhos e
o tipo de resposta esperado. Os serviços que seguem o protocolo HTTP devem
ser configurados com um verbo, que indica qual é o comportamento esperado do
serviço. Os verbos HTTP mais utilizados são:

> GET: os métodos GET devem recuperar dados, não afetando o estado da
aplicação. Podem receber parâmetros, mas estes devem ser utilizados
apenas para a recuperação de dados, nunca para uma atualização ou
inserção.

> POST: os métodos POST enviam dados para o servidor para serem
processados. Os dados vão no corpo da requisição e não na URL.
Normalmente são utilizados para criar novos recursos no servidor.

> PATCH: funciona de modo simular ao POST, mas deve ser utilizado para
atualizar as informações no servidor e não para novos registros.

> DELETE: utilizado para excluir elementos do servidor. 