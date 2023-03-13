### Json Serialization custom

- para customizar como os dados devem ser inseridos, podeos setar uma ordem na classe VO utilizando a anotação:
> @JsonPropertyOrder({"id","firstName","lastName","address","gender"})
> pulic class PersonVO implements Serializable {
	"content"
}

- também é possivel alterar o nome da propriedade no json utilizando a anotação:
> @JsonProperty("first_name")
> private String firstName;
- quando o json solicitar com o "first_name" terá acesso a propriedade firstName

- é possível ignorar um campo com a anotação @JsonIgnore


