### 5. Microservices com Spring Boot

#### 5.1. Arquitetura de Microservices

Cada vez mais as empresas estão aderindo a arquitetura de microservices
como uma nova opção para substituir a arquitetura monolítica, a qual se
baseia em vários módulos em um único sistema, ou seja, um grande bloco de
códigos onde estão presentes todas as regras de negócio e funcionalidades
da aplicação. Geralmente uma aplicação que foi construída em cima da
arquitetura monolítica costuma ter uma única base de dados utilizada e
acessada por todo o sistema.
Como um exemplo de aplicação com arquitetura monolítica, imagine um
sistema ERP, o qual tem como responsabilidades o controle de compra,
venda, finanças, contabilidade, entre outras operações dentro de uma
corporação. Cada uma dessas funcionalidades se baseia em um módulo,
porém todos esses módulos compõem uma única aplicação, sendo
fortemente acoplados e acessando a mesma base de dados, como pode ser
observado na imagem abaixo.

Compras --> DB1
Vendas --> DB1
Finanças --> DB1
Contábil --> DB1

Já a arquitetura de microservices é baseada na construção de uma
aplicação dividida em vários serviços menores, bem específicos e objetivos
sendo também independentes entre si. Então voltando ao exemplo do
sistema ERP, se considerar agora que esse mesmo sistema foi construído
utilizando a arquitetura de microservices, cada uma das funcionalidades
dessa aplicação seria um micro serviço independente e específico de acordo
com sua responsabilidade dentro do sistema, cada qual utilizando sua
própria base de dados, como pode ser observado na imagem abaixo.

Microservice Compras --> DB1
|
Microservice Vendas --> DB2
|
Microservice Finaças --> DB3
|
Microservice Contábil --> DB4

Quando é preciso fazer uma manutenção no sistema ou uma nova
implementação, seja corrigir um bug em produção ou inserir uma nova
funcionalidade, utilizando uma arquitetura de microservices esse processo
fica muito mais simples, pois não há a necessidade de parar todo o sistema e
sim, apenas o micro serviço em questão para fazer a correção ou
implementação. O serviço que ficará indisponível muitas vezes não afetará o
funcionamento dos demais e assim, os outros serviços que possuem
funcionalidades diferentes poderão continuar respondendo para seus
clientes normalmente.

Assim a disponibilidade da aplicação fica maior quando comparada com um
sistema construído no modo monolítico, o qual para realizar o mesmo
processo seria necessário parar a aplicação como um todo.

Escalar uma aplicação é um processo bem mais flexível e customizável
quando se utiliza microservices, pois é possível escalar apenas os serviços
mais acessados por exemplo, fazendo com que a aplicação apresente um
bom controle de performance. Se tratando de um sistema monolítico, não há
como fazer esse controle tão minucioso, é preciso escalar a aplicação como
um todo, e não apenas escalar somente os módulos mais demandados no
momento.

Outro ponto relevante é que na arquitetura de microservices, como cada
micro serviço costuma ter sua própria base de dados, caso ocorra alguma
alteração na modelagem de dados atual em algum dos serviços, tal
modificação não afeta os demais. Isso não acontece na arquitetura
monolítica, onde todos os módulos acessam a mesma base e assim ficam
passíveis de erros ou quebra de regras caso ocorram alterações que afetem
a modelagem de dados de certos módulos.

Outra vantagem da arquitetura em microservices é que cada micro serviço
pode ser construído utilizando a linguagem de programação que for mais
adequada para cada caso gerando um baixo acoplamento na aplicação, o
que é o mais adequado pelos padrões de projeto. Como os serviços são
independentes, um não precisa saber como o outro foi construído, apenas
precisam se comunicar quando houver necessidade independente da
linguagem. Quando se trata do estilo monolítico, o sistema como um todo
precisa ser construído em cima da mesma linguagem, já que não é possível
dividi-lo em módulos e assim a aplicação fica com um alto acoplamento.

Um ponto positivo da arquitetura monolítica é que para fazer o deploy da
aplicação em uma cloud basta gerar um único arquivo war ou jar. Na
arquitetura de microservices, o deploy a princípio pode parecer um pouco
mais robusto, já que a aplicação como um todo conta com vários serviços
cada qual com um deploy específico.

Porém, as plataformas cloud fornecem várias facilidades para esse processo,
como por exemplo, o uso de pipelines que depois de configuradas geram
deploys automáticos a cada push no git em um determinado ambiente.
Assim, depois de configurada uma vez, o deploy desses microservices passa
a ser algo mais simples e de fácil controle, porém é preciso seguir as boas
práticas e ferramentas que as plataformas cloud oferecem para facilitar e
controlar esses processos.

### 5.2. Comunicação entre Microservices

Na arquitetura de microservices os serviços são independentes entre si,
porém na maioria das vezes há a necessidade da comunicação entre eles.
Dentre as formas mais utilizadas para essa comunicação estão a
comunicação através do protocolo HTTP utilizando de API’s REST por
exemplo, e a comunicação através do protocolo AMQP, utilizando de
mensagerias.

