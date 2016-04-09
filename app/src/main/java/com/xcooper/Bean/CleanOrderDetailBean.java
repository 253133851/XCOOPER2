//package com.xcooper.Bean;
//
//import android.content.Context;
//
//import com.huanhuan.huanhuan_clean.Common.data.DBHelper;
//import com.huanhuan.huanhuan_clean.vo.CleanOrderDetailVO;
//import com.j256.ormlite.dao.Dao;
//import com.j256.ormlite.stmt.QueryBuilder;
//
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.List;
//
//public class CleanOrderDetailBean {
//
//    private Dao<CleanOrderDetailVO, Integer> cleanOrderDetailVOs;
//    private DBHelper dbHelper;
//    Context context;
//
//    /**
//     * ���췽��
//     * �����ݿ������ʵ��ͨ����Class����õ���Ӧ��Dao
//     *
//     * @param context
//     */
//    public CleanOrderDetailBean(Context context) {
//        this.context = context;
//        try {
//            dbHelper = DBHelper.getInstance(context);
//            cleanOrderDetailVOs = dbHelper.getDao(CleanOrderDetailVO.class);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//    /**
//     * ���һ����¼
//     */
//    public void add(CleanOrderDetailVO cleanOrderDetailVO) {
//        try {
//            cleanOrderDetailVOs.create(cleanOrderDetailVO);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//    /**
//     * ��ݲ�ͬ������״̬��ȷ��
//     * @param date
//     * @param state
//     * @param confirm
//     * @return
//     */
//    public List<CleanOrderDetailVO> get_by_date_state_confirm(String date, int state, int confirm) {
//        List<CleanOrderDetailVO> list = new ArrayList<>();
//        try {
//            QueryBuilder qb = cleanOrderDetailVOs.queryBuilder();
//            qb.where().eq("GOHOME_DATE", date)
//                    .and().eq("STATE", state)
//                    .and().eq("HAS_CONFIRM", confirm);
//            list = qb.query();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return list;
//    }
//
//    /**
//     * ɾ�����м�¼
//     */
//    public void DeleteAll() {
//        try {
//            cleanOrderDetailVOs.updateRaw("delete from user where 1=1");
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//}
