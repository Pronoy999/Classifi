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
    private String serviceKey="";

    public DatabaseService() {
        super("DatabaseService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        Bundle bundle=intent.getExtras();
        String query="";
        if(bundle!=null) {
            serviceKey=bundle.get(Constants.SERVICE_KEY).toString();
            if (serviceKey.equalsIgnoreCase(Constants.ADD_TEACHER_DETAILS_SERVICE)) {
                JSONObject jsonObject=Constants.dataBaseController.getTeacherData();
                //TODO: Change the QueryURL.
                query="";
            }            
        }
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
