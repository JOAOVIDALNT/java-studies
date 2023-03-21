package com.example.verbos_http.services;

import com.example.verbos_http.models.Person;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;
@Service // o spring boot encara a classe como um objeto que vai ser injetado no runtime em outras classes da aplicação, possibilita usar o @Autowired e não precisa instanciar
public class PersonServices {

    private final AtomicLong counter = new AtomicLong();
    private Logger logger = Logger.getLogger(PersonServices.class.getName());


    public List<Person> findAll() {
        logger.info("Finding all");
        // seria aqui onde acessariamos a base de dados pra recuperar a listagem
        List<Person> persons = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            Person person = mockPerson(i);
            persons.add(person);
        }
        return persons;
    }


    public Person findById(String id) {
        logger.info("Finding one person!");
        // seria aqui onde acessariamos a base de dados pra recuperar a listagem

        // MOCK
        Person person  = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstName("João");
        person.setLastName("Vidal");
        person.setAddress("São Paulo - SP, Brazil");
        person.setGender("Male");
        return person;
        //
        // mock é uma estrutura de código temporária que sustenta o desenvolvimento do código até que os outros componentes estejam prontos
    }

    public Person create(Person person) {
        logger.info("creating one person");
        return person;
    }

    public Person update(Person person) {
        logger.info("Updating one person");
        return person;
    }

    public void delete(String id) {
        logger.info("Deleting one person");
    }


    private Person mockPerson(int i) {
        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstName("Person name " + i);
        person.setLastName("Last name " + i);
        person.setAddress("Somewhere in Brazil");
        person.setGender("Male");
        return person;
    }



}
