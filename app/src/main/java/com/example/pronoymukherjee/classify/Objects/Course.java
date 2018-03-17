package com.example.pronoymukherjee.classify.Objects;

/**
 * This is an object for subject details.
 */

public class Course {
    private String courseCode, courseName;
    public Course(String courseCode, String courseName){
        this.courseCode = courseCode;
        this.courseName = courseName;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
}
