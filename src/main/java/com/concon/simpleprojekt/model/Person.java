package com.concon.simpleprojekt.model;


import lombok.Data;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Date;
import java.util.List;

@Data
@Entity
@Table(name="person")
public class Person {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Integer id;
@NotNull
    private String vorname;
    @NotNull
    private String nachname;
    private Date geburtsdatum;
    private String skill;

    public Person() {

    }


}
