@RestController no Spring MVC nada mais é do que uma combinação das annotations @Controller e @ResponseBody. Essa annotation foi adicionada ao Spring 4.0 para facilitar o desenvolvimento dos serviços RESTful com Framework Spring. Se você estiver familiarizado com os serviços REST, sabe que a diferença fundamental entre um aplicativo web e uma API REST é que a resposta de um aplicativo da web é uma visualização geral de HTML + CSS + JavaScript enquanto a API REST apenas retorna dados em forma de JSON ou XML. Essa diferença também é óbvia nas anotações @Controller e @RestController. O trabalho do @Controller é criar um Map do model object e encontrar uma view, mas o @RestController simplesmente retorna o objeto e os dados do objeto são gravados diretamente na resposta HTTP como JSON ou XML.

Isso também pode ser feito com o @Controller tradicional e o uso da anotação @ResponseBody, mas como esse é o comportamento padrão dos serviços RESTful, o Spring criou o @RestController que combina o comportamento do @Controller e do @ResponseBody.

Em resumo, os dois trechos de código a seguir são iguais no Spring MVC:

@Controller
@ResponseBody
public class MVCController { 
   .. your logic
}

@RestController
public class RestFulController { 
  .... your logic
}

- O @Controller é uma anotação comum usada para marcar uma classe como Spring MVC Controller, enquanto o @RestController é um controlador especial usado para serviços RESTFul e o equivalente a @Controller + @ResponseBody.

- O @RestController é relativamente novo, adicionado apenas no Spring 4.0, mas o @Controller é uma anotação bem antiga, existente desde que o Spring começou a oferecer suporte à annotations, oficialmente adicionado na versão Spring 2.5.

- A anotação @Controller indica que a classe é um “Controller” (dentro do contexto do padrão MVC ele é o ‘C’), enquanto a anotação @RestController indica que a classe é um controller em que os métodos @RequestMapping assumem a semântica @ResponseBody por padrão, ou seja, atendendo à API REST.

- O @Controller é uma especialização da anotação @Component enquanto o @RestController é uma especialização da anotação @Controller. Na verdade, é um controlador anotado com @Controller e @ResponseBody, como mostrado abaixo.

@Target(value=TYPE)
@Retention(value=RUNTIME)
@Documented
@Controller
@ResponseBody
public @interface RestController
E abaixo como é uma declaração @Controller

@Target(value=TYPE)
@Retention(value=RUNTIME)
@Documented
@Component
public @interface Controller

Uma das principais diferenças entre @Controler e @RestCotroller no Spring MVC é que, depois de marcar uma classe como @RestController, todos os métodos gravam um objeto de domínio em vez de uma exibição.

Outra diferença importante entre @RestController e @Controller é que você não precisa usar @ResponseBody em todos os métodos de controller depois de anotar a classe com @RestController, como mostrado abaixo:


Com @RestController:
@RestController
public class Book{
    @RequestMapping(value={"/book"})
    public Book getBook(){
    //...
    return book;
    }
}

Sem @RestController:
@Controller
public class Book{
    @RequestMapping(value={"/book"})
    @ResponseBody
    public Book getBook(){
    //...
    return book;
    }
}

Essas são as principais diferenças entre as anotações @Controller e @RestController no Spring MVC e no REST. O @RestController é apenas o atalho para usar a anotação @Controller e @ResponseBody juntos.

O Spring propositadamente adicionou essa anotação no Spring 4 para facilitar o desenvolvimento de serviços RESTful usando o Framework Spring. Ele pode converter diretamente a resposta em JSON ou XML, dependendo do MIME. type request.