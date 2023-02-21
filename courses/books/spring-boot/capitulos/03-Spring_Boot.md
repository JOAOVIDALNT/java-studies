### 3. Spring Boot

Iniciar uma aplicação do zero utilizando o Spring Framework pode ser um
tanto quanto trabalhosa, pois é preciso fazer várias configurações em
arquivos XML ou classe de configuração, configurar o Dispatcher Servlet,
gerar um arquivo war, subir a aplicação dentro de um Servlet Container, como
por exemplo o Tomcat, para então conseguir executar a aplicação e
começar a implementar as regras de negócio.
O Spring Boot veio como uma extensão do Spring, que utiliza da base do
Spring Framework para iniciar uma aplicação de uma forma bem mais
simplificada, diminuindo a complexidade de configurações iniciais e o tempo
para executar uma aplicação e deixá-la pronta para implementação das
regras de negócio. Também já traz um servidor embutido que facilita ainda
mais esse processo de start da aplicação.
Ao iniciar um projeto Spring Boot, basta uma dependência no arquivo
pom.xml, spring-boot-starter, para que ele já traga internamente todas as
dependências base do Spring Framework, como pode-se observar nas
imagens abaixo.

<depencencies>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter</artifactId>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-test</artifactId>
        <scope>test</scope>
    </dependency>
</dependencies>

Resumindo, o Spring Boot é a soma do Spring Framework com um servidor
embutido menos as configurações XML e classes de configurações.

Spring Boot = Spring Framework + Servidor embutido (tomcat) - XML <bean> Configuration ou @Configuration

