package com.concon.simpleprojekt.source;

import com.concon.simpleprojekt.model.Person;
import com.concon.simpleprojekt.repository.PersonRepository;
import com.coxautodev.graphql.tools.GraphQLResolver;
import org.springframework.beans.factory.annotation.Autowired;

public class PersonResolver implements GraphQLResolver<Person> {

private  PersonRepository personRepository;
    public PersonResolver(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

   // public Person getPerson(Person person) {
//        return personRepository.getOne(person.getId());
//    }
}
