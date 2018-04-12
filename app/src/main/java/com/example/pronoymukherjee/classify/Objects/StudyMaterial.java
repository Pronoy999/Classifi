package com.example.pronoymukherjee.classify.Objects;

import java.io.File;
import java.util.Date;

/**
 * A class representing a Study material for the student.
 * Created by deban on 12-04-2018.
 */

public class StudyMaterial {
    private File material;
    private Date date;

    public StudyMaterial(File material, Date date){
        this.material = material;
        this.date = date;
    }
    public File getMaterial() {
        return material;
    }
    public Date getDate(){
        return date;
    }
}
