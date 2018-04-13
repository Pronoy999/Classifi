package com.example.pronoymukherjee.classify.Objects;

import android.content.Intent;
import android.graphics.Bitmap;
import android.media.Image;
import android.net.Uri;

import java.io.File;
import java.util.Date;

/**
 * A class representing a Study material for the student.
 * Created by deban on 12-04-2018.
 */

public class StudyMaterial {
    private Uri material;
    private Date date;
    private String type;
    private String name;

    public static final String TYPE_IMAGE = ".png";
    public static final String TYPE_TEXT = ".doc";

    public StudyMaterial(Uri material, Date date, String name, String type){
        this.material = material;
        this.type = type;
        this.name = name;
        this.date = date;
    }
    public Uri getMaterial() {
        return material;
    }
    public Date getDate(){
        return date;
    }
    public String getType(){ return type;}
    public String getName() {return name;}
}