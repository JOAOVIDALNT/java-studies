### 4. API REST com Spring Boot

#### 4.1. API REST e RESTful

API REST é uma aplicação cliente/servidor que envia e recebe dados através
do protocolo HTTP utilizando de padrões de comunicação como XML e JSON
e pode ser implementada na linguagem desejada. Uma API é desenvolvida
para permitir a interoperabilidade entre aplicações, por exemplo,
considerando dois sistemas, um desktop e um outro mobile, ambos podem
consumir a mesma API para montar suas interfaces, ou seja, a mesma API
pode ser utilizada por diferentes sistemas.
Uma API pode ser considerada RESTful quando ela utiliza em sua
implementação o conceito arquitetural REST. REST é algo abstrato, como um
modelo arquitetural enquanto que RESTful é algo mais concreto, como a
implementação deste modelo em alguma API. Então, para criar uma API
RESTful é preciso conhecer a arquitetura REST e também aplicá-la
corretamente.

### 4.1.1 Arquitetura REST

O modelo arquitetural REST nada mais é que um conjunto de boas práticas
para que determinado aplicativo possa ser construído e documentado de
uma maneira padronizada, fácil e que gere maior produtividade tanto para
os desenvolvedores na construção, quanto para o consumo desse aplicativo
por outros sistemas.

Um dos idealizadores desse modelo arquitetural foi Roy Fielding, que definiu
em sua tese de doutorado seis constraints, ou seja, regras que devem ser
obrigatoriamente seguidas para uma aplicação ser considerada RESTful.
A primeira constraint diz que uma aplicação, neste caso uma API, deve ser
cliente/servidor a fim de separar as responsabilidades. Já a segunda
constraint diz que essa aplicação deve ser stateless, ou seja, não guardar
estado no servidor, para que cada requisição que o cliente envia ao servidor
tenha informações relevantes e únicas para a resposta, assim independe qual
servidor irá responder esse cliente caso a aplicação esteja escalada em
múltiplos servidores, garantindo escalabilidade e disponibilidade.
A terceira constraint define que a aplicação deve ter a capacidade de
realizar cache para reduzir o tráfego de dados entre cliente e servidor. A
quarta constraint diz que a aplicação deve ter uma interface uniforme, onde
sua modelagem deve conter recursos bem definidos, apresentar hipermídias,
utilizar corretamente os métodos HTTP e códigos de retorno.
A definição da quinta constraint diz que o sistema deve ser construído em
camadas, ou seja, a possibilidade de escalar a aplicação em múltiplos
servidores. E por fim, a última constraint diz que a aplicação deve ter a
capacidade de evoluir sem a quebra da mesma, ou seja, código sob
demanda.

### 4.1.2. Tipos de Representações em REST

Uma API REST pode utilizar 2 padrões de comunicação, XML e JSON. O
padrão XML se baseia em tags, sendo um pouco mais pesado quando
comparado ao JSON.

Exemplo 9: API REST utilizando XML
<product>
    <id>1</id>
    <name>Samsung S22</name>
    <value>5.500,00</value>
</product>

Já o padrão JSON trabalha com chave/valor.

Exemplo 10: API REST utilizando JSON
{
    “id”: 1,
    “name”: “Samsung S22”,
    “value”: 5.500,00
}

### 4.1.3. Recursos, Métodos e Retornos

Um recurso é utilizado para identificar de forma única um objeto abstrato ou
físico e é representado pela URI da API. Tal recurso como é um objeto deve
ser representado por um substantivo e nunca por um verbo.

Exemplo 11: Recursos
recursos: /products
/products/1

Os métodos utilizados na construção de uma API REST são os métodos do
protocolo HTTP. Para obter um determinado recurso por exemplo utiliza-se o
método GET, o método POST para criar um novo recurso, o método PUT para
atualizar esse recurso criado e o DELETE para deletar tal recurso. Há outros
métodos HTTP que podem ser utilizados, mas esses citados anteriormente
são os mais comuns.

Os retornos são os códigos e as respostas que o servidor retorna ao cliente
diante de uma requisição. Os principais são:

• 1XX - Informações;
• 2XX - Sucesso;
• 3XX - Redirecionamento;
• 4XX - Erro no cliente;
• 5XX - Erro no servidor.

### 4.1.4. Modelo Maturidade Richardson

