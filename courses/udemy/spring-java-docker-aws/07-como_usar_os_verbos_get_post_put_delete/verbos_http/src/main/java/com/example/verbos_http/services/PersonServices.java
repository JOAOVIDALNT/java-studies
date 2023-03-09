package com.example.verbos_http.services;

import com.example.verbos_http.models.Person;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;
@Service // o spring boot encara a classe como um objeto que vai ser injetado no runtime em outras classes da aplicação, possibilita usar o @Autowired e não precisa instanciar
public class PersonServices {

    private final AtomicLong counter = new AtomicLong();
    private Logger logger = Logger.getLogger(PersonServices.class.getName());

    public Person findById(String id) {
        logger.info("Finding one person!");


        Person person  = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstName("João");
        person.setLastName("Vidal");
        person.setAddress("São Paulo - SP, Brazil");
        person.setGender("Male");
        return person;
    }

    // mock é uma estrutura de código temporária que sustenta o desenvolvimento do código até que os outros componentes estejam prontos



}
