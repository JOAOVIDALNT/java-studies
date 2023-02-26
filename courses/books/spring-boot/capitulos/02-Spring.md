### 2. Plataforma Spring

O Spring consiste em uma plataforma completa de recursos para construção
de aplicativos Java, que veio para simplificar o desenvolvimento em Java EE
com diversos módulos que auxiliam na construção de sistemas reduzindo
muito o tempo de desenvolvimento.
Essa plataforma conta com recursos avançados que abrangem várias áreas
de uma aplicação com projetos/módulos prontos para uso, como:

• Spring Framework;
• Spring Boot;
• Spring Web;
• Spring Security;
• Spring Data;
• Spring Batch;
• Spring Cloud;
• outros.

Para visualizar e conhecer todos os projetos disponíveis na plataforma Spring,
basta acessar o site Spring.io e conferir a lista completa através do link
https://spring.io/projects.
Com esses projetos é possível construir aplicativos com funcionalidades
avançadas e com uma produtividade muito maior, podendo focar mais nas
regras de negócios e deixar as configurações de baixo nível por conta do
Spring.

### 2.1 Spring Framework 

O Spring Framework é o projeto base para todo o ecossistema Spring e é
dividido em 7 grupos:

• Core Container;
• Data Access/Integration;
• Web;
• Aspect Oriented Programming (AOP);
• Instrumentation;
• Messaging;
• Test.

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
construídos sobre o Core Container do Spring Framework, em destaque na
imagem abaixo.

Como o projeto Spring Framework possui o módulo Core Container, onde está
implementado a Inversão de Controle que utiliza da Injeção de Dependência,
ele se torna o projeto essencial para iniciar uma aplicação sendo assim a
base de toda a plataforma Spring.
Talvez esse último parágrafo tenha ficado um pouco difícil de entender diante
dessas terminologias. Primeiramente é preciso entender que todo framework
é a aplicação de uma Inversão de Controle. Mas no que consiste essa
Inversão de Controle afinal?

### 2.2. Inversão de Controle

Inversão de Controle (IoC - Inversion of Control) é um processo em que um
objeto define suas dependências sem criá-los. Este objeto delega a tarefa
de construir tais dependências para um contêiner IoC.

Por exemplo, vamos considerar que temos duas classes, A e B, onde a classe
A possui uma dependência da classe B, já que ela utiliza um método de B.
Assim, a classe A sempre teria que criar uma nova instância da classe B para
que assim pudesse utilizar seu método, como mostra na imagem abaixo.

public class A {
    private B b;

    public void meotodoA() {
        b = new B();
        b.metodoB()
    }
}

Porém, quando se utiliza a Inversão de Controle, a classe A não precisa se
preocupar em criar uma instância de B, pois essa responsabilidade passa a
ser do container do Spring Framework que realiza essa Inversão de Controle
através da Injeção de Dependência. E o que seria a Injeção de Dependência
afinal?

### 2.3. Injeção de Dependência

A Injeção de Dependência consiste na maneira, ou seja, na implementação
utilizada pelo Spring Framework de aplicar a Inversão de Controle quando for
necessário.
A Injeção de Dependência define quais classes serão instanciadas e em quais
lugares serão injetadas quando houver necessidade. Assim, basta que a
classe A crie um ponto de injeção da classe B, pelo construtor por exemplo, e
quando houver a necessidade o container do Spring Framework irá criar uma
instância da classe B para que a classe A possa utilizar o método
b.metodoB(), como mostra na imagem abaixo.

public class A {
    private B b;

    public A(B b) {
        this. = b;
    }

    public void metodoA() {
        b.metodoB();
    }
}


### 2.4. Core Container

O Spring Framework utiliza da Injeção de Dependência para aplicar a
Inversão de Controle no sistema e toda essa implementação está presente
no Core Container, onde fica a base de configuração do Spring Framework.
Quando a aplicação é executada, o Core Container é iniciado, as
configurações da aplicação pré-definidas em classes ou arquivos XML são
lidas e as dependências necessárias são definidas e criadas através da IoC
e destruídas quando não mais forem utilizadas. Essas dependências são
denominadas beans dentro do contexto do Spring, que consistem em objetos
os quais possuem seu ciclo de vida gerenciado pelo container de IoC/ID do
Spring. Esses passos definem o ciclo de vida de um Container, como pode ser
mostrado também na imagem abaixo.

### 2.5. Beans

