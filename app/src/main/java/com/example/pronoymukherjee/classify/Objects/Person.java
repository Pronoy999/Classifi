package com.example.pronoymukherjee.classify.Objects;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Person base class for a generic user on the site.
 */

public abstract class Person {
    protected String ID;
    protected String name;
    protected String department;
    protected String email;
    protected String phoneNumber;
    protected String yearOfJoin;
    protected Date dob;
    protected char gender;
    protected College college;

    protected List<Course> courses;
    protected Map<String, Course> courseMap;

    public Person(String ID, String name, String department, String email,
                  String phoneNumber, String yearOfJoin, Date dob, char gender, College college) {
        this.ID = ID;
        this.name = name;
        this.department = department;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.yearOfJoin = yearOfJoin;
        this.dob = dob;
        this.gender = gender;
        this.college = college;

        courses = new ArrayList<>();
        courseMap = new HashMap<>();
    }

    public String getID() {return ID;}
    public void setID(String ID) {this.ID = ID;}

    public String getName() {return name;}
    public String getDepartment() {return department;}
    public String getEmail() {return email;}
    public String getPhoneNumber() {return phoneNumber;}
    public String getYearOfJoin() {return yearOfJoin;}

    public Date getDob() {return dob;}
    public char getGender() {return gender;}

    public void setName(String name) {this.name = name;}
    public void setDepartment(String department) {this.department = department;}
    public void setEmail(String email) {this.email = email;}
    public void setPhoneNumber(String phoneNumber) {this.phoneNumber = phoneNumber;}
    public void setYearOfJoin(String yearOfJoin) {this.yearOfJoin = yearOfJoin;}

    public void setDob(Date dob) {this.dob = dob;}
    public void setGender(char gender) {this.gender = gender;}
}


