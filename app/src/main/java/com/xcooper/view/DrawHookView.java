package com.xcooper.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import com.xcooper.R;


public class DrawHookView extends View {
    //����Բ���Ľ��ֵ
    public static int progress = 0;
    //��1��x��
    public static int line1_x = 0;
    //��1��y��
    public static int line1_y = 0;
    //��2��x��
    public static int line2_x = 0;
    //��2��y��
    public static int line2_y = 0;

    public DrawHookView(Context context) {
        super(context);
    }

    public DrawHookView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public DrawHookView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }


    public static boolean if_paint = true;


    /**
     * ������������
     */
    public static void init_new(DrawHookView view) {
        progress = 0;
        line1_x = 0;
        line1_y = 0;
        line2_x = 0;
        line2_y = 0;
        if_paint = true;
        view.postInvalidate();
    }

    //����

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        progress = progress + 4;

        /**
         * ����Բ��
         */
        Paint paint = new Paint();
        //���û�����ɫ
        paint.setColor(getResources().getColor(R.color.lightgray));

        //����Բ���Ŀ��
        paint.setStrokeWidth(5);
        //����Բ��Ϊ����
        paint.setStyle(Paint.Style.STROKE);
        //�����
        paint.setAntiAlias(true);

        //��ȡԲ�ĵ�x���
        int center = getWidth() / 2;
        int center1 = center - getWidth() / 5;
        //Բ���뾶
        int radius = getWidth() / 2 - 5;

        //�����Բ������״�ʹ�С�Ľ���
        RectF rectF = new RectF(center - radius - 1, center - radius - 1, center + radius + 1, center + radius + 1);

        //��ݽ�Ȼ�Բ��
        canvas.drawArc(rectF, 235, -360 * progress / 100, false, paint);

        /**
         * ���ƶԹ�
         */
        //�ȵ�Բ�����꣬�Ż��Թ�
        if (progress >= 100) {
            if (line1_x < radius / 3) {
                line1_x++;
                line1_y++;
            }
            //����һ����
            canvas.drawLine(center1, center, center1 + line1_x, center + line1_y, paint);

            if (line1_x == radius / 3) {
                line2_x = line1_x;
                line2_y = line1_y;
                line1_x++;
                line1_y++;
            }
            if (line1_x >= radius / 3 && line2_x <= radius) {
                line2_x=line2_x+2;
                line2_y=line2_y-2;
            } else if (line1_x >= radius / 3) {
                if_paint = false;
            }
            //���ڶ�����
            canvas.drawLine(center1 + line1_x - 1, center + line1_y, center1 + line2_x, center + line2_y, paint);
        }
        //ÿ��6�������ˢ��
        if (if_paint)
            postInvalidateDelayed(7);
    }
}