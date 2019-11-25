package com.sdxxtop.meau_manager.widget.menu;

import android.content.Context;
import android.util.AttributeSet;

import androidx.appcompat.widget.AppCompatTextView;

/**
 * Email: zhousaito@163.com
 * Created by zhousaito 2019-11-21 17:40
 * Version: 1.0
 * Description:
 */
public class StatusTextView extends AppCompatTextView {

    public static final String TEXT_OPEN = "展开";
    public static final String TEXT_CLOSE = "收起";
    //true  已经收起来的
    //false 展开
    private boolean isStatus;

    public StatusTextView(Context context) {
        super(context);
    }

    public StatusTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public StatusTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public boolean isStatus() {
        return isStatus;
    }

    public void setStatus(boolean status) {
        isStatus = status;
        if (status) {
            setText(TEXT_OPEN);
        } else {
            setText(TEXT_CLOSE);
        }
    }
}
