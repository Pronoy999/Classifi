package com.example.pronoymukherjee.classify.Helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by pronoymukherjee on 25/03/18.
 * This is the class to contain all the Database methods.
 */

public class DataBaseController {

    public static final String CLASS_TAG = DataBaseController.class.getSimpleName();
    Helper helper;

    public DataBaseController(Context context) {
        helper = new Helper(context);
    }

    /**
     * This is the method to insert the data into the Student table.
     *
     * @param values: The values for the Student table mapped with the constants name.
     * @return: The ID after insertion. -1 if not error.
     */
    private long insertDataStudent(ContentValues values) {
        SQLiteDatabase sqLiteDatabase = helper.getWritableDatabase();
        return sqLiteDatabase.insert(Constants.STUDENT_TABLE_NAME, null, values);
    }

    /**
     * This is the method to insert the data into the person table.
     *
     * @param values: The values for the Person table mapped with the constants name.
     * @return: The ID after Insertion. -1 if error.
     */
    public long insertDataPerson(ContentValues values) {
        SQLiteDatabase sqLiteDatabase = helper.getWritableDatabase();
        return sqLiteDatabase.insert(Constants.PERSON_TABLE_NAME, null, values);
    }

    /**
     * This is the method to insert the data into the Teacher Table.
     *
     * @param values: The values for the Teacher table mapped with the constants name.
     * @return: The ID after Insertion. -1 if error.
     */
    private long insertDataTeacher(ContentValues values) {
        SQLiteDatabase sqLiteDatabase = helper.getWritableDatabase();
        return sqLiteDatabase.insert(Constants.TEACHER_TABLE_NAME, null, values);
    }

    /**
     * This is the method to insert the data into the College Table.
     *
     * @param values: The values for the College table mapped with the constants name.
     * @return: The ID after Insertion. -1 if error.
     */
    public long inserDataCollege(ContentValues values) {
        SQLiteDatabase sqLiteDatabase = helper.getWritableDatabase();
        return sqLiteDatabase.insert(Constants.COLLEGE_TABLE_NAME, null, values);
    }

    /**
     * This is the Method to call to insert the detials of both the Student and teacher.
     *
     * @param values: The Content Values containing the details of the user.
     * @return: -1 if ERROR, else POSITIVE INTEGER.
     */
    public long insertUserData(ContentValues values) {
        if (values.getAsString(Constants.ACCOUNT).equalsIgnoreCase("T")) {
            return insertDataTeacher(values);
        }
        return insertDataStudent(values);
    }

    /**
     * This is the method to get the teacher details.
     *
     * @return: The JSON Containing the details of the teacher.
     */
    public JSONObject getTeacherData() {
        JSONObject teacherData = new JSONObject();
        String query = "SELECT * FROM " + Constants.PERSON_TABLE_NAME;
        SQLiteDatabase sqLiteDatabase = helper.getWritableDatabase();
        Cursor personCursor = sqLiteDatabase.rawQuery(query, null);
        query = "SELECT * FROM " + Constants.TEACHER_TABLE_NAME;
        Cursor teacherCursor = sqLiteDatabase.rawQuery(query, null);
        try {
            while (!personCursor.moveToNext()) {
                teacherData.put(Constants.EMAIL_ID_DATABASE, personCursor.getString(0));
                teacherData.put(Constants.ADDRESS_DATABASE, personCursor.getString(1));
                teacherData.put(Constants.PHONE_NUMBER, personCursor.getString(2));
                teacherData.put(Constants.NAME_DATABASE, personCursor.getString(3));
                teacherData.put(Constants.DOB_DATABASE, personCursor.getString(4));
                teacherData.put(Constants.DEPARTMENT_DATABASE, personCursor.getString(5));
                teacherData.put(Constants.GENDER_DATABASE, personCursor.getString(6));
                teacherData.put(Constants.PASSWORD_HASH, personCursor.getString(8));
                teacherData.put(Constants.ACCOUNT, personCursor.getString(9));
                teacherData.put(Constants.COLLEGE_NAME, personCursor.getString(10));
            }
            while (!teacherCursor.moveToNext()) {
                teacherData.put(Constants.YEAR_OF_JOINING_DATABASE, teacherCursor.getString(1));
                teacherData.put(Constants.JOB_DESIGNATION_DATABASE, teacherCursor.getString(2));
                teacherData.put(Constants.PAST_JOB_DATABASE, teacherCursor.getString(3));
                teacherData.put(Constants.MAX_QUALIFICATION_DATABASE, teacherCursor.getString(4));
            }

        } catch (JSONException e) {
            Message.logMessages(CLASS_TAG, e.toString());
        } finally {
            if (personCursor != null) {
                personCursor.close();
            }
            if (teacherCursor != null) {
                teacherCursor.close();
            }
        }
        return teacherData;
    }

