package com.example.pronoymukherjee.classify.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.pronoymukherjee.classify.Helper.SingleTon;

public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        SingleTon channel = SingleTon.getInstance(this);
        channel.removeFromREquestQueue(this.getClass().getSimpleName());
    }
}
