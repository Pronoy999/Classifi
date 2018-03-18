package com.example.pronoymukherjee.classify.Objects;

/**
 * The object of every college.
 */

public class College {
    private String collegeCode;
    private String collegeName;
    private String city;
    public College(String collegeCode,String collegeName,String city){
        this.collegeCode=collegeCode;
        this.collegeName=collegeName;
        this.city=city;
    }

    public String getCollegeCode() {return collegeCode;}

    public void setCollegeCode(String collegeCode) {this.collegeCode = collegeCode;}

    public String getCollegeName() {return collegeName;}

    public void setCollegeName(String collegeName) {this.collegeName = collegeName;}

    public String getCity() {return city;}

    public void setCity(String city) {this.city = city;}
}
