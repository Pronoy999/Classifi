package com.example.pronoymukherjee.classify.Helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by pronoymukherjee on 25/03/18.
 * This is the class to contain all the Database methods.
 */

public class DataBaseController {

    public static final String CLASS_TAG=DataBaseController.class.getSimpleName();

    public static class Helper extends SQLiteOpenHelper{
        public Helper(Context context){
            super(context,Constants.DATABASE_NAME,null,Constants.DATABASE_VERSION);
            Message.logMessages(CLASS_TAG,"Database Created.");
        }
        @Override
        public void onCreate(SQLiteDatabase sqLiteDatabase) {

        }

        @Override
        public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        }
    }
}
