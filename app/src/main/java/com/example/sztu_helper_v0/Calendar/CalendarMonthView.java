package com.example.sztu_helper_v0.Calendar;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;

import com.haibin.calendarview.Calendar;
import com.haibin.calendarview.MonthView;

public class CalendarMonthView extends MonthView {
    private Paint mTextPaint=new Paint();//文本画笔
    //圆形背景
    private Paint mSchemeBasicPaint=new Paint();
    private float mRadio;
    private int mPadding;
    private float mSchemeBaseLine;

    public CalendarMonthView(Context context) {
        super(context);

        mTextPaint.setTextSize(12);//设置字体大小
        mTextPaint.setColor(0x29317C);//设置字体颜色
        mTextPaint.setAntiAlias(true);//设置防抖动
        mTextPaint.setFakeBoldText(true);//设置粗体

        mSchemeBasicPaint.setAntiAlias(true);
        mSchemeBasicPaint.setStyle(Paint.Style.FILL);//填充内部
        mSchemeBasicPaint.setTextAlign(Paint.Align.CENTER);//文字居中
        mSchemeBasicPaint.setFakeBoldText(true);
        mRadio=12;
        mPadding=8;
        Paint.FontMetrics metrics=mSchemeBasicPaint.getFontMetrics();//字体属性
        mSchemeBaseLine=mRadio-metrics.descent+(metrics.bottom-metrics.top)/2+2;
    }

    @Override
    protected boolean onDrawSelected(Canvas canvas, Calendar calendar, int x, int y, boolean hasScheme) {
        mSelectedPaint.setStyle(Paint.Style.FILL);
        mSelectedPaint.setColor(0xffb6bad2);
        mSelectedPaint.setShadowLayer(16,3,3,0xffb6bad2);
        canvas.drawCircle(x+mItemWidth/2+2,y+mItemHeight/2-2*mPadding-4,56,mSelectedPaint);
        return false;
    }

    @Override
    protected void onDrawScheme(Canvas canvas, Calendar calendar, int x, int y) {
        mSchemeBasicPaint.setColor(calendar.getSchemeColor());
        canvas.drawCircle(x+mItemWidth-mPadding-mRadio/2,y+mPadding+mRadio,mRadio,mSchemeBasicPaint);
        canvas.drawText(calendar.getScheme(),x+mItemWidth-mPadding-mRadio,y+mPadding+mSchemeBaseLine,mTextPaint);
    }

    @Override
    protected void onDrawText(Canvas canvas, Calendar calendar, int x, int y, boolean hasScheme, boolean isSelected) {
        int cx = x + mItemWidth / 2;
        int top = y - mItemHeight / 6;

        if (isSelected) {//优先绘制选择的
            canvas.drawText(String.valueOf(calendar.getDay()), cx, mTextBaseLine + top,
                    mSelectTextPaint);
        } else if (hasScheme) {//否则绘制具有标记的
            canvas.drawText(String.valueOf(calendar.getDay()), cx, mTextBaseLine + top,
                    calendar.isCurrentMonth() ? mSchemeTextPaint : mOtherMonthTextPaint);

        } else {//最好绘制普通文本
            canvas.drawText(String.valueOf(calendar.getDay()), cx, mTextBaseLine + top,
                    calendar.isCurrentDay() ? mCurDayTextPaint :
                            calendar.isCurrentMonth() ? mCurMonthTextPaint : mOtherMonthTextPaint);
        }
    }
}
