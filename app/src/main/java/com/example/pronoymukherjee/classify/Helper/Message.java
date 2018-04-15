package com.example.pronoymukherjee.classify.Helper;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

/**
 * A class for all toast and log messages.
 */

public class Message {
    /**
     * This is the method to display toast messages, passing null in the length will give a toast of short duration.
     *
     * @param context: Context for Toast message
     * @param msg:     The Toast message to be displayed.
     * @param length:  The duration of toast.
     */
    public static void toastMessage(Context context, String msg, String length) {
        if (length.equalsIgnoreCase("long"))
            Toast.makeText(context, msg, Toast.LENGTH_LONG).show();
        else
            Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
    }

    /**
     * This is the method to display debugging log with the appropriate tag and message.
     *
     * @param tag: TAG of LOG.
     * @param msg: Message of LOG.
     */
    public static void logMessages(String tag, String msg) {
        Log.d(tag, msg);
    }
}
