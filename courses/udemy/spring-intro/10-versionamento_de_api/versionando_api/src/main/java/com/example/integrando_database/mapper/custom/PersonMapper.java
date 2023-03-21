package com.example.integrando_database.mapper.custom;

import com.example.integrando_database.data.vo.v2.PersonVOv2;
import com.example.integrando_database.models.Person;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class PersonMapper {

    public PersonVOv2 convertEntityToVO(Person person) {
        PersonVOv2 vo = new PersonVOv2();
        vo.setId(person.getId());
        vo.setFirstName(person.getFirstName());
        vo.setLastName(person.getLastName());
        vo.setAddress(person.getAddress());
        vo.setGender(person.getGender());
        vo.setBirthday(new Date());
        return vo;
    }

    public Person convertVoToEntity(PersonVOv2 person) {
        Person entity = new Person();
        entity.setId(person.getId());
        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());
//        entity.setBirthday(new Date());
        return entity;
    }
}
