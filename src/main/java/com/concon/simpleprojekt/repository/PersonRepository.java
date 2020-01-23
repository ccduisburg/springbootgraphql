package com.concon.simpleprojekt.repository;

import com.concon.simpleprojekt.model.Person;
import com.concon.simpleprojekt.source.GraphQLPaginationResult;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import java.util.*;
@Repository
@Transactional
public interface PersonRepository extends JpaRepository<Person,Integer> {
    @Modifying
    @Query("UPDATE Person p SET p.vorname = ?2, p.nachname = ?3, p.geburtsdatum = ?4 WHERE p.id = ?1")
    Integer updatePerson(Integer id, String vorname, String nachname, Date geburtsdatum);


    @Query("SELECT p FROM Person p WHERE p.vorname LIKE %?1% ")
    Page<Person> findByVorname(String vorname, Pageable pageable);

    @Query("SELECT p FROM Person p WHERE p.nachname LIKE %?1%  ")
    Page<Person> findByNachname(String nachname,Pageable pageable);

    @Query("SELECT p FROM Person p WHERE p.skill   LIKE %?1% ")
    Page<Person>findBySkill(String skill,Pageable pageable);

    @Query("SELECT p FROM Person p WHERE p.geburtsdatum >:geburtsdatum ")
    Page<Person>findByGeburtsdatum( @Param("geburtsdatum") Date geburtsdatum,Pageable pageable);

    @Query("SELECT p FROM Person p WHERE  (:vorname is null or p.nachname = :vorname) " +
            "and " +
            "(:nachname is null or p.nachname = :nachname)"
            +"and " +
            "(:skill is null or p.skill = :skill)"
           + "and " +
            "(:geburtsdatum is null or p.geburtsdatum > :geburtsdatum)"
    ) Page<Person> findAllByOptional(
                    @Param("vorname") String vorname,
                    @Param("nachname") String nachname,
                    @Param("skill") String skill,
                    @Param("geburtsdatum") Date geburtsdatum,Pageable pageable);

}
