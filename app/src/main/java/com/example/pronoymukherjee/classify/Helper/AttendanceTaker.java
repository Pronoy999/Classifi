package com.example.pronoymukherjee.classify.Helper;

import android.app.ProgressDialog;
import android.content.Context;
import android.widget.ProgressBar;

import com.example.pronoymukherjee.classify.Objects.Course;
import com.example.pronoymukherjee.classify.Objects.Student;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;


/**
 * Singleton class. To take attendance.
 * Created by Debanik on 01-04-2018.
 */


public class AttendanceTaker extends TimerTask{
    private static final int TIMEOUT_LIMIT = 20;
    private int timeOut = 0, position = 0;

    private Context context;

    private Timer timer;
    private Course course;
    private static AttendanceTaker currentInstance; //only instance of the singleton
    private List<Student> students; //all students
    private List<Student> present; //students present
    private List<Student> absent; //students absent
    private WifiController controller;
    private ProgressBar progressBar;  //the bar showing the progress of this operation.

    /**
     * Private constructor. Singleton.
     * @param course The course for which the attendance is to be taken.
     * @param context The context of the application.
     */
    private AttendanceTaker(Course course, Context context, ProgressBar bar){
        //singleton class. private constructor.
        this.course = course;
        this.context = context;
        this.students = course.getStudents();
        this.timer = new Timer(false);
        this.controller = WifiController.getController(context);
        this.present = this.absent = new ArrayList<>();
        this.progressBar = bar;
        currentInstance = this;
    }

    /**
     * Returns current instance of this singleton.
     * This is used to invoke other methods.
     * @param course The course for which the attendance is to be taken.
     * @param context The context of the application.
     * @return The object of this Singleton.
     */
    public static AttendanceTaker getCurrentInstance(Course course, Context context, ProgressBar bar){
        //to get the only instance.
        if(currentInstance!=null && currentInstance.course.getCode().equals(course.getCode())){
            return currentInstance;
        }
        return new AttendanceTaker(course, context, bar);
    }

    /**
     * Destroys and un-initializes all data members.
     */
    private void cleanup(){
        timeOut = 0;
        position = 0;
        currentInstance = null;
        present.clear();
        absent.clear();
        students.clear();
        course = null;
        context = null;
        controller = null;
        progressBar.setEnabled(false);
    }
    /**
     * The timer thread's run method. This is scheduled at regular intervals.
     */
    public void run(){
        if(currentInstance == null) return;
        if(timer == null) return;

        if(position>=students.size()) { //if all students have been called.
            timer.cancel();
            cleanup();
            return;
        }

        Student currentStudent = students.get(position);  //get instance of current student to be called.

        if(timeOut == 0) {     //timeout = 0 means it's the 1st second of the calling process of that student.
            controller.establishConnection(           //establish connection with student.
                    currentStudent.getSSID(),
                    currentStudent.getPSK()
            );
        }

        if(timeOut>=TIMEOUT_LIMIT){ //if current connection times out
            timeOut = 0;           //start again
            position++;           //try next position
            absent.add(currentStudent);
            progressBar.incrementProgressBy(1);
            return;
        }

        if(controller.getConnectionStatus()){  //if connection established...
            if(controller.getBSSID().equals(currentStudent.getBSSID())) {   //...and BSSID matches
                present.add(currentStudent);    //student is present
            }else{
                absent.add(currentStudent);
            }

            progressBar.incrementProgressBy(1);
            controller.disbandConnection();   //disconnect and forget.
            timeOut = 0;
            position++;
        }

        timeOut++;
    }

    /**
     * Cancels the entire operation of taking attendance.
     * Stops the thread, clears lists.
     */
    public void cancelAttendance(){ //to cancel the operation of taking attendance.
        if(timer == null) return;
        if(currentInstance==null) return;

        timer.cancel();

        cleanup();
    }

    /**
     * Commits all changes. Writes the updated attendances for students.
     * Unless this method is called, all updates are local and temporary.
     */
    public void commitUpdates(){
        for(Student student: present)
            student.markPresent(course);
        for(Student student: absent)
            student.markAbsent(course);

        cleanup();
    }

    /**
     * This method is invoked to take attendance for the Course with which the
     * object was constructed.
     */

    public synchronized void takeAttendance(){
        // to take attendance of students enrolled in course.
        if(this.timer == null) return;

        timer.scheduleAtFixedRate(this, 0, 1000);
    }
}