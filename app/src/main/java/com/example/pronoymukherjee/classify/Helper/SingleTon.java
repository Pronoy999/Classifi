package com.example.pronoymukherjee.classify.Helper;

import android.content.Context;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by pronoymukherjee on 25/02/18.
 * This is the class to initialize the Volley Request queue once.
 */

public class SingleTon {
    private Context context;
    private static SingleTon singleTon;
    private RequestQueue requestQueue;
    private SingleTon(Context context){
        this.context=context;
        requestQueue=getRequestQueue();
    }

    /**
     * This is method to get the instance of the request queue if exists else create a new one.
     * @return: The instance of the Request queue.
     */
    private RequestQueue getRequestQueue(){
        if(requestQueue==null){
            requestQueue= Volley.newRequestQueue(context);
        }
        return requestQueue;
    }

    /**
     * A Synchronized approach is taken to invoke the Volley Request queue.
     * @param context : The Application Context from where the request is made.
     * @return: The object of the SingleTon Class if exists else create a new one.
     */
    public static synchronized SingleTon getInstance(Context context){
        if(singleTon==null){
            singleTon=new SingleTon(context.getApplicationContext());
        }
        return singleTon;
    }

    /**
     * This is the method to add the new request to the existing Request queue.
     * @param request: Generic Request type to be added to the queue.
     */
    public void addToRequestQueue(Request request){
        requestQueue.add(request).setRetryPolicy(new DefaultRetryPolicy());
    }
}
