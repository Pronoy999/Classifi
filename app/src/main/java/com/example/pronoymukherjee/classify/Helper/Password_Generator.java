package com.example.pronoymukherjee.classify.Helper;

/**
 * This is the class to generate the password for the wifi hotspot.
 */
public class Password_Generator {
    /**
     * This is the method which returns a random password generated using the name and the roll number.
     * Name: Dhon. Roll:14400115069. Password: 9605110044n.
     * @param name: The name of the Student.
     * @param roll: The university roll number of the student.
     * @return: The randomly generated password.
     */
    public static String generatePassword(String name,String roll) {
        String password = "";
        int i,Rlen=roll.length();
        for(i=Rlen-1;i>=1;i--)
            password+=roll.charAt(i);
        password+=name.charAt(name.length()-1);
        return password;
    }
}
