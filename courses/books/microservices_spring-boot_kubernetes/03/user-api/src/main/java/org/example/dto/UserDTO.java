package org.example.dto;

import java.util.Date;

public class UserDTO {

    public UserDTO(String name, String cpf, String address, String email, String phone, Date registerDate) {
        this.name = name;
        this.cpf = cpf;
        this.address = address;
        this.email = email;
        this.phone = phone;
        this.registerDate = registerDate;
    }

    private String name;
    private String cpf;
    private String address;
    private String email;
    private String phone;
    private Date registerDate;

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
