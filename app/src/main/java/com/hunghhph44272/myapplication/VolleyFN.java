package com.hunghhph44272.myapplication;

import android.content.Context;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

public class VolleyFN {
    String strJSON ="";
    public  void getAllDataFromAPI(Context context, TextView view){
        RequestQueue queue = Volley.newRequestQueue(context);
        String url = "https://hungnttg.github.io/array_json_new.json";
        JsonArrayRequest request=new JsonArrayRequest(url, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                //doc cac doi tuong con cua mang
                for(int i=0;i<response.length();i++)
                {
                    try {
                        JSONObject person=response.getJSONObject(i);
                        String id=person.getString("id");
                        String name=person.getString("name");
                        String email=person.getString("email");
                        strJSON +="Id: "+id+"\n";
                        strJSON +="name: "+name+"\n";
                        strJSON +="email: "+email+"\n";
                    }catch (Exception e)
                    {
                        e.printStackTrace();
                    }
                }
                view.setText(strJSON);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                view.setText(error.getMessage());
            }
        });
        queue.add(request);//thuc thi request
    }
}
