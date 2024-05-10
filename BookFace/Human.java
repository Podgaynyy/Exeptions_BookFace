package org.example.BookFace;

import java.time.LocalDate;

public class Human {
    private String familiname;
    private String name;
    private String secondname;
    private LocalDate dob;
    private String telnumber;
    private Gender gender;

    public Human(String familiname, String name, String secondname,
                 LocalDate dob, String telnumber, Gender gender){
        this.familiname = familiname;
        this.name = name;
        this.secondname = secondname;
        this.dob = dob;
        this.telnumber = telnumber;
        this.gender = gender;
    }

    public String getFamiliname() {
        return familiname;
    }

    public void setFamiliname(String familiname) {
        this.familiname = familiname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSecondname() {
        return secondname;
    }

    public void setSecondname(String secondname) {
        this.secondname = secondname;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String getTelnumber() {
        return telnumber;
    }

    public void setTelnumber(String telnumber) {
        this.telnumber = telnumber;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }
}
