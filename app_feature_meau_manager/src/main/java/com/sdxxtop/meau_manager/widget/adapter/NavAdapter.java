package com.sdxxtop.meau_manager.widget.adapter;

import android.content.Context;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.chad.library.adapter.base.BaseViewHolder;
import com.sdxxtop.meau_manager.R;
import com.sdxxtop.meau_manager.entity.MenuItemEntry;
import com.sdxxtop.meau_manager.helper.ItemTouchCallback;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Email: zhousaito@163.com
 * Created by zhousaito 2019-11-21 16:15
 * Version: 1.0
 * Description:
 */
public class NavAdapter extends CanCloseAdapter<MenuItemEntry, BaseViewHolder> implements ItemTouchCallback.MoveListener {

    private final int mItemHeight;
    private final Animation shake; //抖动动画

    public NavAdapter(Context context) {
        super(R.layout.item_menu_recycler);
        int widthPixels = context.getResources().getDisplayMetrics().widthPixels;
        mItemHeight = widthPixels / 4;
        shake = AnimationUtils.loadAnimation(context, R.anim.item_shake);
    }

    @Override
    protected void convert(BaseViewHolder helper, MenuItemEntry item) {
        LinearLayout llRoot = helper.getView(R.id.ll_root);
        FrameLayout.LayoutParams lp = (FrameLayout.LayoutParams) llRoot.getLayoutParams();
        lp.height = mItemHeight;
        llRoot.setLayoutParams(lp);

        //设置icon
        ImageView ivIcon = helper.getView(R.id.iv_icon);
        ivIcon.setImageResource(item.getIcon() != 0 ? item.getIcon() : R.drawable.meau_attendance);

        //设置名字
        TextView tvName = helper.getView(R.id.tv_name);
        tvName.setText(item.getName() != null ? item.getName() : "学生出勤");


        View llParent = helper.getView(R.id.ll_parent);
        ImageView ivControl = helper.getView(R.id.iv_control);
        handleLlParentAndIvControl(llParent, ivControl, helper.getAdapterPosition(), item);

        View view = helper.getView(R.id.ll_root);
        if (isCanDelItem() && isEdit) {
            view.setAnimation(shake);
        } else {
            view.clearAnimation();
        }

    }

    private void handleLlParentAndIvControl(View llParent, ImageView ivControl, int position, MenuItemEntry item) {

        if (isEdit) {
            ivControl.setVisibility(View.VISIBLE);
        } else {
            ivControl.setVisibility(View.INVISIBLE);
        }

        if (isCanDelItem()) {//可以进行删除的
            ivControl.setImageResource(R.drawable.delete_manage);
            llParent.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    getData().remove(item);
                    if (iRemoveListener != null) {
                        iRemoveListener.removeAndShow(item);
                    }
                    notifyDataSetChanged();
                }
            });
        } else { //编辑的
            ivControl.setImageResource(R.drawable.add_manage);
            llParent.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (iAddListener != null) {
                        item.setShow(false);
                        iAddListener.addAndGone(item);
                    }

                    replaceCloseData(isClose);
                    notifyDataSetChanged();
                }
            });
        }

        //设置长按事件
        llParent.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {

//                addItemDecoration();
                if (onItemLongClickListener != null) {
                    onItemLongClickListener.onItemLongClick(null, v, position, 0);
                }

                return false;
            }
        });
    }

    @Override
    public void onItemMove(int position, int targetPosition) {
        swap(position, targetPosition);

        notifyItemMoved(position, targetPosition);
    }

    /**
     * 交换位置
     *
     * @param position
     * @param targetPosition
     */
    private void swap(int position, int targetPosition) {
        if (position < targetPosition) {
            for (int i = position; i < targetPosition; i++) {
                Collections.swap(getData(), i, i + 1);
            }
        } else {
            for (int i = position; i > targetPosition; i--) {
                Collections.swap(getData(), i, i - 1);
            }
        }
    }

    @Override
    public void replaceData(@NonNull Collection<? extends MenuItemEntry> data) {
        super.replaceData(data);

    }

//    /**
//     * 关闭的时候，进行的操作
//     */
//    public void replaceCloseData(boolean isClose) {
//        ArrayList<MenuItemEntry> list = new ArrayList<>();
//        if (isClose) {
//            for (int i = 0; i < tempList.size(); i++) {
//                if (i < 4) {
//                    list.add(tempList.get(i));
//                }
//            }
//        } else {
//            list.addAll(tempList);
//        }
//        mData = list;
//        //刷新
//        notifyDataSetChanged();
//    }

    @Override
    public void saveAllAndAddDataList(List<MenuItemEntry> list) {
        if (tempList == null) {
            tempList = new ArrayList<>();
        }
        tempList.addAll(list);

        //add
        replaceData(list);
    }
}
