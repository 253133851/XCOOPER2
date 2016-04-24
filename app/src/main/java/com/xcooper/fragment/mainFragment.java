package com.xcooper.fragment;

import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.ScaleAnimation;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.gc.materialdesign.views.ButtonFloat;
import com.xcooper.Bean.BEAN_INSTANSE;
import com.xcooper.Common.util.DateUtil;
import com.xcooper.Constant;
import com.xcooper.ENV;
import com.xcooper.Method_Center;
import com.xcooper.MyAsynctask;
import com.xcooper.R;
import com.xcooper.activity.mainActivity;
import com.xcooper.adapter.MyViewPagerAdapter;
import com.xcooper.adapter.TaskWfzdAdapter;
import com.xcooper.view.RevealLayout;
import com.xcooper.vo.TaskVO;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 主页
 */
public class mainFragment extends MyFragment {

    public static mainFragment Fragment;

    @Override
    public void Pre() {
        super.Pre();
        if (Fragment == null) Fragment = Fragment_Center.getMainFragment();
        setLAYOUT(R.layout.activity_main);
    }

    private TabLayout mTabLayout;
    private ViewPager mViewPager;

    private LayoutInflater mInflater;
    private List<String> mTitleList = new ArrayList<>();//页卡标题集合
    private View view1, view2, view3;//页卡视图
    private List<View> mViewList = new ArrayList<>();//页卡视图集合
    SimpleAdapter adapter;
    public static ListView lv_wfzd_yh, lv_wfzd_jt, lv_wfqd, lv_wgzd;
    public static TaskWfzdAdapter taskWfzdAdapter_jt, taskWfzdAdapter_yh, taskWfqdAdapter, taskWgzdAdapter;

    @Override
    public void Init_View(View view) {

        mViewPager = (ViewPager) view.findViewById(R.id.vp_view);
        mTabLayout = (TabLayout) view.findViewById(R.id.tabs);

        mInflater = LayoutInflater.from(Constant.context);
        view1 = mInflater.inflate(R.layout.wofuzede, null);
        view2 = mInflater.inflate(R.layout.wofaqide, null);
        view3 = mInflater.inflate(R.layout.woguanzude, null);

        lv_wfzd_yh = (ListView) view1.findViewById(R.id.lv_wfzd_yh);
        lv_wfzd_jt = (ListView) view1.findViewById(R.id.lv_wfzd_jt);
        lv_wfqd = (ListView) view2.findViewById(R.id.lv_wfqd);
        lv_wgzd = (ListView) view3.findViewById(R.id.lv_wgzd);

        mainActivity.setFloatButtons(3, new int[]{
                R.drawable.open,
                R.drawable.shuaxin,
                R.drawable.baoxiu,
        }, new String[]{
                "返回", "新建任务", "番茄钟"
        });
    }

    @Override
    public void Init_Data() {

        setTitle("任务");
        mainActivity.mDrawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED);

        mViewList = new ArrayList<>();//页卡视图集合
        mTitleList = new ArrayList<>();//页卡视图集合

        //添加页卡视图
        mViewList.add(view1);
        mViewList.add(view2);
        mViewList.add(view3);

        //添加页卡标题
        mTitleList.add("我负责的");
        mTitleList.add("我发起的");
        mTitleList.add("我关注的");

        mTabLayout.setTabMode(TabLayout.MODE_FIXED);//设置tab模式，当前为系统默认模式
        mTabLayout.addTab(mTabLayout.newTab().setText(mTitleList.get(0)));//添加tab选项卡
        mTabLayout.addTab(mTabLayout.newTab().setText(mTitleList.get(1)));
        mTabLayout.addTab(mTabLayout.newTab().setText(mTitleList.get(2)));

        MyViewPagerAdapter mAdapter = new MyViewPagerAdapter(mViewList, mTitleList);
        mViewPager.setAdapter(mAdapter);//给ViewPager设置适配器
        mTabLayout.setupWithViewPager(mViewPager);//将TabLayout和ViewPager关联起来。
        mTabLayout.setTabsFromPagerAdapter(mAdapter);//给Tabs设置适配器

