package com.concon.simpleprojekt.source;

import com.concon.simpleprojekt.model.Person;
import com.concon.simpleprojekt.repository.PersonRepository;
import com.coxautodev.graphql.tools.GraphQLResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PersonResolver implements GraphQLResolver<Person> {
@Autowired
private  PersonRepository personRepository;
    public PersonResolver(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }



}
