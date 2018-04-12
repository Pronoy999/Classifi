package com.example.pronoymukherjee.classify.Helper;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.media.MediaScannerConnection;
import android.os.Environment;
import android.os.storage.StorageManager;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.pronoymukherjee.classify.Objects.Course;
import com.example.pronoymukherjee.classify.Objects.StudyMaterial;
import com.example.pronoymukherjee.classify.R;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.WriteAbortedException;

import Exceptions.WriteToSDCardException;

/**
 * Class to manage files on the storage.
 * Created by Debaik on 11-04-2018.
 */

public class FileManager {

    private static FileManager instance = null;
    private static Context context;
    private FileManager(Context c){
        instance = this;
        context = c.getApplicationContext();
    }
    public static synchronized FileManager getInstance(Context context){
        if (instance!=null) return instance;
        else return new FileManager(context);
    }
    private void copyStreamToStream(InputStream is, OutputStream os)throws IOException{
        int c;
        byte buffer[] = new byte[1024];
        while(true){
            c = is.read(buffer);
            if (c == -1)
                break;
            os.write(buffer, 0, c);
        }
        os.flush();
        os.close();
        is.close();
    }

    public void addMaterialForCourse(StudyMaterial studyMaterial, Course course, boolean writeToSDCard)
            throws IOException, WriteToSDCardException{
        String dirPath;
        if (writeToSDCard){
            if (!Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED) ||
                    Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED_READ_ONLY)){
                throw new WriteToSDCardException("Media not mounted or ReadOnly.");
            }
            dirPath = Environment.getExternalStorageDirectory().getPath()+
                    "/"+context.getString(R.string.app_name)+
                    "/"+course.getName();
        }
        else{
            dirPath = context.getExternalFilesDir(null).getPath()+
                    "/"+context.getString(R.string.app_name)+
                    "/"+course.getName();
        }
        Log.d("PATH", dirPath);
        File dirFile = new File(dirPath);
        dirFile.mkdirs();
        File toWrite = new File(dirPath, studyMaterial.getMaterial().getName());
        if(toWrite.exists()){
            toWrite.delete();

        }
        toWrite.createNewFile();

        InputStream is = new FileInputStream(studyMaterial.getMaterial());
        OutputStream os = new FileOutputStream(toWrite);
        copyStreamToStream(is, os);

        MediaScannerConnection.scanFile(context, new String[]{toWrite.getPath()}, null, null);
    }
}
