package com.xcooper.Common.data;


import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONObject;

import java.util.Map;



public class PostDataJSONRequest extends JsonObjectRequest {

    private Map<String, String> mMap;

    public PostDataJSONRequest(String url, Map<String, String> map, Response.Listener<JSONObject> listener, Response.ErrorListener errorListener){
        super(Method.POST, url,null,listener, errorListener);
        mMap = map;
    }

    protected Map<String, String> getParams() throws AuthFailureError {
        return mMap;
    }

}
