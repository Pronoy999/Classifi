package com.example.pronoymukherjee.classify.Objects;
import java.util.Date;

/**
 * Person base class for a generic user on the site.
 */

abstract class Person {
    private String name, department, email, phoneNumber, yearOfJoin, collegeCode;
    private Date dob;
    private char gender;

    public String getName() {return name;}
    public String getDepartment() {return department;}
    public String getEmail() {return email;}
    public String getPhoneNumber() {return phoneNumber;}
    public String getYearOfJoin() {return yearOfJoin;}
    public String getCollegeCode() {return collegeCode;}
    public Date getDob() {return dob;}
    public char getGender() {return gender;}

    public void setName(String name) {this.name = name;}
    public void setDepartment(String department) {this.department = department;}
    public void setEmail(String email) {this.email = email;}
    public void setPhoneNumber(String phoneNumber) {this.phoneNumber = phoneNumber;}
    public void setYearOfJoin(String yearOfJoin) {this.yearOfJoin = yearOfJoin;}
    public void setCollegeCode(String collegeCode) {this.collegeCode = collegeCode;}
    public void setDob(Date dob) {this.dob = dob;}
    public void setGender(char gender) {this.gender = gender;}
}

class Teacher extends Person{

}

class Student extends Person{
    private String rollNumber, regNumber, section;

    public String getRollNumber() {return rollNumber;}
    public void setRollNumber(String rollNumber) {this.rollNumber = rollNumber;}
    public String getRegNumber() {return regNumber;}
    public void setRegNumber(String regNumber) {this.regNumber = regNumber;}
    public String getSection() {return section;}
    public void setSection(String section) {this.section = section;}
}