Existem casos em que é preciso seguir uma abordagem menos robusta para
a construção de uma API, e seguir todas as seis constraints propostas por Roy
Fielding pode ficar inviável. Pensando nesse ponto de vista, para casos mais
simples, Leonard Richardson propôs um modelo de maturidade composto por
quatro níveis e a API que alcançar esses quatro níveis pode sim ser
considerada uma API RESTful.
Uma API atinge o nível 0, também chamado de nível POX, quando utiliza o
protocolo HTTP apenas como mecanismo de comunicação e não como
semântica de seus verbos. Quando uma API atinge o nível 1, ela utiliza os
recursos de maneira correta, definindo bem e de forma única cada recurso e
utilizando os substantivos para representar os objetos.
Uma API no nível 2 utiliza o protocolo HTTP de forma semântica com seus
métodos e também define os tipos de retorno para cada resposta possível
de uma requisição. E por fim, uma API que atinge o nível 3 possui as HATEOAS
que são as hipermídias que mostram o seu estado atual e seu relacionamento
com os elementos ou estados futuros, ou seja, a capacidade de um
documento se relacionar com os demais.
No exemplo abaixo, é possível visualizar uma API que segue todos esses
níveis, utiliza o método GET HTTP de forma semântica com retorno 200 OK,
tem seu recurso bem definido, como /products e /products/1, possui
HATEOAS como os links mostrando a relação com as demais URI’s presentes
na API, e assim, essa API pode ser considerada RESTful.

