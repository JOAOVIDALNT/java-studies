package com.example.appchamadosjava.services;

import com.example.appchamadosjava.models.dtos.user.UserDTO;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    public UserDTO create(UserDTO userDTO);
}
