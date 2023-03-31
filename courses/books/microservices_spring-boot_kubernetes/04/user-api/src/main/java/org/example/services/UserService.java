package org.example.services;

import org.example.dto.UserDTO;
import org.example.models.User;
import org.example.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<UserDTO> getAll() {
        List<User> users = userRepository.findAll();
        return users.stream().map(UserDTO::convert).collect(Collectors.toList());
    }
    /*
    Na listagem é possível ver que a classe foi anotada com @Service, indicando
    que uma instância dela será criada na criação da aplicação. A classe também
    possui um atributo do tipo UserRepository que foi anotado com @Autowired.
    Essa anotação serve para fazer injeção de dependências e será bastante utilizada
    a partir daqui. Além disso, a classe possui o método getAll, que faz as seguintes
    operações:
    - Chama o método findAll, do UserRepository, que retorna uma lista de usuários,
    sendo instâncias da entidade User.
    - Transforma a lista em um stream e chama o método map para transformar a lista
    de entidades em uma lista de DTOs.
    - Retorna a lista de DTOs.
    */

    public UserDTO findById(Long userId) {
        Optional<User> user = userRepository.findById(userId);

        if(user.isPresent()) {
            return UserDTO.convert(user.get());
        }
        return null;
    }

    public UserDTO save(UserDTO userDTO) {
        User user = userRepository.save(User.convert(userDTO));

        return UserDTO.convert(user);
    }

    public UserDTO delete(Long userId) {
        Optional<User> user = userRepository.findById(userId);
        if (user.isPresent()) {
            userRepository.delete(user.get());
        }
        return null;
    }

    public UserDTO findByCpf(String cpf) {
        User user = userRepository.findByCpf(cpf);

        if (user != null) {
            return UserDTO.convert(user);
        }
        return null;
    }

    public List<UserDTO> queryByName(String name) {
        List<User> users = userRepository.queryByNameLike(name);

        return users.stream().map(UserDTO::convert).collect(Collectors.toList());
    }
}