O tipo de comunicação entre os microservices a ser utilizado nesse tipo de
arquitetura deve ser definido de acordo com o funcionamento do sistema e
das principais necessidades. No caso de sistemas síncronos pode ser utilizado
a comunicação pelo protocolo HTTP criando uma API para comunicação
utilizando os padrões JSON ou XML, e neste caso, a comunicação é feita entre
dois serviços, onde o requisitante necessita receber um retorno do serviço
requisitado para completar seu processo.

Já em sistemas que funcionam de forma assíncrona a maneira mais
apropriada de comunicação é por mensagerias através do protocolo AMQP,
casos em que a comunicação é feita para a entrega de uma mensagem de
um serviço para outro, não necessitando de retornos, apenas a garantia de
entrega de tal mensagem.

### 5.3. Exemplo de Microservices com Spring Boot

Como o processo de iniciar uma aplicação com Spring Boot se tornou algo
bem simples e rápido, as empresas optam por utilizar deste framework para
construir essa arquitetura de microservices, onde além do Spring Boot trazer
essa elevada produtividade a princípio, a plataforma Spring já conta com
vários projetos prontos para serem utilizados em sistemas distribuídos,
permitindo com que aplicações desde as mais simples até as mais complexas
sejam construídas com base nesse framework.

O projeto Spring Cloud possui vários sub projetos específicos para diversas
funcionalidades em um sistema distribuído. Dentre eles, o Spring Cloud
Gateway para criação de um gateway da aplicação, Spring Cloud Netflix
Eureka ou Spring Cloud Consul que são serviços de descoberta de
microservices na arquitetura e o Spring Cloud Stream, que fornece suporte
para mensageria como por exemplo RabbitMQ e Apache Kafka. A lista
completa de todos os projetos Spring Cloud pode ser visualizada neste link
https://spring.io/projects/spring-cloud.

Como exemplo prático, vamos considerar uma aplicação de controle de
produtos que disponibiliza de API’s para que uma aplicação front-end com
Angular possa construir a interface de um sistema que mostra a lista de
produtos de uma determinada loja online e também, qual a unidade que
possui estoque de tal produto a pronta entrega.

Para isso, primeiramente é preciso construir no back-end uma aplicação que
retorne essas API’s de produtos com os detalhes do estoque. Pensando em
sistema distribuído, a princípio já é possível dividir essa aplicação em três
serviços específicos e independentes, um para controle de produtos, outro
para controle de estoque e um para centralização das entradas na aplicação
e autenticação (Gateway).

Neste caso, quando o serviço de controle de produtos recebe uma requisição
para retornar ao cliente (aplicação angular), seja a listagem de produtos ou
os detalhes de um produto específico, ele precisa consultar os dados de
estoque que são de responsabilidade do serviço controle de estoque, já que
como são serviços diferentes, cada um possui sua própria base de dados.

Assim, analisando o funcionamento dessa aplicação em termos de
comunicação, o serviço controle de produtos envia internamente uma
requisição para o serviço controle de estoque esperando um retorno deste
com os dados necessários. Neste caso, como o sistema se caracteriza
síncrono o tipo de comunicação mais apropriado seria utilizando o protocolo
HTTP, onde através de uma requisição GET via HTTP REST o serviço controle
de produtos envia ao serviço controle de estoque uma requisição pedindo os
detalhes de estoque para esse produto. Tal fluxo pode ser visualizado na
imagem abaixo.

Assim, quando o serviço controle de estoque retornar a informação ao
controle de produtos, este irá finalizar seu processamento, completar a
resposta e retornar ao cliente a listagem de produtos com os detalhes de
estoque.

Cada um desses microservices podem ser construídos como sendo uma
aplicação Spring Boot e tanto o serviço controle de produtos quanto o serviço
controle de estoque devem contar com uma API REST similar à que foi
construída no capítulo 4 deste livro, que disponibiliza endpoints de seus
recursos. Assim, tanto a aplicação Angular quanto os próprios serviços
internos entre si poderão enviar e receber requisições utilizando o protocolo
HTTP.

O Spring Cloud pode ser utilizado para fazer o serviço gateway com Spring
Cloud Gateway por exemplo, utilizar o Spring Netflix Eureka ou Spring Cloud
Consul para descobertas de serviços e Spring Cloud Config para
configurações. Utilizar também o Spring MVC já que cada um desses
microservices (controle de estoque e produtos) serão aplicações web e o
Spring Data para comunicação/transação com banco de dados, entre
outros módulos da plataforma Spring.

Para mais detalhes desses projetos Spring Cloud aplicados a arquitetura de
Microservices, segue um vídeo com esse conteúdo completo que pode ser
acessado pelo link: https://youtu.be/LW-N44fZ1wk.