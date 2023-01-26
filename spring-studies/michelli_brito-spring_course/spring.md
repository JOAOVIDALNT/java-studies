### Spring Framework

O Spring Framework é o projeto base para todo o ecossistema Spring e é
dividido em 7 grupos:

- Data access / integration
JDBC, ORM, OXM, JMS & Transactions

- Web
WebSocket, Servelet, Web & Portlet

- Core container
Beans, Core, Context & SpEL

- Aspect Oriented Programming (AOP)
- Intrumentation
- Messaging
- Test

Dentro do grupo Core Container, estão os módulos responsáveis por conter
as partes fundamentais do framework, como as classes básicas e avançadas,
suas implementações e controle das definições em tempo de execução das
configurações por anotações ou arquivos XML.

O módulo Data Access/Integration é o responsável por prover
funcionalidades para transações com o banco de dados. O módulo Web
contém os recursos para uma aplicação web, como a implementação do
MVC, Web Services REST, entre outros.

O módulo AOP fornece a implementação para programação orientada a
aspectos, o módulo Instrumentation fornece implementações de
instrumentação e por fim o módulo Messaging contém implementação e
suporte para programação baseada em mensagens.

O módulo Test possui o suporte para os testes unitários utilizando JUnit e
testes de integração.

Todos os módulos citados acima, com exceção do módulo Test, são
construídos sobre o Core Container do Spring Framework.

#### Inversão de controle

Primeiramente é preciso entender que todo framework
é a aplicação de uma Inversão de Controle. Mas no que consiste essa
Inversão de Controle afinal?

- Inversão de controle (IoC) é um padrão de projeto, em que um objeto apenas declara suas dependências sem cria-las e delega a tarefa de construir tais dependências a um Container IoC (Core Container)

> Inversão de controle é algo abstrado, um padrão de projeto. O spring vai implementar isso na prática com a injeção de dependências

#### Injeção de dependência 
- Injeção de dependência é a implementação utilizada pelo Spring Framework de aplicar a inversão de controle quando necessário.

> Implementação da inversão de controle no Core Container

#### Bean 
- Bean é um objeto que é instanciado, montado e gerenciado por um container do Spring através da inversão de controle (IoC) e injeção de dependências.

> Exemplos de esteriótipos do Spring: @Component, @Service, @Repository, @Controller.
> @Repository para persistir dados, @Controller para criar endpoints @Service para serviços e @Component que é algo mais genérico, se encaixa em todas essas situações.

O Bean determina ao Spring a responsábilidade dele sobre o gerenciamento da classe anotada.

Considerando que os beans gerenciados pelo Spring já foram definidos a
próxima questão é entender como o Spring saberá onde injetar as instâncias
que ele irá criar com suas dependências. Para isso é preciso criar os pontos
de injeção, que consistem em uma maneira de entregar as dependências ao
objeto que necessita. Os dois tipos de pontos de injeção mais comuns são os
construtores e setters, os quais podem ser visualizados nos exemplos abaixo.

- Exemplo 5: Ponto de Injeção pelo método Construtor

@Service
public class ProductService {
    private ProductRepository productRepository;
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
 // business rules

}

- Exemplo 6: Ponto de Injeção pelo método Setter

@Service
public class ProductService {
    private ProductRepository productRepository;
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
 // business rules
}

Dentro do Spring, há uma outra maneira de se criar pontos de injeção de
forma automática, utilizando a anotação @Autowired, como mostra o
Exemplo 7.

- Exemplo 7: Ponto de Injeção utilizando @Autowired

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

 // business rules
}

O ciclo de vida de um bean depende do seu escopo, que pode ser
determinado no Spring através da anotação @Scope. Os tipos de escopos
do Spring utilizados para web são:

• Singleton;
• Prototype;
• Request;
• Session.

Assim, é possível determinar se um bean será do tipo singleton por exemplo,
ou seja, o container irá criar uma única instancia desse bean que será
utilizada para todas as solicitações da instancia.
Se o bean for configurado como prototype o container irá criar várias
instancias, uma para cada solicitação. O bean com escopo do tipo request
terá uma instancia criada para cada solicitação HTTP e por fim, o bean com
escopo session terá sua instancia preservada e utilizada pelas solicitações
enquanto durar a sessão.

Quando é preciso que uma classe externa da aplicação seja um bean
gerenciado pelo Spring, é preciso primeiramente criar um método produtor
dentro da classe de configuração do Spring, que irá retornar tal classe
externa que será gerenciada pelo container do Spring. E para configurar essa
classe como sendo um bean, é preciso anotar tal método com @Bean, assim
é possível criar pontos de injeção e o Spring irá controlá-la como sendo
qualquer outro bean dentro da aplicação.

- Exemplo 8: Método produtor com @Bean

@Configuration
public class AppConfig {
    @Bean
    public ExternalFile externalFile(){
        ExternalFile externalFile = new ExternalFile();
        return externalFile;
    }
}

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ExternalFile externalFile;
 // business rules
}

#### Spring Boot

Spring Boot = Spring Framework + Servidor Embutido (tomcat ou netty) - XML <bean> Configurations ou @Configuration

- Antes apenas com o Spring Framework, antes de rodar a aplicação era necessário configurar diversos aspectos como configurações e até definir um servidor servelet container para subir a aplicação. Hoje para inicar um projeto Spring Boot, basta uma dependência no arquivo pom.xml, spring-boot-starter, para que ele já traga internamente todas as dependências base do Spring Framework. 


