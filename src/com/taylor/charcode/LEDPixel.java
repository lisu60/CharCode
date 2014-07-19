package com.taylor.charcode;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class LEDPixel extends View {
	
	private static final int COLOR_ON=0xFFE23131;
	private static final int COLOR_OFF=0xFF828282;
	private Paint paint;
	private boolean status=false;
	private int a;
	

	public LEDPixel(Context context, AttributeSet attrs) {
		super(context, attrs);
		paint=new Paint(Paint.ANTI_ALIAS_FLAG);
		paint.setStyle(Paint.Style.FILL);
	}

	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec)
	{
		super.onMeasure(widthMeasureSpec, heightMeasureSpec);
		int width, height;
		width=getMeasuredWidth();
		height=getMeasuredHeight();
		if(width>height){
			setMeasuredDimension(height, height);
			a=height;
		}
		else{
			setMeasuredDimension(width, width);
			a=width;
		}
	}
	
	@Override
	protected void onDraw(Canvas canvas){
		super.onDraw(canvas);
		canvas.drawColor(0xFF000000);
		if(status){
			paint.setColor(COLOR_ON);
			
		}
		else{
			paint.setColor(COLOR_OFF);
		}
		
		canvas.drawCircle(a/2, a/2, a/(float)20*8, paint);

	}
}
