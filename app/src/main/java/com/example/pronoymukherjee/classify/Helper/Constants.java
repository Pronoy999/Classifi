package com.example.pronoymukherjee.classify.Helper;

/**
 * Created by pronoymukherjee on 25/03/18.
 * This is the class to store all the constants used all over the app.
 */

public class Constants {
    /**
     * Database details.
     */
    public static final String DATABASE_NAME = "ClassifyDatabase";
    public static final int DATABASE_VERSION = 1;

    /**
     * Table name Details.
     */
    public static final String PERSON_TABLE_NAME = "Person";
    public static final String TEACHER_TABLE_NAME = "Teacher";
    public static final String STUDENT_TABLE_NAME = "Student";
    public static final String COURSE_TABLE_NAME = "Course";
    public static final String COLLEGE_TABLE_NAME = "College";
    public static final String JOIN_TABLE_NAME = "Joins";
    public static final String SLOT_TABLE_NAME = "Slot";

    /**
     * Person Table Details.
     */
    public static final String EMAIL_ID_DATABASE = "emailID";
    public static final String ADDRESS_DATABASE = "address";
    public static final String PHONE_NUMBER = "phoneNumber";
    public static final String NAME_DATABASE = "name";
    public static final String DOB_DATABASE = "dob";
    public static final String DEPARTMENT_DATABASE = "dept";
    public static final String GENDER_DATABASE = "gender";

    /**
     * Teacher Table Details.
     */
    public static final String YEAR_OF_JOINING_DATABASE = "yearOfJoining";
    public static final String JOB_DESIGNATION_DATABASE = "jobDesignation";
    public static final String PAST_JOB_DATABASE = "pastJob";
    public static final String MAX_QUALIFICATION_DATABASE = "maxQualification";

    /**
     * Student Table Details.
     */
    public static final String SCHOOL_DATABASE = "school";
    public static final String DEGREE_DATABASE = "degree";
    public static final String BSSID_DATABASE = "bssid";
    public static final String REG_NUMBER_DATABASE = "regNumber";
    public static final String ROLL_NUMBER_DATABASE = "rollNumber";
    public static final String START_YEAR_DATABASE = "startYear";
    public static final String END_YEAR_DATABASE = "endYear";

    /**
     * Course Table Details.
     */
    public static final String COURSE_ID = "courseID";
    public static final String COURSE_NAME = "courseName";
    public static final String COURSE_DEPT = "dept";
    public static final String COURSE_SECTION = "section";
    public static final String COURSE_SEMESTER = "semester";
    public static final String COURSE_TEACHER_ID = "teacherEmailID";
    public static final String COURSE_COLLEGE_ID = "collegeID";

    /**
     * College Table Details.
     */
    public static final String COLLEGE_ID = "id";
    public static final String COLLEGE_NAME = "collegeName";
    public static final String COLLEGE_UNIVERSITY_NAME = "universityName";
    public static final String COLLEGE_CITY = "city";

    /**
     * Join Table Details.
     */
    public static final String JOIN_TIME = "joinTime";
    public static final String JOIN_ATTENDED = "attended";
    public static final String JOIN_TOTAL = "total";
    public static final String JOIN_STUDENT_ID = "sid";
    public static final String JOIN_COURSE_ID = "crsID";

    /**
     * Slot Table Details.
     */
    public static final String SLOT_ID = "slotID";
    public static final String SLOT_END_TIME = "endTime";
    public static final String SLOT_START_TIME = "startTime";
    public static final String SLOT_DAY = "day";
    public static final String SLOT_COURSE_ID = "crsID";


    /**
     * Create Teacher Table.
     */
    public static final String CREATE_TEACHER_TABLE = "CREATE TABLE " +
            Constants.TEACHER_TABLE_NAME + " ( " +
            Constants.EMAIL_ID_DATABASE + " varchar(255), " +
            Constants.YEAR_OF_JOINING_DATABASE + " varchar(4), " +
            Constants.JOB_DESIGNATION_DATABASE + " varchar(100), " +
            Constants.PAST_JOB_DATABASE + " varchar(100), " +
            Constants.MAX_QUALIFICATION_DATABASE + " varchar(100), " +
            "FOREIGN KEY (" + Constants.EMAIL_ID_DATABASE + ") " +
            "REFERENCES " + Constants.PERSON_TABLE_NAME + " (" + Constants.EMAIL_ID_DATABASE + "));";