        BEAN_INSTANSE.loadTaskIndexData();

    }

    public static void setLvData() {

        List<Map<String, String>> taskWfzdList_jt = new ArrayList<>();
        List<Map<String, String>> taskWfzdList_yh = new ArrayList<>();
        List<Map<String, String>> taskWfqdList = new ArrayList<>();
        List<Map<String, String>> taskWgzdList = new ArrayList<>();

        List<TaskVO> taskWfzdVos = BEAN_INSTANSE.taskBean.query(TaskVO.task_wfzd);
        List<TaskVO> taskWfqdVos = BEAN_INSTANSE.taskBean.query(TaskVO.task_wfqd);
        List<TaskVO> taskWgzdVos = BEAN_INSTANSE.taskBean.query(TaskVO.task_wgzd);

        for (int i = 0; i < taskWfzdVos.size(); i++) {
            Map<String, String> map = new HashMap<>();
            if (null != taskWfzdVos.get(i).getEnd_DATETIME() &&
                    !("").equals(taskWfzdVos.get(i).getEnd_DATETIME()) &&
                    taskWfzdVos.get(i).getEnd_DATETIME().length() > 10)
                if (taskWfzdVos.get(i).getEnd_DATETIME().substring(0, 10).equals(DateUtil.getCurrentDay("yyyy-MM-dd"))) {
                    map.put("date", "今天");
                    map.put("name", taskWfzdVos.get(i).getTask_NAME());
                    map.put("xiangmu", taskWfzdVos.get(i).getProject_ID() + "");
                    taskWfzdList_jt.add(map);
                } else {
                    map.put("date", taskWfzdVos.get(i).getEnd_DATETIME());
                    map.put("name", taskWfzdVos.get(i).getTask_NAME());
                    map.put("xiangmu", taskWfzdVos.get(i).getProject_ID() + "");
                    taskWfzdList_yh.add(map);
                }
        }

        for (int i = 0; i < taskWfqdVos.size(); i++) {
            Map<String, String> map = new HashMap<>();
            map.put("date", taskWfqdVos.get(i).getEnd_DATETIME());
            map.put("name", taskWfqdVos.get(i).getTask_NAME());
            map.put("xiangmu", taskWfqdVos.get(i).getProject_ID() + "");
            taskWfqdList.add(map);
        }

        for (int i = 0; i < taskWgzdVos.size(); i++) {
            Map<String, String> map = new HashMap<>();
            map.put("date", taskWgzdVos.get(i).getEnd_DATETIME());
            map.put("name", taskWgzdVos.get(i).getTask_NAME());
            map.put("xiangmu", taskWgzdVos.get(i).getProject_ID() + "");
            taskWgzdList.add(map);
        }
        taskWfzdAdapter_jt = new TaskWfzdAdapter(taskWfzdList_jt, Constant.context);
        lv_wfzd_jt.setAdapter(taskWfzdAdapter_jt);
        taskWfzdAdapter_yh = new TaskWfzdAdapter(taskWfzdList_yh, Constant.context);
        lv_wfzd_yh.setAdapter(taskWfzdAdapter_yh);
        taskWfqdAdapter = new TaskWfzdAdapter(taskWfqdList, Constant.context);
        lv_wfqd.setAdapter(taskWfqdAdapter);
        taskWgzdAdapter = new TaskWfzdAdapter(taskWgzdList, Constant.context);
        lv_wgzd.setAdapter(taskWgzdAdapter);
    }

    @Override
    public void Init_Listener() {
        getFloatButtons(2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment_Center.loadRenwuXinjian(Fragment_Center.mainFragment_num);
            }
        });
        getFloatButtons(3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment_Center.loadfanqiezhongXiangqing(Fragment_Center.mainFragment_num);
            }
        });
        lv_wfzd_jt.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Fragment_Center.loadRenwuXiangqing();
            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case 0:

                break;
        }
    }

    public void load_Data() {
        Map<String, String> map = new HashMap<String, String>();
        map.put("time", "2016-01-06");
        map.put("confirm", "-1");
        map.put("done", "-1");
        new MyAsynctask(map, ENV.URL_ADD_TASK) {
            public void OK(JSONObject code) {

                JSONObject json = code.getJSONObject("data");
                JSONArray order_listArray = json.getJSONArray("order_list");
                adapter.notifyDataSetChanged();
            }
        }.execute();
    }
}
