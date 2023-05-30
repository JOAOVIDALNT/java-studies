package com.example.appchamadosjava.services;

import com.example.appchamadosjava.models.dtos.user.UserDTO;
import com.example.appchamadosjava.exceptions.InvalidParameterException;
import com.example.appchamadosjava.mappers.ModelMap;
import com.example.appchamadosjava.models.entities.User;
import com.example.appchamadosjava.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    public UserDTO create(UserDTO userDTO) {
        User isEmailResgistered = userRepository.findByEmail(userDTO.getEmail());

        if(isEmailResgistered != null) {
            throw new InvalidParameterException("Email já registrado");
        }

        User entity = ModelMap.parseObject(userDTO, User.class);
        UserDTO dto = ModelMap.parseObject(userRepository.save(entity), UserDTO.class);
        return dto;
    }
}
