//package com.xcooper.fragment;
//
//import android.os.AsyncTask;
//import android.view.View;
//import android.widget.ImageView;
//import android.widget.LinearLayout;
//
//import com.gc.materialdesign.views.Card;
//
///**
// * ����ҳ��
// */
//public class orderInfoFragment extends MyFragment {
//
//    public static orderInfoFragment Fragment;
//
//    public void Pre() {
//        super.Pre();
//        if (Fragment == null) Fragment = Fragment_Center.getorderInfoFragment();
//        setLAYOUT(R.layout.order_info);
//    }
//
//    ImageView more, open_translate;
//
//    Card card_order_more;
//
//    LinearLayout test_anim;
//
//    RevealLayout ll_kaishishangmen;
//
//    DrawHookView dhv_ok;
//
//    public void Init_View(View view) {
//
//        more = (ImageView) view.findViewById(R.id.iv_more);
//        open_translate = (ImageView) view.findViewById(R.id.open_translate);
//        card_order_more = (Card) view.findViewById(R.id.card_order_more);
//        test_anim = (LinearLayout) view.findViewById(R.id.test_anim);
//        ll_kaishishangmen = (RevealLayout) view.findViewById(R.id.ll_kaishishangmen);
//        dhv_ok = (DrawHookView) view.findViewById(R.id.dhv_ok);
//    }
//
//    public void Init_Data() {
//
//    }
//
//    public void Init_Listener() {
//        more.setOnClickListener(this);
//        open_translate.setOnClickListener(this);
//        ll_kaishishangmen.setOnClickListener(this);
//    }
//
//    public void onClick(View view) {
//        switch (view.getId()) {
//            case R.id.iv_more:
//                click_more();
//                break;
//            case R.id.open_translate:
//                click_more();
//                break;
//            case R.id.ll_kaishishangmen:
//                order_state_change_ok_anim();
//                break;
//        }
//    }
//
//    public void order_state_change_ok_anim() {
//        DrawHookView.init_new(dhv_ok);
//        test_anim.setVisibility(View.VISIBLE);
//        ll_kaishishangmen.setVisibility(View.GONE);
//
//
//        new AsyncTask<Void, Void, Void>() {
//            @Override
//            protected Void doInBackground(Void... params) {
//                try {
//                    while (DrawHookView.if_paint) {
//                        Thread.sleep(200);
//                    }
//                    Thread.sleep(300);
//                    publishProgress();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                return null;
//            }
//
//            @Override
//            protected void onProgressUpdate(Void... values) {
//                super.onProgressUpdate(values);
//                test_anim.setVisibility(View.GONE);
//                ll_kaishishangmen.setVisibility(View.VISIBLE);
//            }
//        }.execute();
//
//    }
//
//    public void click_more() {
//        if (more.getTag().equals("close")) {
//            open_translate.setVisibility(View.VISIBLE);
//            card_order_more.setVisibility(View.VISIBLE);
//            more.setTag("open");
//        } else if (more.getTag().equals("open")) {
//            open_translate.setVisibility(View.GONE);
//            card_order_more.setVisibility(View.GONE);
//            more.setTag("close");
//        }
//    }
//
//}
