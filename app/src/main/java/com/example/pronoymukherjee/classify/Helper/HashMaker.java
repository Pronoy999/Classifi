package com.example.pronoymukherjee.classify.Helper;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * A class to manage making password hashes.
 */
public class HashMaker {
    /**
     * Initializes the Hashing Algorithm.
     * Appropriate string containing the name of the algorithm to be applied is passed (e.g: "SHA-256").
     *
     * Returns: the hash of the message string in a modified way
     * (a sequence of positive integers up to 255 separated by a dot '.')
     * */
    public static String getHash(String message){
        StringBuilder hash=new StringBuilder();
        MessageDigest mDigest;
        try {
            mDigest = MessageDigest.getInstance("SHA-256");
            mDigest.update(message.getBytes(StandardCharsets.UTF_8));
            byte[] byteHash = mDigest.digest();
            for(byte i : byteHash) {
                hash.append((i + 128)).append(".");
            }
        } catch (NoSuchAlgorithmException|NullPointerException e) {
            Message.logMessages(HashMaker.class.getSimpleName(),e.toString());
        }
        return hash.toString();
    }
}
