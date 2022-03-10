package com.bracits.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String birthdate;
    private int gender;
    private String note;

    public Student() {
        super();
    }

    public Student(Long id, String name, String birthdate, int gender, String note) {
        super();
        this.id = id;
        this.name = name;
        this.birthdate = birthdate;
        this.gender = gender;
        this.note = note;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public int getGender() {
        return gender;
    }

    public String getNote() {
        return note;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBirthdate(String birthDate) {
        this.birthdate = birthDate;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
