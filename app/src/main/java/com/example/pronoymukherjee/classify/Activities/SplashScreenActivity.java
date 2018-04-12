package com.example.pronoymukherjee.classify.Activities;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ProgressBar;

import com.example.pronoymukherjee.classify.Helper.AttendanceTaker;
import com.example.pronoymukherjee.classify.Helper.FileManager;
import com.example.pronoymukherjee.classify.Objects.Attendance;
import com.example.pronoymukherjee.classify.Objects.College;
import com.example.pronoymukherjee.classify.Objects.Course;
import com.example.pronoymukherjee.classify.Objects.Student;
import com.example.pronoymukherjee.classify.Objects.StudyMaterial;
import com.example.pronoymukherjee.classify.Objects.Teacher;
import com.example.pronoymukherjee.classify.R;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

import Exceptions.WriteToSDCardException;

public class SplashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        File file = new File(Environment.getExternalStorageDirectory().getPath()+"/LOL.txt");
        try{
            FileWriter fw = new FileWriter(file);
            fw.write("HELLO WORLD");
            fw.flush();
            fw.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        StudyMaterial material = new StudyMaterial(file, new Date(2018, 12, 4));
        FileManager fm = FileManager.getInstance(this);

        Course course = new Course("CS201", "CO");
        try {
            fm.addMaterialForCourse(material, course, false);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (WriteToSDCardException e) {
            e.printStackTrace();
        }
        file.delete();
    }
}
