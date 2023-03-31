package org.example.controllers;

import jakarta.annotation.PostConstruct;
import org.apache.catalina.User;
import org.example.dto.UserDTO;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
public class UserController {

    @GetMapping("/")
    public String getMessage() {
        return "Spring boot is running";
    }

    @GetMapping("/users")
    public static List<UserDTO> getUsers() {
        return users;
    }

    /*
    Para definir o parâmetro na URL, tivemos que colocar o valor {cpf} na definição
    da rota e também adicionar a anotação @PathVariableno parâmetro cpf. Note
    que tanto o valor na URL quanto o parâmetro possuem o mesmo nome, isso é
    obrigatório.
    */
    @GetMapping("/users/{cpf}")
    public UserDTO getUsersByCpf(@PathVariable String cpf) {
        for (UserDTO userFilter : users) {
            if (userFilter.getCpf().equals(cpf)) {
                return userFilter;
            }
        }
        return null; // caso o cpf não esteja cadastrado a resposta estará vazia
    }

    @PostMapping("/newUser")
    public UserDTO insert(@RequestBody UserDTO userDTO) {
        userDTO.setRegisterDate(new Date());
        users.add(userDTO);
        return userDTO;
    }

    @DeleteMapping("/user/{cpf}")
    public Boolean delete(@PathVariable String cpf) {
        for (UserDTO userFilter: users) {
            if (userFilter.getCpf().equals(cpf)) {
                users.remove(userFilter);
                return true;
            }
        }
        return false;
    }

    public static List<UserDTO> users = new ArrayList<UserDTO>();

    /*
    Esse método foi anotado com @PostConstruct, que faz com
    que ele seja executado logo depois que o contêiner inicializa a classe
    UserController. Essa anotação pode ser utilizada em todas as classes gerenciadas
    pelo Spring como Controllers e Services.
    */
    @PostConstruct
    public void initiateList() {
        UserDTO userDTO = new UserDTO("João", "666", "Brazil", "jao@dev.com", "116969", new Date());
        UserDTO userDTO2 = new UserDTO("Giulia", "999", "Brazil", "giu@adm.com", "119696", new Date());
        UserDTO userDTO3 = new UserDTO("Amelie", "888", "Brazil", "ame@fun.com", "117777", new Date());

        users.add(userDTO);
        users.add(userDTO2);
        users.add(userDTO3);

    }
}
