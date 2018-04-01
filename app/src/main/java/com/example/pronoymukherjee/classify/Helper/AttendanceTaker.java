package com.example.pronoymukherjee.classify.Helper;

import android.content.Context;
import android.net.wifi.WifiManager;

import com.example.pronoymukherjee.classify.Objects.Course;
import com.example.pronoymukherjee.classify.Objects.Person;
import com.example.pronoymukherjee.classify.Objects.Student;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/**Singleton class. To take attendance.
 * Created by Debanik on 01-04-2018.
 */


public class AttendanceTaker extends TimerTask{
    private static int TIMEOUT_LIMIT = 20;
    private Context context;

    private Timer timer;
    private Course course;
    private AttendanceTaker currentInstance; //only instance of the singleton
    private List<Student> students;
    private List<Student> present;
    private List<Student> absent;

    private AttendanceTaker(Course course, Context context){ //singleton class. private constructor.
        this.course = course;
        this.context = context;
        this.students = course.getStudents();
        this.timer = new Timer(false);

        this.present = this.absent = Collections.emptyList();
        currentInstance = this;
    }


    public AttendanceTaker getCurrentInstance(Course course, Context context){ //to get the only instance.
        if(currentInstance!=null && currentInstance.course.getCode().equals(course.getCode())){
            return currentInstance;
        }
        return new AttendanceTaker(course, context);
    }
    private boolean callStudent(Student student){
        //checks the presence of student and
        // returns accordingly.
        WifiController controller = WifiController.getController(context);

        if(controller.establishConnection(student.getSSID(), student.getPSK())){
            if(controller.getBSSID().equals(student.getBSSID()))
                return true;
        }
        return false;
    }
    public void run(){
        if(currentInstance == null) return;
        if(timer == null) return;


    }
    public void cancelAttendance(){ //to cancel the operation of taking attendance.
        if(timer == null) return;

        timer.cancel();
    }

    public synchronized void takeAttendance(){
        // to take attendance of students enrolled in course.
        if(this.timer == null) return;

        timer.scheduleAtFixedRate(this, 0, 20);
    }
}
