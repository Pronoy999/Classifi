package com.example.pronoymukherjee.classify.Helper;

import android.content.ContentValues;
import android.content.Context;
import android.os.Environment;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Created by pronoymukherjee on 21/04/18.
 * This is the method to handle the File Related details.
 */

public class FileController {
    Context context;
    private String CLASS_TAG = FileController.class.getSimpleName();

    public FileController(Context context) {
        this.context = context;
    }

    /**
     * This is the method which is called from the signup Activity.
     * This just adds the user email and Password hash to a file locally.
     *
     * @param email:        The email of the User.
     * @param passwordHash: The Passwordhash of the user.
     */
    public void addUser(String email, String passwordHash) {
        try {
            File fileDir = new File(Environment.getExternalStorageDirectory() + File.separator +
                    Constants.ROOT_DIRECTORY_NAME + File.separator + Constants.USER_DIRECTORY);
            if (!fileDir.exists()) {
                fileDir.mkdirs();
            }
            File file = new File(fileDir, Constants.USER_FILE_NAME);
            FileOutputStream fileOutputStream = new FileOutputStream(file, true);
            PrintWriter printWriter = new PrintWriter(fileOutputStream);
            printWriter.println(Constants.EMAIL_ID_DATABASE + ":" + email);
            printWriter.println(Constants.PASSWORD_HASH + ":" + passwordHash);
        } catch (FileNotFoundException e) {
            Message.logMessages(CLASS_TAG, e.toString());
            Message.toastMessage(context, Constants.GENERIC_ERROR_MESSAGE, "");
        }
    }

    /**
     * This is the method to call after taking all the details of the user.
     *
     * @param phoneNumber: The phone number of the user.
     * @param name:        The name of the user.
     * @param dob:         The date of birth of the user.
     * @param dept:        The dept of the user.
     * @param gender:      The gender of the user.
     * @param account:     'T' if teacher, else 'S' for Student.
     * @param college:     The name of the college.
     */
    public void addBasicDetails(String phoneNumber, String name, String dob, String dept, String gender, String account, String college) {
        try {
            File fileDir = new File(Environment.getExternalStorageDirectory() + File.separator +
                    Constants.ROOT_DIRECTORY_NAME + File.separator + Constants.USER_DIRECTORY);
            if (!fileDir.exists()) {
                fileDir.mkdirs();
            }
            File file = new File(fileDir, Constants.USER_FILE_NAME);
            FileOutputStream fileOutputStream = new FileOutputStream(file, true);
            PrintWriter printWriter = new PrintWriter(fileOutputStream);
            printWriter.println(Constants.PHONE_NUMBER + ":" + phoneNumber);
            printWriter.println(Constants.NAME_DATABASE + ":" + name);
            printWriter.println(Constants.DOB_DATABASE + ":" + dob);
            printWriter.println(Constants.COLLEGE_NAME + ":" + college);
            printWriter.println(Constants.DEPARTMENT_DATABASE + ":" + dept);
            printWriter.println(Constants.GENDER_DATABASE + ":" + gender);
            printWriter.println(Constants.ACCOUNT + ":" + account);
        } catch (FileNotFoundException e) {
            Message.logMessages(CLASS_TAG, e.toString());
            Message.toastMessage(context, Constants.GENERIC_ERROR_MESSAGE, "");
        }
    }

    /**
     * This is the method to get the details from the file.
     *
     * @return ContentValues: With the Details and the data of the user mapped.
     */
    public ContentValues getUserDetials() {
        ContentValues values = new ContentValues();
        try {
            File dir = new File(Environment.getExternalStorageDirectory() + File.separator +
                    Constants.ROOT_DIRECTORY_NAME + File.separator + Constants.USER_DIRECTORY, Constants.USER_FILE_NAME);
            BufferedReader reader = new BufferedReader(new FileReader(dir));
            String line = reader.readLine();
            Scanner scanner;
            while (!line.equals("")) {
                scanner = new Scanner(line);
                scanner.useDelimiter(":");
                values.put(scanner.next(), scanner.next());
                line = reader.readLine();
            }
        } catch (IOException e) {
            Message.logMessages(CLASS_TAG, e.toString());
            Message.toastMessage(context, Constants.GENERIC_ERROR_MESSAGE, "");
        }
        return values;
    }
}
