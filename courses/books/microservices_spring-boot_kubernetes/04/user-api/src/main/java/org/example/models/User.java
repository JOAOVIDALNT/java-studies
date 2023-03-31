package org.example.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.example.dto.UserDTO;

import java.util.Date;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String cpf;
    private String address;
    private String email;
    private String phone;
    private Date registerDate;


    /*
    O método convert, na classe User, é importante porque precisaremos converter
    instâncias da entidade User para instâncias da classe UserDTO. Isso será
    utilizado em diversos serviços, então é melhor ter um método que realiza essa
    operação do que ficar duplicando código em vários locais. A mesma coisa será
    necessária na classe UserDTO, então a listagem a seguir mostra a mesma
    implementação nesta classe.
    */
    public static User convert(UserDTO userDTO) {
        User user = new User();

        user.setName(userDTO.getName());
        user.setCpf(userDTO.getCpf());
        user.setAddress(userDTO.getAddress());
        user.setEmail(userDTO.getEmail());
        user.setPhone(userDTO.getPhone());

        return user;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }
}
