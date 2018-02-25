package com.example.pronoymukherjee.classify.Objects;

/**
 * This is the class for the Attendance.
 */

public class Attendance {
    private String email,subjectCode;
    private int total,attended;
    public Attendance(String email,String subjectCode,int total,int attended){
        this.email=email;
        this.subjectCode=subjectCode;
        this.attended=attended;
        this.total=total;
    }

    public String getEmail() {return email;}

    public void setEmail(String email) {this.email = email;}

    public String getSubjectCode() {return subjectCode;}

    public void setSubjectCode(String subjectCode) {this.subjectCode = subjectCode;}

    public int getTotal() {return total;}

    public void setTotal(int total) {this.total = total;}

    public int getAttended() {return attended;}

    public void setAttended(int attended) {this.attended = attended;}
}
