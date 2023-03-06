### Query Params vs Path Params

no caso da aplicação, utilizamos query params, onde não era obrigatório informar o valor, tendo por si um valor padrão.
Ao utilizar query params em uma aplicação de uma calculadora, por exemplo, serão necessárias mais validações no serviço para garantir que o usuário não vai fazer nada de errado, por isso talvez seja melhor utilizar path params

>exemplo de query param: http://localhost:8080/?numberOne=2&numberTwo=7
>
> exemplo de path param: http://localhost:8080/sum/2/7

- quando o valor é opicional e se eu não passar não vou quebrar a aplicação, utilizamos query params (ou query string) caso o contrário, utilizamos path params