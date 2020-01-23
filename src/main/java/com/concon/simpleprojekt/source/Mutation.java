package com.concon.simpleprojekt.source;

import com.concon.simpleprojekt.exceptions.RecordNotFoundException;
import com.concon.simpleprojekt.model.Person;
import com.concon.simpleprojekt.repository.PersonRepository;
import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;


public class Mutation implements GraphQLMutationResolver {
    private PersonRepository personRepository;
    public Mutation(PersonRepository personRepository) {
        this.personRepository=personRepository;
    }


    public Person savePerson(String firstName, String lastName, String skills, Date geburstDatum) {
        Person person = new Person();
        person.setVorname(firstName);
        person.setNachname(lastName);
        person.setSkill(skills);
        person.setGeburtsdatum(geburstDatum);

        personRepository.save(person);

        return person;
    }

    public boolean deletePerson(Integer id) {
        Person person = personRepository.findById(id).get();
        if(person == null) {
            throw new RecordNotFoundException("The Person to be updated was not found", id);
        }
        personRepository.delete(person);
        return true;
    }

    public Person updatePerson(Integer id,Person updateperson) {
        Person person = personRepository.findById(id).get();
        if(person == null) {
            throw new RecordNotFoundException("The Person to be updated was not found", id);
        }
        person.setVorname(updateperson.getVorname());
person.setNachname(updateperson.getNachname());
person.setSkill(updateperson.getSkill());
person.setGeburtsdatum(updateperson.getGeburtsdatum());

        personRepository.save(person);

        return person;
    }
}
