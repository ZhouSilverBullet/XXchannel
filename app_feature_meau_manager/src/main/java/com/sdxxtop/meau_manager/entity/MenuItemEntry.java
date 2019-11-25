package com.sdxxtop.meau_manager.entity;

import com.sdxxtop.meau_manager.widget.menu.IShow;

/**
 * Email: zhousaito@163.com
 * Created by zhousaito 2019-11-21 16:16
 * Version: 1.0
 * Description:
 */
public class MenuItemEntry implements IShow {

    private int icon;
    private String name;

    /**
     * 标题的type
     */
    private int outType;
    /**
     * item的type
     */
    private int itemType;

    //是否显示
    private boolean isShow;

    public MenuItemEntry() {
        isShow = true;
    }

    public MenuItemEntry(int icon, String name, int outType, int itemType, boolean isShow) {
        this.icon = icon;
        this.name = name;
        this.outType = outType;
        this.itemType = itemType;
        this.isShow = isShow;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isShow() {
        return isShow;
    }

    public void setShow(boolean show) {
        isShow = show;
    }

    public int getOutType() {
        return outType;
    }

    public void setOutType(int outType) {
        this.outType = outType;
    }

    public int getItemType() {
        return itemType;
    }

    public void setItemType(int itemType) {
        this.itemType = itemType;
    }
}
