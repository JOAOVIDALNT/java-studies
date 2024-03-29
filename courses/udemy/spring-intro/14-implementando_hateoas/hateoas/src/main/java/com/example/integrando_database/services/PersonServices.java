package com.example.integrando_database.services;

import com.example.integrando_database.controllers.PersonController;
import com.example.integrando_database.data.vo.v1.PersonVO;
import com.example.integrando_database.exceptions.ResourceNotFoundException;
import com.example.integrando_database.mapper.DozerMapper;
import com.example.integrando_database.models.Person;
import com.example.integrando_database.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import static  org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static  org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;
@Service // o spring boot encara a classe como um objeto que vai ser injetado no runtime em outras classes da aplicação, possibilita usar o @Autowired e não precisa instanciar
public class PersonServices {

    private Logger logger = Logger.getLogger(PersonServices.class.getName());
    @Autowired
    PersonRepository repository;


    public List<PersonVO> findAll() {
        logger.info("Finding all");
        var persons = DozerMapper.parseListObjects(repository.findAll(), PersonVO.class);
        persons.stream().forEach(p -> p.add(linkTo(methodOn(PersonController.class).findById(p.getKey())).withSelfRel()));
        return persons;
    }


    public PersonVO findById(Long id) {
        logger.info("Finding one person!");
        var entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this id"));

        var vo = DozerMapper.parseObject(entity, PersonVO.class);
        vo.add(linkTo(methodOn(PersonController.class).findById(id)).withSelfRel());
        return vo;
    }

    public PersonVO create(PersonVO person) {
        logger.info("creating one person");

        var entity = DozerMapper.parseObject(person, Person.class);
        var vo = DozerMapper.parseObject(repository.save(entity), PersonVO.class);
        vo.add(linkTo(methodOn(PersonController.class).findById(vo.getKey())).withSelfRel());
        return vo;
    }

    public PersonVO update(PersonVO person) {

        logger.info("Updating one person");

        var entity = repository.findById(person.getKey())
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this id"));

        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setGender(person.getGender());
        entity.setAddress(person.getAddress());

        var vo = DozerMapper.parseObject(repository.save(entity), PersonVO.class);
        vo.add(linkTo(methodOn(PersonController.class).findById(vo.getKey())).withSelfRel());
        return vo;
    }

    public void delete(Long id) {
        logger.info("Deleting one person");

        var entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this id"));

        repository.delete(entity);
    }




}