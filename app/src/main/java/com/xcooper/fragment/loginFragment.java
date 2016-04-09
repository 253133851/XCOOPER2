package com.xcooper.fragment;

import android.app.FragmentTransaction;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;
import com.xcooper.Bean.BEAN_INSTANSE;
import com.xcooper.Code;
import com.xcooper.Common.data.PostDataStringRequest;
import com.xcooper.Common.util.MD5;
import com.xcooper.Common.util.StrUtil;
import com.xcooper.Constant;
import com.xcooper.ENV;
import com.xcooper.Method_Center;
import com.xcooper.R;

import net.sf.json.JSONException;
import net.sf.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class loginFragment extends MyFragment {

    public static loginFragment Fragment;

    public void Pre() {
        if (Fragment == null) Fragment = Fragment_Center.getLoginFragment();
        setLAYOUT(R.layout.login);
    }

    RelativeLayout rl_others;
    Button bt_login;
    EditText et_login_id, et_login_password;
    SharedPreferences sp;
    SharedPreferences.Editor editor;

    public void Init_View(View view) {
        rl_others = (RelativeLayout) view.findViewById(R.id.rl_login_other);
        bt_login = (Button) view.findViewById(R.id.bt_login);
        et_login_id = (EditText) view.findViewById(R.id.et_login_id);
        et_login_password = (EditText) view.findViewById(R.id.et_login_password);
    }

    public void Init_Data() {
        sp = Constant.context.getSharedPreferences("userInfo", 0);
    }

    public void Init_Listener() {
        rl_others.setOnClickListener(this);
        bt_login.setOnClickListener(this);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.rl_login_other:
                Method_Center.hideSoftInput();
                break;
            case R.id.bt_login:
                Login();
                break;
        }
    }

    /**
     * 登录成功
     */
    public void Login() {

        Method_Center.show_Toast("正在登录...", true);

        long time = System.currentTimeMillis();
        final String userNameValue = et_login_id.getText().toString();
        final String passwordValue = et_login_password.getText().toString();

        editor = sp.edit();
        editor.clear();
        editor.commit();

        //BEAN_INSTANSE.userBean.DeleteAll();  //删除之前的保证只有唯一的一个配送员

        Map<String, String> map = new HashMap<String, String>();
        map.put("id", userNameValue);//账号
        map.put("time", time + "");//此时的Long型时间
        map.put("pwd", StrUtil.getMD5Password(MD5.MD5Encode(passwordValue), time));//MD5算法之后的密码
        PostDataStringRequest post = new PostDataStringRequest(ENV.URL_CHECK_PASSWORD,
                map,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String s) {
//                        try {
//                            JSONObject json = JSONObject.fromObject(s);
//
//                            int code = json.getInt("code");
//                            if (code == Code.OK) {
//
//                                net.sf.json.JSONObject user_info = net.sf.json.JSONObject.fromObject(json.getString("data"));
//
//                                //将用户数据存入数据库
//                                UserVO user = new UserVO();
//                                user.setTele(userNameValue);
//                                user.setLevel(user_info.getInt("LEVEL"));
//                                user.setPwd(MD5.MD5Encode(passwordValue));
//
//                                BEAN_INSTANSE.userBean.add(user);
//
//                                //保存用户名和密码
//                                editor.putString("USER_NAME", userNameValue);
//                                editor.putString("PASSWORD", passwordValue);
//
//                                //跳转到主页
//                                Constant.Reccent_Frag = Fragment_Center.mainFragment_num;
//                                mainFragment.Fragment = Fragment_Center.getMainFragment();
//                                if (!mainFragment.Fragment.isAdded()) {
//                                    getFragmentManager().popBackStack();
//                                    FragmentTransaction ft = getFragmentManager().beginTransaction();
//                                    ft.add(R.id.fl_main, mainFragment.Fragment);
//                                    ft.commit();
//                                }
//                            } else if (code == Code.LOGIN_ERROR) {
//                                Method_Center.show_Toast(json.getString("msg"), true);
//                            }
//                        } catch (JSONException e) {
//
//                        }

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError volleyError) {
                        Log.e("TAG", volleyError.getMessage(), volleyError);
                    }
                });
        if (BEAN_INSTANSE.requestQueue == null) {
            BEAN_INSTANSE.requestQueue = Volley.newRequestQueue(Constant.context);
        }
        BEAN_INSTANSE.requestQueue.add(post);

    }
}
