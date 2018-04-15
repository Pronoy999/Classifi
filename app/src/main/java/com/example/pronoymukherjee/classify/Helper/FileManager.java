package com.example.pronoymukherjee.classify.Helper;

import android.content.Context;
import android.content.Intent;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Environment;
import android.util.Log;

import com.example.pronoymukherjee.classify.Objects.Course;
import com.example.pronoymukherjee.classify.Objects.StudyMaterial;
import com.example.pronoymukherjee.classify.R;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;
import java.time.Instant;

import com.example.pronoymukherjee.classify.Exceptions.WriteToSDCardException;

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

    /**
     * Returns the path of the directory where the file is to be made.
     * @param inExtStorage whether the returned path should be in external storage or not.
     * @param course the course for which the path is made.
     * @return the String containing the path.
     * @throws WriteToSDCardException if 'inExtStorage' is true and no media exists.
     */
    private String getPath(boolean inExtStorage, Course course)throws WriteToSDCardException{
        String dirPath;
        if (inExtStorage){
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
        return dirPath;
    }

    /**
     * Copies the bytes from one stream to another.
     * @param is the input stream.
     * @param os the output stream.
     * @throws IOException
     */
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

    public void addMaterialForCourse(StudyMaterial studyMaterial, Course course, boolean writeToExtStorage)
            throws IOException, WriteToSDCardException{
        String dirPath = getPath(writeToExtStorage, course)+"/"+studyMaterial.getDate().toString();
        Log.d("PATH", dirPath);
        File dirFile = new File(dirPath);
        dirFile.mkdirs();

        File toWrite;
        toWrite = new File(dirPath, studyMaterial.getName()+
                        studyMaterial.getType());
        if(toWrite.exists()){
            toWrite.delete();
        }
        Log.d("CREATE", toWrite.createNewFile()+"");
        Uri material = studyMaterial.getMaterial();
        InputStream is = new FileInputStream(new File(URI.create(material.toString())));
        OutputStream os = new FileOutputStream(toWrite);
        copyStreamToStream(is, os);

        MediaScannerConnection.scanFile(context, new String[]{toWrite.getPath()}, null, null);
    }
}
