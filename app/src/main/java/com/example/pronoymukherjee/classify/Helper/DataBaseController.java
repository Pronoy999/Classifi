package com.example.pronoymukherjee.classify.Helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

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
    public long insertDataStudent(ContentValues values) {
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
    public long insertDataTeacher(ContentValues values) {
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
