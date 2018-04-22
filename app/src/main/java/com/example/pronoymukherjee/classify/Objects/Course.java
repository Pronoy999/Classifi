package com.example.pronoymukherjee.classify.Objects;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This is an object for subject details.
 */

public class Course {
    private String code, name, section, teacherID, collegeID, department;
    private List<Student> students; //students enrolled in this course.
    private Map<Student, Attendance> attendanceMap;
    private int semester;
    private Teacher teacher; //teacher who made and teaches the course.


    public Course(String code, String name, String section,
                  int semester, Teacher teacher) {
        this.code = code;
        this.name = name;
        this.section=section;
        this.teacherID = teacher.getID();
        this.department=teacher.getDepartment();
        this.collegeID = teacher.getCollege().getCollegeCode();
        this.semester=semester;
        students = new  ArrayList<>();
        attendanceMap = new HashMap<>();
        fillAttendanceMap();
    }

    public Map<Student, Attendance> getAttendanceMap() {
        return attendanceMap;
    }

    public void setAttendanceMap(Map<Student, Attendance> attendanceMap) {
        this.attendanceMap = attendanceMap;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
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

    /**
     * This is the method to initialize the map with the students and the attendance.
     */
    private void fillAttendanceMap() {
        for (Student student : students) {
            attendanceMap.put(student, new Attendance(student.getEmail(), code, 0, 0));
        }
    }

    /**
     * This is the method to update the attendance of the student who were present.
     *
     * @param student: The student object who were present.
     */
    public void updateAttendanceMap(Student student) {
        Attendance attendance = attendanceMap.get(student);
        attendance.incrementAttendance();
        attendanceMap.put(student, attendance);
    }
}
