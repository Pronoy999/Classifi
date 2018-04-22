package com.example.pronoymukherjee.classify.Helper;

import com.example.pronoymukherjee.classify.Objects.Student;

import java.util.List;

/**
 * Event listener for events related to registration.
 * Created by deban on 15-04-2018.
 */

public interface RegisterEventListener {
    public void onRegistrationDone(List<Student> registered, List<Student> notRegistered);
    public void onRegistrationCancelled();
    public void onOneStudentRegistered(Student student, String BSSID, boolean wasRegistered);
}
