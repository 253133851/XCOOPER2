package com.xcooper;

import android.os.AsyncTask;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;
import com.xcooper.Bean.BEAN_INSTANSE;
import com.xcooper.Common.data.PostDataStringRequest;

import net.sf.json.JSONObject;

import java.util.Map;


public class MyAsynctask extends AsyncTask<Void, Void, String> implements OK, Response.Listener<String>, Response.ErrorListener {

    Map<String, String> map;
    String URL;

    public MyAsynctask(Map<String, String> map, String URL) {
        this.map = map;
        this.URL = URL;
    }

    @Override
    protected String doInBackground(Void... params) {
        PostDataStringRequest stringRequest = new PostDataStringRequest(URL, map,
                this, this);
        if (BEAN_INSTANSE.requestQueue == null) {
            BEAN_INSTANSE.requestQueue = Volley.newRequestQueue(Constant.context);
        }
        BEAN_INSTANSE.requestQueue.add(stringRequest);
        return null;
    }

    @Override
    public void onResponse(String s) {
        JSONObject json = JSONObject.fromObject(s);
        int code = json.getInt("code");
        switch (code) {
            case Code.OK:
                OK(json);
                break;
        }

    }

    @Override
    public void onErrorResponse(VolleyError volleyError) {
    }

    @Override
    public void OK(JSONObject code) {
    }
}


interface OK {
    void OK(JSONObject code);
}
