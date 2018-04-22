package com.example.pronoymukherjee.classify.Helper;

import android.content.Context;

import com.example.pronoymukherjee.classify.Objects.Course;
import com.example.pronoymukherjee.classify.Objects.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/**
 * To register students (get BSSID)
 * Created by Debanik on 15-04-2018.
 */

public class Registrant extends TimerTask{
    private static final int TIMEOUT_LIMIT = 20;
    private int timeOut = 0, position = 0;

    private Context context;

    private Timer timer;
    private Course course;
    private static Registrant currentInstance; //only instance of the singleton
    private List<Student> students; //all students
    private List<Student> registered; //students registered
    private List<Student> notRegistered; //students not registered
    private WifiController controller;
    private RegisterEventListener listener; // event listener instance.
    /**
     * Private constructor. Singleton.
     * @param course The course for which the registration is to be done.
     * @param context The context of the application.
     */
    private Registrant(Course course, Context context, RegisterEventListener listener){
        //singleton class. private constructor.
        this.course = course;
        this.context = context.getApplicationContext();
        this.students = course.getStudents();
        this.timer = new Timer(false);
        this.controller = WifiController.getController(context);
        this.listener = listener;
        this.registered = this.notRegistered = new ArrayList<>();
        currentInstance = this;
    }

    /**
     * Returns current instance of this singleton.
     * This is used to invoke other methods.
     * @param course The course for which the attendance is to be taken.
     * @param context The context of the application.
     * @return The object of this Singleton.
     */

    public static synchronized Registrant getCurrentInstance(Course course, Context context,
                                                             RegisterEventListener listener){ //to get the only instance.
        if(currentInstance!=null && currentInstance.course.getCode().equals(course.getCode())){
            return currentInstance;
        }
        return new Registrant(course, context, listener);
    }

    /**
     * Destroys and un-initializes all data members.
     */
    private void cleanup(){
        timeOut = 0;
        position = 0;
        currentInstance = null;
        registered.clear();
        notRegistered.clear();
        students.clear();
        course = null;
        context = null;
        controller = null;
    }
    /**
     * The timer thread's run method. This is scheduled at regular intervals.
     */
    public void run(){
        if(currentInstance == null) return;
        if(timer == null) return;

        if(position>=students.size()) { //if all students have been called.
            timer.cancel();
            listener.onRegistrationDone(registered, notRegistered); // calling callback method for event.
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
            notRegistered.add(currentStudent);
            listener.onOneStudentRegistered(currentStudent, null, false);
            return;
        }

        if(controller.getConnectionStatus()){  //if connection established...

            listener.onOneStudentRegistered(currentStudent, controller.getBSSID(), true);
            registered.add(currentStudent);    //student registered

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
    public void cancelRegistration(){ //to cancel the operation of taking attendance.
        if(timer == null) return;
        if(currentInstance==null) return;

        timer.cancel();

        listener.onRegistrationCancelled();
        cleanup();
    }


    /**
     * This method is invoked to register students for the Course with which the
     * object was constructed.
     */

    public synchronized void startRegistration(){
        // to take attendance of students enrolled in course.
        if(this.timer == null) return;

        timer.scheduleAtFixedRate(this, 0, 1000);
    }
}
