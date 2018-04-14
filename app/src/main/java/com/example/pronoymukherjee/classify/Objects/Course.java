package com.example.pronoymukherjee.classify.Objects;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This is an object for subject details.
 */

public class Course {
    private String code, name, teacherID, collegeID;
    private List<Section> sections; //students enrolled in this course.
    private int semester;
    private Teacher teacher; //teacher who made and teaches the course.


    public Course(String code, String courseName) {
        this.code = code;
        this.name = courseName;
        sections = new ArrayList<>();
    }

    public List<Section> getSections() {
        return sections;
    }

    public void setSections(List<Section> sections) {
        this.sections = sections;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public String getTeacherID() {
        return teacherID;
    }

    public void setTeacherID(String teacherID) {
        this.teacherID = teacherID;
    }

    public String getCollegeID() {
        return collegeID;
    }

    public void setCollegeID(String collegeID) {
        this.collegeID = collegeID;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public void addSection(Section section) {
        sections.add(section);
    }

    public void removeSsection(Section section) {
        sections.remove(section);
    }
}