Como foi dito anteriormente, um bean consiste em um objeto que é
instanciado, montado e gerenciado por um contêiner do Spring através da
Inversão de Controle (IoC) e Injeção de Dependências.
Assim como o container, um bean também tem seu ciclo de vida, o qual é
iniciado e criado pelo container, as dependências desse bean são injetadas,
o método de inicialização é chamado e então, o bean assim é enviado para
o cliente, no caso a classe que possui essa dependência, para ser utilizado e
em seguida descartado.
Na prática, utilizando o exemplo anterior, quando o container é instanciado
ele cria uma instância da classe B, chama o construtor da classe A para injetar
esse bean e em seguida, a classe A utiliza esse bean através de b.metodoB().
Esse bean então é descartado quando não mais utilizado e tal ciclo pode ser
visualizado na imagem abaixo.

### 2.6. Configurando Beans no Spring

É preciso que o Spring conheça quais as classes da aplicação serão beans
gerenciados por ele para que então seja aplicada a IoC/ID. Para isso há duas
maneiras de configurar e determinar esses beans, utilizando configurações
em arquivos XML ou através de anotações.
Na configuração por XML, não muito utilizada hoje em dia, é preciso definir
tags <bean> dentro de uma tag principal <beans> passando o path da
classe, assim o Spring saberá quais classes ele irá gerenciar a criação de
instâncias e a injeção de suas dependências.
#
<?xml version="1.0" encoding="UTF-8>
<beans xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
xmlns="http://www.springframework.org/schema/beans"
xsi:schemaLocation="http://www.springframework.org/schema/beans
http://www.springframework.org/schema/beans/spring-beans.xsd">

<bean class="com.example.springboot.Produto">
<bean class="com.example.springboot.ProdutoController">
<bean class="com.example.springboot.ProdutoService">
<bean class="com.example.springboot.ProdutoRepository">

</beans>
#
Na configuração por anotações, é possível utilizar os estereótipos do Spring
para determinar de forma mais objetiva e específica qual o tipo de bean será
cada classe. Há quatro principais tipos:
#
• @Component;
• @Service;
• @Controller;
• @Repository.
#
Assim, ao anotar determinada classe com algum desses estereótipos, o
Spring entende que tal classe é um bean e será gerenciada por ele. Abaixo
seguem alguns exemplos de beans utilizando configuração por anotações.
#
Exemplo 1: Bean do tipo Component
@Component
public class Product {
    private String name;
    private BigDecimal value;
    //... getters and setters
}
#
Exemplo 2: Bean do tipo Service
@Service
public class ProductService {
    // business rules
}
#
Exemplo 3: Bean do tipo Controller
@Controller
public class ProductController {
    // ... GET, POST, DELETE, UPDATE methods
}
#
Exemplo 4: Bean do tipo Repository
@Repository
public class ProductRepository {
    // database transaction methods
}
#
Considerando que os beans gerenciados pelo Spring já foram definidos a
próxima questão é entender como o Spring saberá onde injetar as instâncias
que ele irá criar com suas dependências. Para isso é preciso criar os pontos
de injeção, que consistem em uma maneira de entregar as dependências ao
objeto que necessita. Os dois tipos de pontos de injeção mais comuns são os
construtores e setters, os quais podem ser visualizados nos exemplos abaixo.
#
Exemplo 5: Ponto de Injeção pelo método Construtor
@Service
public class ProductService {
    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
// business rules
}
#
Exemplo 6: Ponto de Injeção pelo método Setter
@Service
public class ProductService {
    private ProductRepository productRepository;
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
// business rules
}
#
Dentro do Spring, há uma outra maneira de se criar pontos de injeção de
forma automática, utilizando a anotação @Autowired, como mostra o
Exemplo 7.
#
Exemplo 7: Ponto de Injeção utilizando @Autowired
@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;
    // business rules
}
#
O ciclo de vida de um bean depende do seu escopo, que pode ser
determinado no Spring através da anotação @Scope. Os tipos de escopos
do Spring utilizados para web são:
#
• Singleton;
• Prototype;
• Request;
• Session;

Assim, é possível determinar se um bean será do tipo singleton por exemplo,
ou seja, o container irá criar uma única instancia desse bean que será
utilizada para todas as solicitações da instancia.
Se o bean for configurado como prototype o container irá criar várias
instancias, uma para cada solicitação. O bean com escopo do tipo request
terá uma instancia criada para cada solicitação HTTP e por fim, o bean com
escopo session terá sua instancia preservada e utilizada pelas solicitações
enquanto durar a sessão.
#
2.7. @Bean - Métodos Produtores
#
Quando é preciso que uma classe externa da aplicação seja um bean
gerenciado pelo Spring, é preciso primeiramente criar um método produtor
dentro da classe de configuração do Spring, que irá retornar tal classe
externa que será gerenciada pelo container do Spring. E para configurar essa
classe como sendo um bean, é preciso anotar tal método com @Bean, assim
é possível criar pontos de injeção e o Spring irá controlá-la como sendo
qualquer outro bean dentro da aplicação.
#
Exemplo 8: Método produtor com @Bean
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
