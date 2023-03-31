package org.example.repositories;

import org.example.models.User;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByCpf(String cpf);

    List<User> queryByNameLike(String name);

    /*
    Como é possível verificar nos métodos findByCPF e queryByNameLike,
    algumas consultas podem ser criadas apenas com o nome do método. Esses
    métodos devem ter algumas palavras-chaves no nome como find, and, or, like e
    o nome do campo. Nos próximos serviços criaremos algumas consultas mais
    complexas e mais algumas dessas palavras-chaves serão apresentadas.
    */
}
