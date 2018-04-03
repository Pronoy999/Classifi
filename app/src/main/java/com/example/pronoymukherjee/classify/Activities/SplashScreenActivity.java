package com.example.pronoymukherjee.classify.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ProgressBar;

import com.example.pronoymukherjee.classify.Helper.AttendanceTaker;
import com.example.pronoymukherjee.classify.Objects.Attendance;
import com.example.pronoymukherjee.classify.Objects.College;
import com.example.pronoymukherjee.classify.Objects.Course;
import com.example.pronoymukherjee.classify.Objects.Student;
import com.example.pronoymukherjee.classify.Objects.Teacher;
import com.example.pronoymukherjee.classify.R;

import java.util.Date;

public class SplashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

    }
}
