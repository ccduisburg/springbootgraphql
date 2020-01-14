package com.concon.simpleprojekt.controller;

import com.concon.simpleprojekt.model.Person;
import com.concon.simpleprojekt.repository.PersonRepository;
import graphql.ExecutionResult;
import graphql.GraphQL;
import graphql.schema.DataFetcher;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.SchemaParser;
import graphql.schema.idl.TypeDefinitionRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@RestController
public class PersonController {
    @Autowired
    PersonRepository personRepository;



   
    @RequestMapping(
             method= RequestMethod.GET,
             path="/allperson",
             produces = MediaType.APPLICATION_JSON_VALUE
    )
    public List<Person> getPerson(){
        List<Person> personList=personRepository.findAll();
     return personList;
    }
//
//    @RequestMapping(
//            method=RequestMethod.POST,
//            path="/person",
//            produces=MediaType.APPLICATION_JSON_VALUE,
//            consumes=MediaType.APPLICATION_JSON_VALUE
//    )
//    public Person savePerson(@RequestBody Person person){
//        return personRepository.save(person);
//    }


    @PostMapping("/addPerson")
    public String addPerson(@RequestBody List<Person> persons){
        personRepository.saveAll(persons);
        return "record inserted "+persons.size();
    }


   @RequestMapping(
            method = RequestMethod.PUT,
            path = "/updatePerson",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    @Transactional
    public Person updatePerson(@RequestBody Person person){
       Person updatePerson = personRepository.getOne(person.getId());

       updatePerson.setGeburtsdatum(person.getGeburtsdatum());
       updatePerson.setNachname(person.getNachname());
       updatePerson.setVorname(person.getVorname());
       updatePerson.setSkill(person.getSkill());

       return personRepository.saveAndFlush(updatePerson);
    }
    @RequestMapping(
            method = RequestMethod.DELETE,
            value = "/deletePerson/{id}"
    )
    public void deletePerson(@PathVariable("id") Integer id){
        personRepository.deleteById(id);
    }

//    public Person getPerson(){
//    String skills= new String("Spring Boot,java");
//
//    String vorname="sven";
//    String nachname="Guthe";
//    Person person=new Person();
//    person.setVorname(vorname);
//    person.setNachname(nachname);
//    person.setSkill(skills);
//    return person;
//
//}
}
