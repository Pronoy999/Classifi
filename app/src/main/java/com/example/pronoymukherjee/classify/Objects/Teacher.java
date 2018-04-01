package com.example.pronoymukherjee.classify.Objects;

import java.util.Date;

/**Class representing a teacher.
 * Created by Debanik on 01-04-2018.
 */

public class Teacher extends Person{

    public Teacher(String ID, String name, String department, String email, String phoneNumber,
                   String yearOfJoin, Date dob, char gender, College college) {
        super(ID, name, department, email, phoneNumber, yearOfJoin, dob, gender, college);
    }


    public Course makeCourse(String courseCode, String courseName, String section, int semester){
        Course newCourse = new Course(courseCode, courseName);
        newCourse.setTeacherID(this.ID);
        newCourse.setCollegeID(this.college.getCollegeCode());
        newCourse.setSection(section);
        newCourse.setSemester(semester);
        newCourse.setTeacher(this);

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
