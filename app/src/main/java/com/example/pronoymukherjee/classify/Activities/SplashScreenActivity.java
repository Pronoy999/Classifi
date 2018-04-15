package com.example.pronoymukherjee.classify.Activities;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.pronoymukherjee.classify.Helper.FileManager;
import com.example.pronoymukherjee.classify.Objects.Course;
import com.example.pronoymukherjee.classify.Objects.StudyMaterial;
import com.example.pronoymukherjee.classify.R;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

import com.example.pronoymukherjee.classify.Exceptions.WriteToSDCardException;

public class SplashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

        startActivityForResult(cameraIntent, 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        data.getExtras();
        Log.d("RESULT", "RESULT");
        //if(data.getData()==null)
            //return;
        StudyMaterial material =
                new StudyMaterial(Uri.parse(data.getData().toString()),
                        new Date(15,15,15),
                        "LOL",
                        StudyMaterial.TYPE_TEXT);

        FileManager fm = FileManager.getInstance(this);

        Course course = new Course("CS201", "CO");
        try {
            fm.addMaterialForCourse(material, course, false);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (WriteToSDCardException e) {
            e.printStackTrace();
        }
    }
}
