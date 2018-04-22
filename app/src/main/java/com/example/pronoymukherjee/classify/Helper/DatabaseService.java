package com.example.pronoymukherjee.classify.Helper;

import android.app.IntentService;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;

import com.example.pronoymukherjee.classify.Activities.SplashScreenActivity;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by pronoymukherjee on 15/04/18.
 * Class to create the Service.
 */

public class DatabaseService extends IntentService implements HTTPConnector.ResponseListener {
    HTTPConnector httpConnector;
    public static final String CLASS_TAG = DatabaseService.class.getSimpleName();

    public DatabaseService() {
        super("DatabaseService");
    }

    /**
     * This is the method to make the HTTP Query in the server.
     * @param intent: The Intent Specifying the type of query to make in the server.
     */
    @Override
    protected void onHandleIntent(Intent intent) {
        Bundle bundle = intent.getExtras();
        String query = "";
        JSONObject jsonObject=null;
        if (bundle != null) {
            String serviceKey = bundle.get(Constants.SERVICE_KEY).toString();
            switch (serviceKey) {
                case Constants.ADD_TEACHER_DETAILS_SERVICE:
                    jsonObject = Constants.dataBaseController.getTeacherData();
                    //TODO: Change the QueryURL.
                    query = "";
                    break;
                case Constants.ADD_STUDENT_DETAILS_SERVICE:
                    jsonObject = Constants.dataBaseController.getTeacherData();
                    //TODO:Change the Query URL.
                    query = "";
            }
        }
        httpConnector = new HTTPConnector(getApplicationContext(),
                query,
                this,
                CLASS_TAG);
        httpConnector.makeQuery(jsonObject);
    }

    @Override
    public void onDestroy() {
        Message.logMessages(CLASS_TAG, "Service Destroyed.");
        super.onDestroy();
    }

    @Override
    public void onResponse(JSONObject response) {
    }
}
