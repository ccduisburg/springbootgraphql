package com.concon.simpleprojekt.source;

import com.concon.simpleprojekt.model.Person;
import com.concon.simpleprojekt.repository.PersonRepository;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public class Query implements GraphQLQueryResolver {

  private  PersonRepository personRepository;

  public Query(PersonRepository personRepository) {
    this.personRepository = personRepository;

  }



  public List<Person> findAllPerson() {
        return personRepository.findAll();
    }



}
