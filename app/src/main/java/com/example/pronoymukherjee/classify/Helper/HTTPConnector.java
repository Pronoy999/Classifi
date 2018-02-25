package com.example.pronoymukherjee.classify.Helper;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONObject;

/**
 * This is the class to make a Volley Request.
 */

public class HTTPConnector {
    public String TAG=HTTPConnector.class.getCanonicalName();
    public String queryUrl;
    public JSONObject response;
    private Context context;
    public ResponseListener responseListener;

    /**
     * Constructor for the HTTPConnector.
     * @param context: The context.
     * @param queryUrl: The URL where the request to be send.
     * @param responseListener: The Response Listener.
     */
    public HTTPConnector(Context context,String queryUrl,ResponseListener responseListener){
        this.context=context;
        this.queryUrl=queryUrl;
        this.responseListener=responseListener;
    }
    public interface ResponseListener{
        void onResponse(JSONObject response);
    }

    /**
     * This is the method to make query with the volley.
     * @param postData: This is data to be send as the POST Data.
     */
    public void makeQuery(JSONObject postData){
        JsonObjectRequest request=new JsonObjectRequest(Request.Method.POST, queryUrl, postData, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                if(responseListener!=null){
                    onResponse(response);
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Message.logMessages(TAG, error.toString());
            }
        });
        SingleTon.getInstance(context.getApplicationContext()).addToRequestQueue(request);
    }

    /**
     * This is the method to make Query with the volley.
     */
    public void makeQuery(){
        JsonObjectRequest request=new JsonObjectRequest(Request.Method.GET, queryUrl, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                if(responseListener!=null){
                    onResponse(response);
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Message.logMessages(TAG, error.toString());
            }
        });
        SingleTon.getInstance(context.getApplicationContext()).addToRequestQueue(request);
    }
}
