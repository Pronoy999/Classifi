package com.example.pronoymukherjee.classify.Helper;

import com.example.pronoymukherjee.classify.Objects.Student;

import java.util.List;

/** Interface describing events during the operation of taking attendance.
 * Created by Debanik on 02-04-2018.
 */

public interface AttendanceEventListener {
    public void onAttendanceTaken(List<Student> present, List<Student> absent); // when the operation is completed.
    public void onAttendanceCancelled(); // when the operation is cancelled.
    public void onOneStudentMarked(Student student, boolean isPresent); // when one student is marked (absent or present)
}
