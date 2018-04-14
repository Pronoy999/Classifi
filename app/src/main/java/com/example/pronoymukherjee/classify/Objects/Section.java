package com.example.pronoymukherjee.classify.Objects;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A class representing a section.
 * Created by Debanik on 14-04-2018.
 */

public class Section {
    private List<Student> students;
    private Map<Student, Attendance> attendanceMap;
    private Course parentCourse;
    private String name;

    Section(Course parentCourse, String name){
        this.parentCourse = parentCourse;
        attendanceMap = new HashMap<>();
        students = new ArrayList<>();
        this.name = name;
    }
    public void addStudent(Student student){
        students.add(student);
        attendanceMap.put(student, new Attendance(student.getEmail(), parentCourse.getCode(), 0, 0));
    }
    public void removeStudent(Student student){
        students.remove(student);
        attendanceMap.remove(student);
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public Map<Student, Attendance> getAttendanceMap() {
        return attendanceMap;
    }

    public void setAttendanceMap(Map<Student, Attendance> attendanceMap) {
        this.attendanceMap = attendanceMap;
    }

    public Course getParentCourse() {
        return parentCourse;
    }

    public void setParentCourse(Course parentCourse) {
        this.parentCourse = parentCourse;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
