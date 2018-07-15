package com.example.pronoymukherjee.classify.Helper;

import java.util.HashMap;

/**
 * Created by pronoymukherjee on 25/03/18.
 * This is the class to store all the constants used all over the app.
 */

public class Constants {

    /**
     * Database Object.
     */
    public static DataBaseController dataBaseController;
    /**
     * Database details.
     */
    static final String DATABASE_NAME = "ClassifyDatabase";
    static final int DATABASE_VERSION = 1;

    /**
     * Table name Details.
     */
    static final String PERSON_TABLE_NAME = "Person";
    static final String TEACHER_TABLE_NAME = "Teacher";
    static final String STUDENT_TABLE_NAME = "Student";
    static final String COURSE_TABLE_NAME = "Course";
    static final String COLLEGE_TABLE_NAME = "College";
    static final String JOIN_TABLE_NAME = "Joins";
    static final String SLOT_TABLE_NAME = "Slot";

    /**
     * Person Table Details.
     */
    static final String EMAIL_ID_DATABASE = "emailID";
    static final String ADDRESS_DATABASE = "address";
    static final String PHONE_NUMBER = "phoneNumber";
    static final String NAME_DATABASE = "name";
    static final String DOB_DATABASE = "dob";
    static final String DEPARTMENT_DATABASE = "dept";
    static final String GENDER_DATABASE = "gender";
    private static final String LAST_UPDATED = "lastUpdated";
    static final String PASSWORD_HASH = "passwordHash";
    static final String ACCOUNT = "account";

    /**
     * Teacher Table Details.
     */
    static final String YEAR_OF_JOINING_DATABASE = "yearOfJoining";
    static final String JOB_DESIGNATION_DATABASE = "jobDesignation";
    static final String PAST_JOB_DATABASE = "pastJob";
    static final String MAX_QUALIFICATION_DATABASE = "maxQualification";

    /**
     * Student Table Details.
     */
    static final String SCHOOL_DATABASE = "school";
    static final String DEGREE_DATABASE = "degree";
    static final String BSSID_DATABASE = "bssid";
    static final String REG_NUMBER_DATABASE = "regNumber";
    static final String ROLL_NUMBER_DATABASE = "rollNumber";
    static final String START_YEAR_DATABASE = "startYear";
    static final String END_YEAR_DATABASE = "endYear";

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
    public static final String COURSE_TOTAL = "total";
    public static final String COURSE_CODE = "courseCode";

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
    public static final String JOIN_STUDENT_ID = "studentID";
    public static final String JOIN_COURSE_ID = "courseID";

    /**
     * Slot Table Details.
     */
    public static final String SLOT_ID = "slotID";
    public static final String SLOT_END_TIME = "endTime";
    public static final String SLOT_START_TIME = "startTime";
    public static final String SLOT_DAY = "day";
    public static final String SLOT_COURSE_ID = "courseID";


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
            Constants.COLLEGE_NAME + " varchar(300), " +
            Constants.DEPARTMENT_DATABASE + " varchar(50), " +
            Constants.GENDER_DATABASE + "char(1), " +
            Constants.LAST_UPDATED + " TIME), " +
            Constants.PASSWORD_HASH + " varchar(300), " +
            Constants.ACCOUNT + " varchar(1));";
    /**
     * Create Student Table.
     */
    static final String CREATE_STUDENT_TABLE = "CREATE TABLE " +
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
    static final String CREATE_COURSE_TABLE = "CREATE TABLE " +
            Constants.COURSE_TABLE_NAME + " ( " +
            Constants.COURSE_ID + " INTEGER PRIMARY KEY AUTO_INCREMENT, " +
            Constants.COURSE_NAME + " varchar(100), " +
            Constants.COURSE_DEPT + " varchar(200), " +
            Constants.COURSE_SECTION + " varchar(10), " +
            Constants.COURSE_SEMESTER + " varchar(5), " +
            Constants.COURSE_TEACHER_ID + " varchar(255), " +
            Constants.COURSE_COLLEGE_ID + " varchar(50), " +
            Constants.COURSE_TOTAL + " INTEGER, " +
            Constants.COURSE_CODE + " varchar(30), " +
            "FOREIGN KEY " + Constants.COURSE_TEACHER_ID + " REFERENCES " +
            Constants.TEACHER_TABLE_NAME + " (" + Constants.EMAIL_ID_DATABASE + ")," +
            "FOREIGN KEY " + Constants.COURSE_COLLEGE_ID + " REFERENCES " +
            Constants.COLLEGE_TABLE_NAME + " (" + Constants.COLLEGE_ID + "));";

