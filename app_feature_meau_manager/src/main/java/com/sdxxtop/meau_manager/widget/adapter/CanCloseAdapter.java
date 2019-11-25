package com.sdxxtop.meau_manager.widget.adapter;

import android.widget.AdapterView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.sdxxtop.meau_manager.entity.MenuItemEntry;
import com.sdxxtop.meau_manager.widget.menu.IAddListener;
import com.sdxxtop.meau_manager.widget.menu.IExtendAdapter;
import com.sdxxtop.meau_manager.widget.menu.IRemoveListener;
import com.sdxxtop.meau_manager.widget.menu.IShow;
import com.sdxxtop.meau_manager.widget.menu.RecycleGridDivider;

import java.util.ArrayList;
import java.util.List;

/**
 * Email: zhousaito@163.com
 * Created by zhousaito 2019-11-21 17:51
 * Version: 1.0
 * Description:
 */
public abstract class CanCloseAdapter<T extends IShow, K extends BaseViewHolder> extends BaseQuickAdapter<T, K> implements IExtendAdapter<T> {

    /**
     * 用来存储总的数据
     */
    protected List<T> tempList;

    protected boolean isClose;
    //是否进入编辑状态
    protected boolean isEdit;

    /**
     * 是否是最上面的导航的adapter
     * 如果是，图片显示可以进行删除操作
     */
    private boolean canDelItem;
    //是什么类型的adapter
    private int outType;

    public List<T> getTempList() {
        return tempList;
    }

    public boolean isCanDelItem() {
        return canDelItem;
    }

    public void setCanDelItem(boolean canDelItem) {
        this.canDelItem = canDelItem;
    }

    public int getOutType() {
        return outType;
    }

    public void setOutType(int outType) {
        this.outType = outType;
    }

    public CanCloseAdapter(int layoutResId) {
        super(layoutResId);
    }

    /**
     * 关闭的时候，进行的操作
     */
    @Override
    public void replaceCloseData(boolean isClose) {

        this.isClose = isClose;
        ArrayList<T> list = new ArrayList<>();

        //list2用于筛选，显示的item
        //已经被添加的item不在被显示出来
        ArrayList<T> list2 = new ArrayList<>();
        for (T t : tempList) {
            if (t.isShow()) {
                list2.add(t);
            }
        }

        //关闭状态处理
        //长度超过4条在进行添加前面4条数据
        if (isClose && list2.size() > 3) {
            for (int i = 0; i < list2.size(); i++) {
                //关闭的时候，只保存前面的4个数据
                if (i < 4) {
                    list.add(list2.get(i));
                }
            }
        } else {
            list.addAll(list2);
        }
        mData = list;
        //刷新
        notifyDataSetChanged();
    }

    public void addItemDecoration() {
        if (getRecyclerView() != null) {
            addItemDecoration(new RecycleGridDivider());
        }
    }

    public void addItemDecoration(@NonNull RecyclerView.ItemDecoration decor) {
        if (getRecyclerView() != null) {
            //先删除有的itemDecoration，这样就可以避免重复添加decor，然后让缝隙越来越大
            for (int i = 0; i < getRecyclerView().getItemDecorationCount(); i++) {
                getRecyclerView().removeItemDecoration(getRecyclerView().getItemDecorationAt(i));
            }
            getRecyclerView().addItemDecoration(decor);
        }
    }

    public void enterEdit() {
        setEditStatus(true);
        notifyDataSetChanged();
    }

    public void exitEdit() {
        setEditStatus(false);
        notifyDataSetChanged();
    }

    public void setEditStatus(boolean _isEdit) {
        isEdit = _isEdit;
    }

    protected AdapterView.OnItemLongClickListener onItemLongClickListener;
    protected IAddListener<MenuItemEntry> iAddListener;
    protected IRemoveListener<MenuItemEntry> iRemoveListener;

    public void setAddListener(IAddListener<MenuItemEntry> iAddListener) {
        this.iAddListener = iAddListener;
    }

    public void setRemoveListener(IRemoveListener<MenuItemEntry> iRemoveListener) {
        this.iRemoveListener = iRemoveListener;
    }

    public void setOnItemLongClickListener(AdapterView.OnItemLongClickListener onItemLongClickListener) {
        this.onItemLongClickListener = onItemLongClickListener;
    }
}
