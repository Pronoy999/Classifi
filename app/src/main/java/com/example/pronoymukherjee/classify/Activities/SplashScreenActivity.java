package com.example.pronoymukherjee.classify.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.pronoymukherjee.classify.Helper.Constants;
import com.example.pronoymukherjee.classify.Helper.DataBaseController;
import com.example.pronoymukherjee.classify.Helper.DatabaseService;
import com.example.pronoymukherjee.classify.R;


public class SplashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        //Declaring the DatabaseController object.
        Constants.dataBaseController=new DataBaseController(getApplicationContext());

        /*SharedPreferences sharedPreferences=getPreferences(MODE_PRIVATE);
        Constants.LAST_UPDATED_LOCAL_TIME=sharedPreferences.getString(Constants.LAST_UPDATED,"");
        if(Constants.LAST_UPDATED_LOCAL_TIME.equals("")){
            Constants.LAST_UPDATED_LOCAL_TIME=String.valueOf(System.currentTimeMillis());
        }*/

       startService(new Intent(SplashScreenActivity.this, DatabaseService.class));
    }
}
