package com.example.pronoymukherjee.classify.Objects;

import java.util.Date;
import java.util.Map;

/**Class representing a student.
 * Created by Debanik on 01-04-2018.
 */

public class Student extends Person{
    private String rollNumber, regNumber, section;
    private String SSID, PSK; // wifi hotspot name and password.
    private String BSSID; //wifi hotspot BSSID

    public Student(String ID, String name, String department, String email, String phoneNumber,
                   String yearOfJoin, Date dob, char gender, College college, String rollNumber,
                   String regNumber, String section) {
        super(ID, name, department, email, phoneNumber, yearOfJoin, dob, gender, college);
        this.rollNumber = rollNumber;
        this.regNumber = regNumber;
        this.section = section;

    }

    public String getBSSID() {
        return BSSID;
    }

    public void setBSSID(String BSSID) {
        this.BSSID = BSSID;
    }

    public String getSSID() {return SSID;}

    public void setSSID(String SSID) {this.SSID = SSID;}

    public String getPSK() {return PSK;}

    public void setPSK(String PSK) {this.PSK = PSK;}

    public String getRollNumber() {return rollNumber;}
    public void setRollNumber(String rollNumber) {this.rollNumber = rollNumber;}
    public String getRegNumber() {return regNumber;}
    public void setRegNumber(String regNumber) {this.regNumber = regNumber;}
    public String getSection() {return section;}
    public void setSection(String section) {this.section = section;}

    public boolean enrollToCourse(Course course){
        courses.add(course);
        courseMap.put(course.getCode(), course);
        course.getStudents().add(this);

        return true;
    }

    public boolean unenrollFromCourse(Course course){
        if (!courseMap.containsKey(course.getCode())) { return false; }

        courses.remove(course);
        courseMap.remove(course.getCode());
        course.getStudents().remove(this);
        return true;
    }

    public void markPresent(Course course){
        Map<Student, Attendance> attendanceMap =
                course.getAttendanceMap();
        Attendance attendance = attendanceMap.get(this);
        attendance.setAttended(attendance.getAttended()+1);
        attendance.setTotal(attendance.getTotal()+1);

        attendanceMap.put(this, attendance);
    }

    public void markAbsent(Course course){
        Map<Student, Attendance> attendanceMap =
                course.getAttendanceMap();
        Attendance attendance = attendanceMap.get(this);
        attendance.setTotal(attendance.getTotal()+1);

        attendanceMap.put(this, attendance);
    }
}