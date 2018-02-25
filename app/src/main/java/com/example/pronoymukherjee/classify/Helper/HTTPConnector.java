package com.example.pronoymukherjee.classify.Helper;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.JsonRequest;

import org.json.JSONObject;

/**
 * Created by pronoymukherjee on 25/02/18.
 */

public class HTTPConnector {
    public String TAG=HTTPConnector.class.getCanonicalName();
    public String queryUrl;
    public JSONObject response;
    private Context context;
    public ResponseListener responseListener;
    public interface ResponseListener{
        void onResponse(JSONObject response);
    }
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
