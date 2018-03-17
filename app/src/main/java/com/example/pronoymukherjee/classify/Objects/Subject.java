package com.example.pronoymukherjee.classify.Objects;

/**
 * This is an object for subject details.
 */

public class Subject {
    private String subjectCode, subjectName;
    public Subject(String subjectCode, String subjectName){
        this.subjectCode=subjectCode;
        this.subjectName=subjectName;
    }

    public String getSubjectCode() {
        return subjectCode;
    }

    public void setSubjectCode(String subjectCode) {
        this.subjectCode = subjectCode;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }
}
