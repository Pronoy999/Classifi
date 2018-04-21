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
        Bundle bundle=intent.getExtras();
        if(bundle!=null) {
            if (bundle.get(Constants.SERVICE_KEY).toString().
                    equalsIgnoreCase(Constants.ADD_TEACHER_DETAILS_SERVICE)) {
                JSONObject jsonObject=Constants.dataBaseController.getTeacherData();
                //TODO: Make Query.
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
