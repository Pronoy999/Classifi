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
     * Joins table Details.
     */
    public static final String TIME_DATABASE = "time";
    public static final String ATTENDED_DATABASE = "attended";
    public static final String TOTAL_DATABASE = "total";
    public static final String SID_DATABASE = "sid";
    public static final String CRS_ID_DATABASE = "crsID";

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
            Constants.PHONE_NUMBER + " varchar(255), " +
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
}