    /**
     * Create College Table.
     */
    static final String CREATE_COLLEGE_TABLE = "CREATE TABLE " +
            Constants.COLLEGE_TABLE_NAME + " ( " +
            Constants.COLLEGE_ID + " INTEGER PRIMARY KEY AUTO_INCREMENT, " +
            Constants.COLLEGE_UNIVERSITY_NAME + " varchar(255), " +
            Constants.COLLEGE_NAME + " varchar(255), " +
            Constants.COLLEGE_CITY + " varchar(255));";
    /**
     * Create Join Table.
     */
    static final String CREATE_JOIN_TABLE = "CREATE TABLE " +
            Constants.JOIN_TABLE_NAME + " ( " +
            Constants.JOIN_TIME + " time, " +
            Constants.JOIN_ATTENDED + " INTEGER, " +
            Constants.JOIN_STUDENT_ID + " varchar(255), " +
            Constants.JOIN_COURSE_ID + " varchar(300), " +
            "FOREIGN KEY " + Constants.JOIN_COURSE_ID + " REFERENCES " +
            Constants.COURSE_TABLE_NAME + " (" + Constants.COLLEGE_ID + "), " +
            "FOREIGN KEY " + Constants.JOIN_STUDENT_ID + " REFERENCES " +
            Constants.STUDENT_TABLE_NAME + " (" + Constants.EMAIL_ID_DATABASE + "));";

    /**
     * Create Slot Table.
     */
    static final String CREATE_SLOT_TABLE = "CREATE TABLE " +
            Constants.SLOT_TABLE_NAME + " ( " +
            Constants.SLOT_ID + " varchar(300), " +
            Constants.SLOT_START_TIME + " time, " +
            Constants.SLOT_END_TIME + " time, " +
            Constants.SLOT_DAY + " varchar(10), " +
            Constants.SLOT_COURSE_ID + " varchar(300)" +
            "FOREIGN KEY (" + Constants.SLOT_COURSE_ID + ") " + "REFERENCES " +
            Constants.COURSE_TABLE_NAME +
            " (" + Constants.COURSE_ID + "));";
    /**
     * Drop table Person.
     */
    static final String DROP_PERSON_TABLE = "DROP TABLE " + Constants.PERSON_TABLE_NAME;
    /**
     * Drop table Student.
     */
    static final String DROP_STUDENT_TABLE = "DROP TABLE " + Constants.STUDENT_TABLE_NAME;
    public static String LAST_UPDATED_LOCAL_TIME = "";
    public static final String JSON_INTENT_DATA = "jsonData";
    public static final String URL = "http://192.168.0.103/";
    /**
     * File Details.
     */
    public static final String USER_FILE_NAME = "userDetails.dat";
    public static final String ROOT_DIRECTORY_NAME = "Classifi";
    public static final String USER_DIRECTORY = "usr";
    /**
     * Error Detials.
     */
    public static final String GENERIC_ERROR_MESSAGE = "Ops Something went wrong.";

    /**
     * Service Detials.
     */
    public static final String SERVICE_KEY = "serviceKey";
    public static final String ADD_TEACHER_DETAILS_SERVICE = "teacherAdd";
    public static final String ADD_STUDENT_DETAILS_SERVICE = "studentAdd";
    /**
     * Map of the Response Code.
     */
    public static final HashMap<Integer, String> RESPONSE_CODES = new HashMap<>();

    /**
     * This is the method to fill the Response code of the Server.
     */
    public static void fillResponseCode() {
        RESPONSE_CODES.put(200, "OK");
        RESPONSE_CODES.put(301, "Invalid Query");
        RESPONSE_CODES.put(400, "Invalid JSON Structure");
        RESPONSE_CODES.put(498, "Invalid Token");
        RESPONSE_CODES.put(500, "Table doesn't exits");
    }

    /**
     * JSON Response KEYS.
     */
    public static final String JSON_STATUS = "status";
}
