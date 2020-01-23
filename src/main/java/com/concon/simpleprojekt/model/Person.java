package com.concon.simpleprojekt.model;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;


@Getter
@Setter
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
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date geburtsdatum;
    private String skill;

    public Person() {

    }


}
