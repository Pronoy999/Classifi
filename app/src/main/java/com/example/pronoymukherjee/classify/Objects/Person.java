package com.example.pronoymukherjee.classify.Objects;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Person base class for a generic user on the site.
 */

abstract class Person {
    protected String ID;
    protected String name;
    protected String department;
    protected String email;
    protected String phoneNumber;
    protected String yearOfJoin;
    protected Date dob;
    protected char gender;
    protected College college;

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

class Teacher extends Person{
    private List<Course> courses;
    private Map<String, Course> courseMap;

    Teacher(){
        courses = new ArrayList<>();
        courseMap = new HashMap<>();
    }

    public Course makeCourse(String courseCode, String courseName, String section, int semester){
        Course newCourse = new Course(courseCode, courseName);
        newCourse.setTeacherID(this.ID);
        newCourse.setCollegeID(this.college.getCollegeCode());
        newCourse.setSection(section);
        newCourse.setSemester(semester);
        courses.add(newCourse);
        courseMap.put(courseCode, newCourse);
        return newCourse;
    }
    public boolean removeCourse(String courseCode){
        if (!courseMap.containsKey(courseCode)){return false;}
        courses.remove(courseMap.get(courseCode));
        courseMap.remove(courseCode);
        return true;
    }

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