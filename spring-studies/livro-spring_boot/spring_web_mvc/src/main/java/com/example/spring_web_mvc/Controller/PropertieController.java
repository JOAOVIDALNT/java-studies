package com.example.spring_web_mvc.Controller;

import com.example.spring_web_mvc.Entities.Propertie;
import com.example.spring_web_mvc.Repository.PropertieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api")
public class PropertieController {

    @Autowired
    private PropertieRepository repository;

    @RequestMapping(value="/find/{filtro}", method = RequestMethod.GET)
    List<Propertie> findByFiltro(@PathVariable("filtro") String filtro) {
        return repository.findByFiltro(filtro);
    }





}
