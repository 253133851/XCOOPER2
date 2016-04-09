package com.xcooper.view;

import java.util.ArrayList;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Build;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;

import com.xcooper.R;


public class RevealLayout extends LinearLayout implements Runnable{
	private Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
	
	private float mCenterX,mCenterY;
	
	private int[] mLocation = new int[2];
	
	private int INVALIDATE_DURATION = 40;
	private int mTargetHeight,mTargetWidth;
	private int mRevealRadius = 0,mRevealRadiusGap,mMaxRadius;
	private int mMinBetweenWidthAndHeight,mMaxBetweenWidthAndHeight;
	
	private boolean mIsPressed;
	private boolean mShouldDoAnimation;
	
	private View mTargetView;
	private DispatchUpTouchEventRunnable mDispatchUpTouchEventRunnable = new DispatchUpTouchEventRunnable();
	
	public RevealLayout(Context context) {
		super(context);
		init();
	}
	
	public RevealLayout(Context context, AttributeSet attrs){
		super(context,attrs);
		init();
	}
	
	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	public RevealLayout(Context context, AttributeSet attrs, int defStyleAttr){
		super(context,attrs,defStyleAttr);
		init();
	}

	public void init(){
		setWillNotDraw(false);
		mPaint.setColor(getResources().getColor(R.color.reveal_color));
	}
	
	@Override
	protected void onLayout(boolean changed, int l, int t, int r, int b) {
		super.onLayout(changed, l, t, r, b);
		this.getLocationOnScreen(mLocation);
	}
	
	@Override
	protected void dispatchDraw(Canvas canvas) {
		super.dispatchDraw(canvas);
		
		if(mTargetView == null || !mShouldDoAnimation || mTargetWidth <= 0)
			return;
		
		if(mRevealRadius > mMinBetweenWidthAndHeight / 2)
			mRevealRadius += mRevealRadiusGap * 4;
		else
			mRevealRadius += mRevealRadiusGap;
		
		int[] location = new int[2];
		this.getLocationOnScreen(mLocation);
		mTargetView.getLocationOnScreen(location);

		int top = location[1] - mLocation[1];
		int left = location[0] - mLocation[0];
		int right = left + mTargetView.getMeasuredWidth();
		int bottom = top + mTargetView.getMeasuredHeight();
		
		canvas.save();
		canvas.clipRect(left, top, right, bottom);
		canvas.drawCircle(mCenterX, mCenterY, mRevealRadius, mPaint);
		canvas.restore();
		
		if(mRevealRadius <= mMaxRadius)
			postInvalidateDelayed(INVALIDATE_DURATION, left, top, right, bottom);
		else if(!mIsPressed){
			mShouldDoAnimation = false;
			postInvalidateDelayed(INVALIDATE_DURATION, left, top, right, bottom);
		}
	}
	
	@Override
	public boolean dispatchTouchEvent(MotionEvent event) {
		int x = (int)event.getRawX();
		int y = (int)event.getRawY();
		int action = event.getAction();
		
		switch(action){
			case MotionEvent.ACTION_DOWN:
				View targetView = getTargetView(this,x,y);
				
				if(targetView != null && targetView.isEnabled()){
					mTargetView = targetView;
					initParametersForChild(event,targetView);
					postInvalidateDelayed(INVALIDATE_DURATION);
				}
				break;
				
			case MotionEvent.ACTION_UP:
				mIsPressed = false;
				postInvalidateDelayed(INVALIDATE_DURATION);
				mDispatchUpTouchEventRunnable.event = event;
				postDelayed(mDispatchUpTouchEventRunnable, 40);
				break;
				
			case MotionEvent.ACTION_CANCEL:
				mIsPressed = false;
				postInvalidateDelayed(INVALIDATE_DURATION);
				break;
		}		
		return super.dispatchTouchEvent(event);
	}
	
	public View getTargetView(View view,int x,int y){
		View target = null;
		ArrayList<View> views = view.getTouchables();
		
		for(View child : views)
			if(isTouchPointInView(child,x,y)){
				target = child;
				break;
			}
		return target;
	}
	
	public boolean isTouchPointInView(View child,int x,int y){
		int[] location = new int[2];
		child.getLocationOnScreen(location);

		int top = location[1];
		int left = location[0];
		int right = left + child.getMeasuredWidth();
		int bottom = top + child.getMeasuredHeight();
		
		if(child.isClickable() && y>=top && y<= bottom && x >= left && x<= right)
			return true;
		else
			return false;
	}
	
	public void initParametersForChild(MotionEvent event,View view){
		mCenterX = event.getX();
		mCenterY = event.getY();
		mTargetWidth = view.getMeasuredWidth();
		mTargetHeight = view.getMeasuredHeight();
		mMinBetweenWidthAndHeight = Math.min(mTargetWidth, mTargetHeight);
		mMaxBetweenWidthAndHeight = Math.max(mTargetWidth, mTargetHeight);

		mRevealRadius = 0;
		mRevealRadiusGap = mMinBetweenWidthAndHeight / 8;

		mIsPressed = true;
		mShouldDoAnimation = true;
		
		int[] location = new int[2];
		view.getLocationOnScreen(location);
		
		int left = location[0] - mLocation[0];
		int mTransformedCenterX = (int)mCenterX - left;
		mMaxRadius = Math.max(mTransformedCenterX, mTargetWidth - mTransformedCenterX);
	}
	
	@Override
	public void run() {
		super.performClick();
	}

	@Override
	public boolean performClick() {
		postDelayed(this,300);
		return true;
	}
	private class DispatchUpTouchEventRunnable implements Runnable{
		public MotionEvent event;
		
		@Override
		public void run() {
			if(mTargetView.isEnabled() && mTargetView.isClickable())
				return;
			
			if(isTouchPointInView(mTargetView, (int)event.getRawX(), (int)event.getRawX()))
				mTargetView.performClick();
		}
	}
}
