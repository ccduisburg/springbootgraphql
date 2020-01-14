package com.concon.simpleprojekt.repository;

import com.concon.simpleprojekt.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.sql.Date;

public interface PersonRepository extends JpaRepository<Person,Integer> {
    @Modifying
    @Query("UPDATE Person p SET p.vorname = ?2, p.nachname = ?3, p.geburtsdatum = ?4 WHERE p.id = ?1")
    Integer updatePerson(Integer id, String vorname, String nachname, Date geburtsdatum);

}
