package org.example.controllers;

import jakarta.annotation.PostConstruct;
import org.apache.catalina.User;
import org.example.dto.UserDTO;
import org.example.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/user")
    public List<UserDTO> getUsers() {
        List<UserDTO> users = userService.getAll();
        return users;
    }

    @GetMapping("/user/{id}")
    public UserDTO getUserById(@PathVariable Long id) {
        return userService.findById(id);
    }

    @PostMapping("/user")
    public UserDTO createUser(@RequestBody UserDTO userDTO) {
        return userService.save(userDTO);
    }

    @GetMapping("/user/cpf/{cpf}")
    public UserDTO findByCpf(@PathVariable String cpf) {
        return userService.findByCpf(cpf);
    }

    @DeleteMapping("/user/{id}")
    public UserDTO deleteUser(@PathVariable Long id) {
       return userService.delete(id);
    }

    @GetMapping("/user/search")
    public List<UserDTO> quertByName(@RequestParam(name = "name", required = true) String name) {
        return userService.queryByName(name);
    }

    /*
    Uma novidade aqui é a rota /user/search, que fará a busca pelo nome recebido
como parâmetro - o nome pode ser completo ou apenas parte do nome. Se o
    nome for completo, a rota retornará apenas um usuário, se o usuário passar
    apenas parte do nome, pode ser retornada uma lista de usuários. Outra novidade
    é a anotação @RequestParam, que deve ser usada quando queremos passar
    parâmetros na URL para a rota. Veja que a anotação recebeu que o parâmetro é
    obrigatório. A chamada para essa rota pode ser feita pela URL
    http://localhost:8080/user/search?nome=Mar%, nesse caso a resposta para a
    chamada será: Marcela, Marcelo, Marcos etc..

    */

}
