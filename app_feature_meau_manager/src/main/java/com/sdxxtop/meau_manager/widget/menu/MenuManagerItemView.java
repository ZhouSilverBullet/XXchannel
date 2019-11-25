package com.sdxxtop.meau_manager.widget.menu;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.sdxxtop.meau_manager.R;
import com.sdxxtop.meau_manager.widget.adapter.CanCloseAdapter;

/**
 * Email: zhousaito@163.com
 * Created by zhousaito 2019-11-21 17:34
 * Version: 1.0
 * Description:
 */
public class MenuManagerItemView extends FrameLayout {
    private static final String TAG = "MenuManagerItemView";

    private RelativeLayout rlRoot;
    private TextView tvTitle;
    private StatusTextView tvStatus;
    private RecyclerView recyclerView;
    private CanCloseAdapter adapter;
    private String textTitleValue;

    public MenuManagerItemView(Context context) {
        this(context, null);
    }

    public MenuManagerItemView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MenuManagerItemView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        TypedArray a = null;
        try {
            a = context.getTheme().obtainStyledAttributes(attrs, R.styleable.MenuManagerItemView, defStyleAttr, 0);
            textTitleValue = a.getString(R.styleable.MenuManagerItemView_mmiv_title);
        } finally {
            if (a != null) {
                a.recycle();
            }
        }


        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.view_menu_manager_item, this, true);
        rlRoot = findViewById(R.id.rl_root);
        tvTitle = findViewById(R.id.tv_title);
        tvStatus = findViewById(R.id.tv_status);

        recyclerView = findViewById(R.id.rv);

        // true 已经收起来的 false 展开
        tvStatus.setStatus(false);

        tvStatus.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                handleTvStatusClick();
            }
        });

        if (!TextUtils.isEmpty(textTitleValue)) {
            tvTitle.setText(textTitleValue);
        }
    }

    public void setAdapter(CanCloseAdapter adapter, RecyclerView.LayoutManager layoutManager) {
        this.adapter = adapter;
        if (recyclerView != null) {
            recyclerView.setLayoutManager(layoutManager);
            recyclerView.setAdapter(adapter);
            adapter.bindToRecyclerView(recyclerView);
        }
    }

    public void setAdapter(CanCloseAdapter adapter) {
        setAdapter(adapter, new GridLayoutManager(getContext(), 4));
    }

    public void addItemDecoration() {
        if (recyclerView != null) {
            addItemDecoration(new RecycleGridDivider());
        }
    }

    public void addItemDecoration(@NonNull RecyclerView.ItemDecoration decor) {
        if (recyclerView != null) {
            //先删除有的itemDecoration，这样就可以避免重复添加decor，然后让缝隙越来越大
            for (int i = 0; i < recyclerView.getItemDecorationCount(); i++) {
                recyclerView.removeItemDecoration(recyclerView.getItemDecorationAt(i));
            }
            recyclerView.addItemDecoration(decor);
        }
    }

    private void handleTvStatusClick() {
        if (adapter == null) {
            return;
        }
        boolean isClose = tvStatus.isStatus();
        adapter.replaceCloseData(!isClose);
        tvStatus.setStatus(!isClose);
    }

}
