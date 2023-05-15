# Spring Security

Quando adicionamos a dependência do spring security no nosso projeto, ele já bloqueia o acesso de todas as rotas e disponibiliza uma tela de login com usuário padrão "user" e a senha que é um hash disponibilizado no log da aplicação:

```
Using generated security password: c5ca81eb-671e-4ee5-bea6-c0ec048e04fb

This generated password is for development use only. 
Your security configuration must be updated before running your application in production.
```
> Assim que fica a url após autênticar:<br>
> http://localhost:8081/public?continue 

> Também é possível realizar logout através da url: <br>
> http://localhost:8081/logout

## Tela de Login ao tentar acessar a rota /public
<img src="C:\Users\NYBC\dev\java\java-studies\concepts\spring-security\security-demo\assets\img.png" width="600" height="300">

## Tela autênticada ao acessar a rota /public
<img src="C:\Users\NYBC\dev\java\java-studies\concepts\spring-security\security-demo\assets\img_1.png" width="600" height="300">

## Tela de confirmação de logout ao acessar a rota /logout e bloqueio de acesso
<img src="C:\Users\NYBC\dev\java\java-studies\concepts\spring-security\security-demo\assets\img_2.png" width="400" height="200">
<img src="C:\Users\NYBC\dev\java\java-studies\concepts\spring-security\security-demo\assets\img_3.png" width="400" height="200">

# Autênticando apenas rotas específicas

Como o próprio nome deixa explicito, não queremos barreiras na rota pública. Uma solução simples consiste em criar uma classe SecurityConfig e definir algumas configurações:
```java
@Configuration
@EnableWebSecurity
public class SecurityConfig {
    // a segurança é feita através de filtros
    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        return http
                .authorizeHttpRequests(
                        authorizeConfig -> {
                            authorizeConfig.requestMatchers("/public").permitAll(); // permite a rota public
                            authorizeConfig.requestMatchers("/logout").permitAll();
                            authorizeConfig.anyRequest().authenticated(); // exige autênticação em todas as rotas 
                        }
                )
                .formLogin(Customizer.withDefaults())
                .build();
    }
}
```
- O método permitAll() libera acesso a algum caminho através de algum parâmetro, neste caso através do matcher da resquest com o url.
- A configuração anyRequest().authenticated() define que quaisquer outros endereços que não sejam os liberados exigam autêntição
- O método formLogin() recebe como parâmetro o formulário padrão do spring security, caso não use essa configuração as urls que necessitam de autênticação retornam 403.

## Retorno da url /private caso a formLogin não esteja configurada
<img src="C:\Users\NYBC\dev\java\java-studies\concepts\spring-security\security-demo\assets\img_4.png" width="500" height="300">

<hr>

## Observação
- Essa não é uma forma comum de autenticar aplicações, normalmente usamos nossos usuários, cadastrados nas nossas bases de dados ou em algum identity provider externo ex(google, facebook, github).

- Nos próximos passos modificaremos o projeto para utilizar uma credencial provida pelo Google (OAuth2)

# OAuth 2.0 e OpenID


