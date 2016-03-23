package com.example.mukesh_kumar.realm.Utils;

import android.content.Context;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;


import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Created by mukesh_kumar on 29/10/15.
 */
public class VolleyFunction {

    public static JSONObject getJSONObjectByGetMethod(final Context context,String URL){
        final JSONObject[] response1 = new JSONObject[1];
        JsonObjectRequest request= new JsonObjectRequest(Request.Method.GET,URL,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                         response1[0] =response;
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(context,"Some Error occurred ",Toast.LENGTH_SHORT).show();
            }
        });
        AppController.getInstance().addToRequestQueue(request);
        return response1[0];
    }
    public static JSONArray getJSONArrayByGetMethod(final  Context context,String Url){
        final JSONArray[] jsonArray = new JSONArray[1];
        final JsonArrayRequest request= new JsonArrayRequest(Request.Method.GET,Url,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        jsonArray[0] =response;
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(context,"Some Error occurred ",Toast.LENGTH_SHORT).show();
            }
        });
            AppController.getInstance().addToRequestQueue(request);
        return jsonArray[0];
    }

    public static  JSONObject getJSONObjectByPostMethod(final Context context,String Url,
                                                        JSONObject params){

        final JSONObject[] response1 = new JSONObject[1];
        JsonObjectRequest request= new JsonObjectRequest(Url,params,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        response1[0] =response;
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(context,"Some Error occurred ",Toast.LENGTH_SHORT).show();
            }
        });
        AppController.getInstance().addToRequestQueue(request);
        return response1[0];
    }

    public  static  JSONArray getJSONArrayByPostMethod(final Context context,String Url,
                                                       JSONObject params){
        final JSONArray[] jsonArray = new JSONArray[1];
        final JsonArrayRequest request= new JsonArrayRequest(Url,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        jsonArray[0] =response;
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(context,"Some Error occurred ",Toast.LENGTH_SHORT).show();
            }
        });
        AppController.getInstance().addToRequestQueue(request);
        return jsonArray[0];
    }

}
