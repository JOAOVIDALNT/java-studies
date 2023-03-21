### Value Object

- Uma api basica, sem vo's expõe as mesmas entidades que representam a estrutura de tabelas do banco, um value object é uma classe intermediaria responsável pela exposição dos dados.

no método post enviavamos no body um json representando uma entidade, iremos substituir essa entidade por um value object. Na prática os clients nem precisarão conhecer a entidade.

> a estrutura do VO pode ser bem diferente da entidade, podendo ter atributos a menos ou a mais, após a requisição o VO é processado por uma classe adapter e convertido em uma entidade.

> Exemplo: uma tabela pode ter as colunas nome e sobrenome e o VO pode agrupar ambos os dados em um único atributo.
>
> Na prática: suponha que será necessário adicionar uma nova coluna a uma tabela no banco de dados, se a sua arquitetura expõe entidades e você faz isso, acaba quebrando todas as aplicações que consomem certos endpoints, com o VO você consegue expor uma alteração somente para clientes de uma nova versão e notificar os clientes de versões passadas para que atualizem o serviço.
- Veremos um exemplo disso quando aplicarmos o versionamento de api no próximo capítulo. Nele adicionaremos a coluna birthday na nossa tabela Person, gerando a v2 da nossa api e mantendo a v1 estável até que descontinuemos.