    /**
     * Create Person Table.
     */
    public static final String CREATE_PERSON_TABLE = "CREATE TABLE " +
            Constants.PERSON_TABLE_NAME + " ( " +
            Constants.EMAIL_ID_DATABASE + " varchar(255) PRIMARY KEY, " +
            Constants.ADDRESS_DATABASE + " varchar(255), " +
            Constants.PHONE_NUMBER + " varchar(10), " +
            Constants.NAME_DATABASE + " varchar(255), " +
            Constants.DOB_DATABASE + " DATE, " +
            Constants.DEPARTMENT_DATABASE + " varchar(50), " +
            Constants.GENDER_DATABASE + "char(1) );";
    /**
     * Create Student Table.
     */
    public static final String CREATE_STUDENT_TABLE = "CREATE TABLE " +
            Constants.STUDENT_TABLE_NAME + " ( " +
            Constants.EMAIL_ID_DATABASE + " varchar(255), " +
            Constants.SCHOOL_DATABASE + " varchar(255), " +
            Constants.DEGREE_DATABASE + " varchar(20), " +
            Constants.BSSID_DATABASE + " varchar(20), " +
            Constants.ROLL_NUMBER_DATABASE + " varchar(100), " +
            Constants.REG_NUMBER_DATABASE + " varchar(100), " +
            Constants.START_YEAR_DATABASE + " varchar(4), " +
            Constants.END_YEAR_DATABASE + " varchar(4), " +
            "FOREIGN KEY (" + Constants.EMAIL_ID_DATABASE + ") REFERENCES " +
            Constants.PERSON_TABLE_NAME + " (" + Constants.EMAIL_ID_DATABASE + "));";
    /**
     * Create Course Table.
     */
    public static final String CREATE_COURSE_TABLE = "CREATE TABLE " + Constants.COURSE_TABLE_NAME + " ( " +
            Constants.COURSE_ID + " varchar(300), " +
            Constants.COURSE_NAME + " varchar(100), " +
            Constants.COURSE_DEPT + " varchar(200), " +
            Constants.COURSE_SECTION + " varchar(10), " +
            Constants.COURSE_SEMESTER + " varchar(5), " +
            Constants.COURSE_TEACHER_ID + " varchar(255), " +
            Constants.COURSE_COLLEGE_ID + " varchar(50), " +
            "FOREIGN KEY " + Constants.COURSE_TEACHER_ID + " REFERENCES " +
            Constants.TEACHER_TABLE_NAME + " (" + Constants.EMAIL_ID_DATABASE + ")," +
            "FOREIGN KEY " + Constants.COURSE_COLLEGE_ID + " REFERENCES " +
            Constants.COLLEGE_TABLE_NAME + " (" + Constants.COLLEGE_ID + "));";

    /**
     * Create College Table.
     */
    public static final String CREATE_COLLEGE_TABLE = "CREATE TABLE " + Constants.COLLEGE_TABLE_NAME + " ( " +
            Constants.COLLEGE_ID + " varchar(50), " +
            Constants.COLLEGE_UNIVERSITY_NAME + " varchar(255), " +
            Constants.COLLEGE_NAME + " varchar(255), " +
            Constants.COLLEGE_CITY + " varchar(255));";
    /**
     * Create Join Table.
     */
    public static final String CREATE_JOIN_TABLE = "CREATE TABLE " + Constants.JOIN_TABLE_NAME + " ( " +
            Constants.JOIN_TIME + " time, " +
            Constants.JOIN_ATTENDED + " INTEGER, " +
            Constants.JOIN_TOTAL + "INTEGER, " +
            Constants.JOIN_STUDENT_ID + " varchar(255), " +
            Constants.JOIN_COURSE_ID + " varchar(300), " +
            "FOREIGN KEY " + Constants.JOIN_COURSE_ID + " REFERENCES " +
            Constants.COURSE_TABLE_NAME + " ( " + Constants.COLLEGE_ID + "));";

    /**
     * Create Slot Table.
     */
    public static final String CREATE_SLOT_TABLE = "CREATE TABLE " + Constants.SLOT_TABLE_NAME + " ( " +
            Constants.SLOT_ID + " varchar(300), " +
            Constants.SLOT_START_TIME + " time, " +
            Constants.SLOT_END_TIME + " time, " +
            Constants.SLOT_DAY + " varchar(10), " +
            Constants.SLOT_COURSE_ID + " varchar(300)" +
            "FOREIGN KEY (" + Constants.SLOT_COURSE_ID + ") " + "REFERENCES " + Constants.COURSE_TABLE_NAME +
            " (" + Constants.COURSE_ID + "));";
    /**
     * Drop table Person.
     */
    public static final String DROP_PERSON_TABLE = "DROP TABLE " + Constants.PERSON_TABLE_NAME;
    /**
     * Drop table Student.
     */
    public static final String DROP_STUDENT_TABLE = "DROP TABLE " + Constants.STUDENT_TABLE_NAME;
}