Exemplo 12: Chamada método GET
GET /products HTTP/1.1
HTTP/1.1 200 OK
[{
    “id”: 1,
    “name”: “Samsung S22”,
    “links”: [
        {
            “href”: “/products/1”
        {
    ]
},
    {
    “id”: 2,
    “name”: “Iphone 13 pro”,
    “links”: [
        {
            “href”: “/products/2”
        }
    ]
}]

Exemplo 13: Chamada método GET /id
GET /products/1 HTTP/1.1
HTTP/1.1 200 OK
{
    “id”: 1,
    “name”: “Samsung S22”,
    “links”: {
        “productsList”: {
            “href”: “/products”
        }
    }
}

### 4.2. Criando uma API REST com Spring Boot

#### 4.2.1. Criando conexão com banco de dados

Voltando ao projeto que já foi criado no capítulo 3 deste livro, é preciso
primeiramente criar uma conexão com o banco de dados local para salvar e
buscar os recursos da API e o banco de dados utilizado neste exemplo será o
PostgreSQL. Mas antes de fazer a conexão, é preciso inserir mais duas
dependências no arquivo pom.xml, Spring Data e a dependência do Postgres,
como mostrado no exemplo abaixo.

Exemplo 14: Dependência do Spring Data e JPA
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-jpa</artifactId>
</dependency>
<dependency>
    <groupId>org.postgresql</groupId>
    <artifactId>postgresql</artifactId>
    <scope>runtime</scope>
</dependency>

Após inserir essas dependências no projeto, é preciso configurar o banco de
dados no arquivo application.properties, definindo url de acesso ao banco,
nome do banco e suas credenciais, como mostrado no código abaixo.

Exemplo 15: Configuração do banco de dados
    spring.datasource.url=
    jdbc:postgresql://localhost:5432/apirest-springboot-v3
    spring.datasource.username=postgres
    spring.datasource.password=banco123
    spring.jpa.hibernate.ddl-auto=update

### 4.2.2. Criando o Model e o Repository

Depois é preciso criar um model, objeto esse que será a representação do
recurso na URI da API e esse model será um Product que terá como atributos
idProduct, name e value. Para isso, dentro do diretório raiz é preciso criar um
novo diretório chamado models e dentro dele, criar uma nova classe
ProductModel.class e anotá-lo com @Entity para que seja uma entidade no
banco e @Table para definir o nome da tabela.
É preciso também anotar o atributo idProduct do tipo UUID com @Id e
@GeneratedValue (strategy=GenerationType.AUTO) para que esse id seja
gerado de forma automática em cada persistência de Product no banco de
dados, lembrando que Ids do tipo UUIDs são identificadores temporais
universalmente exclusivos indicados principalmente para arquiteturas
distribuídas, como Microservices.

Exemplo 16: Entidade ProductModel mapeada para o banco de dados
@Entity
@Table(name = "TB_PRODUCTS")
public class ProductModel implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private UUID idProduct;
    private String name;
    private BigDecimal value;

    public UUID getIdProduct() {
        return idProduct;
    }
    public void setIdProduct(UUID idProduct) {
        this.idProduct = idProduct;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public BigDecimal getValue() {
        return value;
    }
    public void setValue(BigDecimal value) {
        this.value = value;
    }
}

Como foi definida a configuração spring.jpa.hibernate.ddl-auto=update no
application.properties, ao inicializar a aplicação com essa nova
implementação, a tabela tb_products deve ser criada no banco de forma
automática, a qual pode ser visualizada na interface do pgAdmin do Postgres
na imagem abaixo.

Agora que já está pronto a conexão com o banco e a entidade criada, é
preciso criar um novo diretório chamado repositories e dentro dele criar uma
interface ProductRepository que extende JpaRepository do Spring Data para
utilizar os métodos já prontos para transações com o banco de dados, como
mostra o código abaixo.

Exemplo 17: Interface ProductRepository

package com.example.springboot.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.springboot.models.ProductModel;
import java.util.UUID;

@Repository
public interface ProductRepository extends JpaRepository<ProductModel, UUID> {
}

Assim, métodos como findAll(), findById(UUID id), save(S entity), delete(S
entity), entre outros podem ser utilizados sem a necessidade da
implementação do zero. A interface foi anotada com @Repository para
mostrar ao Spring que essa será um bean gerenciado por ele e como tal
interface tem como objetivo transações com o banco de dados o melhor
estereótipo a ser utilizado neste caso é @Repository.

### 4.2.3. Criando o Controller

O próximo passo para construção da API REST é criar o controller, onde será
implementado os endpoints da aplicação. Em um novo diretório controllers é
preciso criar uma nova classe ProductController e anotá-la com
@RestController. Essa anotação é um estereótipo específico para criar
endpoints REST e mostra ao Spring que tal classe será um bean gerenciado
por ele através da IoC/ID. Como já foi criado o ProductRepository que
também é um bean, é preciso criar um ponto de injeção dentro do controller
para que o Spring injete as dependências de ProductRepository quando
necessário.

Exemplo 18: Classe ProductController
@RestController
public class ProductController {
    @Autowired
    ProductRepository productRepository;
}

### 4.2.4. Implementando os métodos GET ALL e GET ONE

Agora com o Controller pronto, é possível começar a implementar os métodos
da API, iniciando pelos endpoints que retornam a listagem de produtos e um
determinado produto passando seu id. Lembrando que é preciso definir bem
o recurso, utilizar substantivos e definir os possíveis retornos utilizando o
ResponsityEntity e o HttpStatus para montar a resposta completa com os
códigos de retorno e os recursos esperados pelo cliente, e por fim utilizar de
forma semântica o método HTTP, neste caso o método GET.
O código abaixo mostra os detalhes da implementação dos métodos HTTP
GET que retornam primeiramente através da URI /products a listagem de
produtos e através da URI /products/{id}, um produto em específico, caso
este exista no banco de dados.

Exemplo 19: Implementação dos métodos GET ALL e GET ONE

@GetMapping("/products")
public ResponseEntity<List<ProductModel>> getAllProducts(){
    return new ResponseEntity<List<ProductModel>>(productRepository.findAll(), HttpStatus.OK);
}

@GetMapping("/products/{id}")
public ResponseEntity<ProductModel> getOneProduct(@PathVariable(value="id") UUID id){
    Optional<ProductModel> productO = productRepository.findById(id);
    if(productO.isEmpty()) {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    return new ResponseEntity<ProductModel>(productO.get(), HttpStatus.OK);
}

Para buscar a listagem de produtos, utiliza-se o método findAll() que retorna
List<ProductModel> e para buscar um produto específico através do id,
utiliza-se o método findById(UUID id) passando o id como argumento do
método e obtendo como retorno um ProductModel.

### 4.2.5. Implementando os métodos POST, DELETE e PUT

O próximo passo é implementar os métodos POST, DELETE e PUT. Para salvar
um novo produto através do método HTTP POST, utiliza-se o método save(S
entity) do JPA e caso a persistência aconteça corretamente no banco, o
retorno deve ser CREATED(201).
Para deletar um produto através do método HTTP DELETE, é preciso passar o
id deste produto apenas e utilizar o método delete do JPA delete(S entity). O
retorno caso a deleção ocorra corretamente deve ser OK(200).
E por fim, para atualizar um determinado produto é preciso passar o id deste
produto para que seja inicialmente feito uma busca por ele no banco e caso
exista, setar o id já existente e assim utilizar o método save(S entity) para
salvar o produto com o mesmo id já existente, ou seja, atualizá-lo no banco
de dados.
Todo esse passo a passo descrito acima pode ser visualizado no código
abaixo.

Exemplo 20: Implementação dos métodos POST, DELETE e PUT
@PostMapping("/products")
public ResponseEntity<ProductModel> saveProduct(@RequestBody @Valid ProductModel product) {
    return new ResponseEntity<ProductModel>(productRepository.save(product), HttpStatus.CREATED);
}

@DeleteMapping("/products/{id}")
public ResponseEntity<?> deleteProduct(@PathVariable(value="id") UUID id) {
    Optional<ProductModel> productO = productRepository.findById(id);
    if(productO.isEmpty()) {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    productRepository.delete(productO.get());
    return new ResponseEntity<>(HttpStatus.OK);
}
@PutMapping("/products/{id}")
public ResponseEntity<ProductModel> updateProduct(@PathVariable(value="id") UUID id, @RequestBody @Valid ProductModel product) {
    Optional<ProductModel> productO = productRepository.findById(id);
    if(productO.isEmpty()) {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    product.setIdProduct(productO.get().getIdProduct());
    return new ResponseEntity<ProductModel>(productRepository.save(product), HttpStatus.OK);
}

Agora para que essa API de Produtos possa ser considerada uma API RESTful
e atingir o nível 3 da maturidade de Richardson, é preciso inserir as hipermídias
(HATEOAS).

### 4.2.6. Inserindo as HATEOAS

Para implementar as HATEOAS na API é preciso inserir mais uma dependência
no arquivo pom.xml do projeto, como mostra o código abaixo.

Exemplo 21: Dependências das HATEOAS
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-hateoas</artifactId>
</dependency>

De acordo com o modelo de Maturidade de Richardson, uma API deve possuir
as hipermídias que mostram o seu estado atual e seu relacionamento com os
elementos ou estados futuros para que seja então considerada RESTful.
Assim, para que essa API atinja este nível, o recurso Product deve apresentar
os seus atributos e também os links, onde será mostrado o caminho de
relacionamento com os demais elementos.
Para isso, na entidade ProductModel é preciso estender
RepresentationModel para que através do seu método add() a classe
ProductModel exiba o link das demais URI’s relacionadas, como mostra o
código abaixo.

Exemplo 22: ProductModel extends RepresentationModel
@Entity
@Table(name = "TB_PRODUCTS")
public class ProductModel extends RepresentationModel<ProductModel> implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)

    private UUID idProduct;
    private String name;
    private BigDecimal value;
    public UUID getIdProduct() {
    return idProduct;
    }
    public void setIdProduct(UUID idProduct) {
    this.idProduct = idProduct;
    }
...
}

Quando uma requisição for solicitada para retornar uma lista de produtos ou
um determinado produto é preciso definir o link que será adicionado em cada
caso e construí-lo dentro dos métodos do controller e então, adicioná-lo a
cada produto.
Para isso, pode ser utilizado o método linkTo(), o qual irá construir uma URI de
acordo com o controller e o método definido, methodOn() faz o mapeamento
do método de destino da chamada e withSelfRel() e withRel() criam um auto
link de acordo com a relação.
Cada link criado deve ser inserido no produto através do método add(), como
pode ser observado nos códigos abaixo.

Exemplo 23: Criando e adicionando o link para a listagem de produtos.
@GetMapping("/products")
public ResponseEntity<List<ProductModel>> getAllProducts() {
    List<ProductModel> productsList = productRepository.findAll();
    if(!productsList.isEmpty()) {
        for(ProductModel product : productsList) {
            UUID id = product.getIdProduct();
            product.add(linkTo(methodOn(ProductController.class).getOneProduct(id)).withSelfRel());
        }   
    }
    return new
    ResponseEntity<List<ProductModel>>(productsList,
    HttpStatus.OK);
}

Exemplo 24: Criando e adicionando o link para um único produto.
@GetMapping("/products/{id}")
public ResponseEntity<ProductModel> getOneProduct(@PathVariable(value="id") UUID id) {
    Optional<ProductModel> productO = productRepository.findById(id);
    if(productO.isEmpty()) {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    productO.get().add(linkTo(methodOn(ProductController.class).getAllProducts()).withRel("Products List"));
    return new ResponseEntity<ProductModel>(productO.get(), HttpStatus.OK);
}

Ao enviar uma requisição ao servidor solicitando a listagem de produtos,
agora além dos atributos de ProductModel, também será retornado o link que
mostra o caminho e relacionamento para acessar cada produto
individualmente, através da url http://localhost:8080/products/{id}.

 {
        "idProduct": "d1a135f3-625d-4540-a83c-2d16a6ab4c1b",
        "name": "Notebook",
        "value": 3899.99,
        "links": [
            {
                "rel": "self",
                "href": "http://localhost:8080/products/d1a135f3-625d-4540-a83c-2d16a6ab4c1b"
            }
        ]
    },

E da mesma maneira, ao enviar uma requisição ao servidor solicitando um
determinado produto pelo id, será retornado o link mostrando o caminho
completo para o acesso e retorno a listagem de produtos
http://localhost:8080/products, como pode ser visualizado na imagem
abaixo.

{
    "idProduct": "689b888d-cf61-47b7-973d-22e4f004690e",
    "name": "Tablet ATUALIZADO",
    "value": 659.99,
    "_links": {
        "Products List": {
            "href": "http://localhost:8080/products"
        }
    }
}

Agora sim, com a inserção das HATEOAS na aplicação e feita as
configurações necessárias, pode-se dizer que a API de produtos atingiu o
nível 3 de maturidade e pode ser considerada uma API RESTful.