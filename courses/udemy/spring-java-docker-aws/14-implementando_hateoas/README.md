## O que é HATEOAS(Hypermedia as the Engine of Application State)

é uma constraint arquitetural do rest que eleva o rest ao último nível tornando restful 

- HATEOAS é uma restrição que faz parte da arquitetura de aplicações REST, cujo objetivo é ajudar os clientes a consumirem o serviço sem a necessidade de conhecimento prévio profundo da API.

###  Exemplo de API sem HATEOAS
{
       "cursos": [
        {
                "id": 1,
                "nome": "Java",
                "aulas": [
                {
                        "id": 1,
                        "titulo": "Título da aula 1"
                },
                {
                        "id": 2,
                        "titulo": "Título da aula 2"
		}
	     ]
	},
	{
                "id": 2,
                "nome": "C# (C-Sharp)",
                "aulas": [
                {
                        "id": 1,
                        "titulo": "Título da aula 1"
                },
                {
                        "id": 2,
                        "titulo": "Título da aula 2"
                }
             ]
        }
  

### Exemplo de API com HATEOAS


{
                "cursos": [
        {
                "id": 1,
                "nome": "Java",
                "aulas": "api.cursoteste.com.br/cursos/1/aulas
        },

        "cursos": [
        {
                "id": 2,
                "nome": "C# (C-Sharp)",
                "aulas": "api.cursoteste.com.br/cursos/2/aulas
        }
}

