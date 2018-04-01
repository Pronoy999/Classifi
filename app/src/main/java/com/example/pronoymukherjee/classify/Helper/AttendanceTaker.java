package com.example.pronoymukherjee.classify.Helper;

import android.content.Context;

import com.example.pronoymukherjee.classify.Objects.Attendance;
import com.example.pronoymukherjee.classify.Objects.Course;
import com.example.pronoymukherjee.classify.Objects.Student;

import java.util.Collections;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;


/**
 * Singleton class. To take attendance.
 * Created by Debanik on 01-04-2018.
 */


public class AttendanceTaker extends TimerTask{
    private static int TIMEOUT_LIMIT = 20;
    private Context context;

    private Timer timer;
    private Course course;
    private AttendanceTaker currentInstance; //only instance of the singleton
    private List<Student> students; //all students
    private List<Student> present; //students present
    private List<Student> absent; //students absent

    /**
     * Private constructor. Singleton.
     * @param course The course for which the attendance is to be taken.
     * @param context The context of the application.
     */
    private AttendanceTaker(Course course, Context context){ //singleton class. private constructor.
        this.course = course;
        this.context = context;
        this.students = course.getStudents();
        this.timer = new Timer(false);

        this.present = this.absent = Collections.emptyList();
        currentInstance = this;
    }

    /**
     * Returns current instance of this singleton.
     * This is used to invoke other methods.
     * @param course The course for which the attendance is to be taken.
     * @param context The context of the application.
     * @return The object of this Singleton.
     */
    public AttendanceTaker getCurrentInstance(Course course, Context context){ //to get the only instance.
        if(currentInstance!=null && currentInstance.course.getCode().equals(course.getCode())){
            return currentInstance;
        }
        return new AttendanceTaker(course, context);
    }

    /**
     * This method takes a student and tries to establish connection
     * with his/her AP using the credentials.
     * @param student The student whose attendance is to be taken.
     * @return true means connection established AND BSSID mathces, false otherwise.
     */
    private boolean callStudent(Student student){
        //checks the presence of student and
        // returns accordingly.

        WifiController controller = WifiController.getController(context); //singleton object

        if(controller.establishConnection(student.getSSID(), student.getPSK())){
            if(controller.getBSSID().equals(student.getBSSID()))
                return true;
        }
        return false;
    }

    /**
     * The timer thread's run method. This is scheduled at regular intervals.
     */
    public void run(){
        if(currentInstance == null) return;
        if(timer == null) return;

        for(Student student: students){
            if(callStudent(student))
                present.add(student);
            else
                absent.add(student);
        }
    }

    /**
     * Cancels the entire operation of taking attendance.
     * Stops the thread, clears lists.
     */
    public void cancelAttendance(){ //to cancel the operation of taking attendance.
        if(timer == null) return;

        timer.cancel();
        present.clear();
        absent.clear();

        currentInstance = null;
    }

    public void commitUpdates(){
        for(Student student: present)
            student.markPresent(course);
        for(Student student: absent)
            student.markAbsent(course);

        currentInstance = null;
    }

    public synchronized void takeAttendance(){
        // to take attendance of students enrolled in course.
        if(this.timer == null) return;

        timer.scheduleAtFixedRate(this, 0, 20);
    }
}