    /**
     * This is the method to get all the data from the student table.
     *
     * @return: The JSON Object containing the data of the student.
     */
    public JSONObject getStudentData() {
        JSONObject studentData = new JSONObject();
        String query = "SELECT * FROM " + Constants.PERSON_TABLE_NAME;
        SQLiteDatabase sqLiteDatabase = helper.getWritableDatabase();
        Cursor personCursor = sqLiteDatabase.rawQuery(query, null);
        query = "SELECT * FROM " + Constants.STUDENT_TABLE_NAME;
        Cursor studentCursor = sqLiteDatabase.rawQuery(query, null);
        try {
            while (!personCursor.moveToNext()) {
                studentData.put(Constants.EMAIL_ID_DATABASE, personCursor.getString(0));
                studentData.put(Constants.ADDRESS_DATABASE, personCursor.getString(1));
                studentData.put(Constants.PHONE_NUMBER, personCursor.getString(2));
                studentData.put(Constants.NAME_DATABASE, personCursor.getString(3));
                studentData.put(Constants.DOB_DATABASE, personCursor.getString(4));
                studentData.put(Constants.DEPARTMENT_DATABASE, personCursor.getString(5));
                studentData.put(Constants.GENDER_DATABASE, personCursor.getString(6));
                studentData.put(Constants.PASSWORD_HASH, personCursor.getString(8));
                studentData.put(Constants.ACCOUNT, personCursor.getString(9));
                studentData.put(Constants.COLLEGE_NAME, personCursor.getString(10));
            }
            while (!studentCursor.moveToNext()) {
                studentData.put(Constants.SCHOOL_DATABASE, studentCursor.getString(1));
                studentData.put(Constants.DEGREE_DATABASE, studentCursor.getString(2));
                studentData.put(Constants.BSSID_DATABASE, studentCursor.getString(3));
                studentData.put(Constants.REG_NUMBER_DATABASE, studentCursor.getString(4));
                studentData.put(Constants.ROLL_NUMBER_DATABASE, studentCursor.getString(5));
                studentData.put(Constants.START_YEAR_DATABASE, studentCursor.getString(6));
                studentData.put(Constants.END_YEAR_DATABASE, studentCursor.getString(7));
            }
        } catch (JSONException e) {
            Message.logMessages(CLASS_TAG, e.toString());
        }
        return studentData;
    }


    public static class Helper extends SQLiteOpenHelper {
        public Helper(Context context) {
            super(context, Constants.DATABASE_NAME, null, Constants.DATABASE_VERSION);
            Message.logMessages(CLASS_TAG, "Database Created.");
        }

        @Override
        public void onCreate(SQLiteDatabase sqLiteDatabase) {
            try {
                sqLiteDatabase.execSQL(Constants.CREATE_PERSON_TABLE);
                sqLiteDatabase.execSQL(Constants.CREATE_STUDENT_TABLE);
                sqLiteDatabase.execSQL(Constants.CREATE_COLLEGE_TABLE);
                sqLiteDatabase.execSQL(Constants.CREATE_TEACHER_TABLE);
                sqLiteDatabase.execSQL(Constants.CREATE_COURSE_TABLE);
                sqLiteDatabase.execSQL(Constants.CREATE_JOIN_TABLE);
                sqLiteDatabase.execSQL(Constants.CREATE_SLOT_TABLE);
                Message.logMessages(CLASS_TAG, "Tables Created.");
            } catch (SQLException e) {
                Message.logMessages(CLASS_TAG, e.toString());
            }
        }

        @Override
        public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
            try {
                sqLiteDatabase.execSQL(Constants.DROP_PERSON_TABLE);
                sqLiteDatabase.execSQL(Constants.DROP_STUDENT_TABLE);
                //TODO: Add the rest of drop table.
            } catch (SQLException e) {
                Message.logMessages(CLASS_TAG, e.toString());
            }
        }
    }
}
