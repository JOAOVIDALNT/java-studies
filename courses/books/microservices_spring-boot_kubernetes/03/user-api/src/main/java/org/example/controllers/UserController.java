package org.example.controllers;

import jakarta.annotation.PostConstruct;
import org.example.dto.UserDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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

    public static List<UserDTO> users = new ArrayList<UserDTO>();

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
