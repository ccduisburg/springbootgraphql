package com.concon.simpleprojekt.source;

import com.concon.simpleprojekt.exceptions.RecordNotFoundException;
import com.concon.simpleprojekt.model.Person;
import com.concon.simpleprojekt.repository.PersonRepository;
import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Date;

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

    public boolean deletePerson(Person person) {
        personRepository.delete(person);
        return true;
    }

    public Person updatePerson(Person updateperson) {
        Person person = personRepository.findById(updateperson.getId()).get();
        if(updateperson == null) {
            throw new RecordNotFoundException("The book to be updated was not found", updateperson.getId());
        }
        person.setVorname(updateperson.getVorname());
person.setNachname(updateperson.getNachname());
person.setSkill(updateperson.getSkill());
person.setGeburtsdatum(updateperson.getGeburtsdatum());

        personRepository.save(person);

        return person;
    }
}
