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

    @Override
    protected void onHandleIntent(Intent intent) {
        Message.logMessages(CLASS_TAG, "***SERVICE STARTED.***");
        //Bundle bundle=intent.getExtras();
        httpConnector=new HTTPConnector(getApplicationContext(),Constants.URL,this);
        Message.logMessages(CLASS_TAG, "SERVICE BUNDLE.");
        //String json = bundle.getString(Constants.JSON_INTENT_DATA);
        Message.logMessages(CLASS_TAG, "Making Query.");
        try {
            //httpConnector.makeQuery(new JSONObject(json));
            httpConnector.makeQuery();
        } catch (Exception e) {
            Message.logMessages(CLASS_TAG, e.toString());
        }

    }

    @Override
    public void onDestroy() {
        Message.logMessages(CLASS_TAG, "Service Destroyed.");
        super.onDestroy();
    }

    @Override
    public void onResponse(JSONObject response) {
        /*try {
            String timeStamp=response.getString(Constants.LAST_UPDATED);
            if(timeStamp.compareTo(Constants.LAST_UPDATED_LOCAL_TIME)>0){
                //TODO:Update the Local with the Server.
            }
            else if(timeStamp.compareTo(Constants.LAST_UPDATED_LOCAL_TIME)<0){
                //TODO:Fetch the data from server and Update local.
            }
        } catch (JSONException e) {
            Message.logMessages(CLASS_TAG,e.toString());
        }*/
        Message.logMessages(CLASS_TAG, response.toString());
    }
}
