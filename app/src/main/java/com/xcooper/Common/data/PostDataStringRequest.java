package com.xcooper.Common.data;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.toolbox.StringRequest;

import java.util.Map;

public class PostDataStringRequest extends StringRequest {

    private Map<String, String> mMap;

    public PostDataStringRequest(String url, Map<String, String> map, Listener<String> listener, ErrorListener errorListener){
        super(Request.Method.POST, url,listener, errorListener);
        mMap = map;
    }

    public PostDataStringRequest(int method, String url, Map<String, String> map, Listener<String> listener, ErrorListener errorListener){
        super(method, url,listener, errorListener);
        mMap = map;
    }

    protected Map<String, String> getParams() throws AuthFailureError {
        return mMap;
    }

}
