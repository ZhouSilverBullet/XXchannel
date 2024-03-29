package com.sdxxtop.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;

import androidx.viewpager.widget.ViewPager;

/**
 * Email: zhousaito@163.com
 * Created by zhousaito 2019-09-23 16:07
 * Version: 1.0
 * Description:
 */
public class ViewPagerEx extends ViewPager {
    private boolean isPagingEnabled = true;

    public ViewPagerEx(Context context) {
        super(context);
    }
    public ViewPagerEx(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return this.isPagingEnabled && super.onTouchEvent(event);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent event) {
        return this.isPagingEnabled && super.onInterceptTouchEvent(event);
    }

    public void setPagingEnabled(boolean canScroll) {
        this.isPagingEnabled = canScroll;
    }

    @Override
    public void setCurrentItem(int item, boolean smoothScroll) {
        super.setCurrentItem(item, smoothScroll);
    }
}
