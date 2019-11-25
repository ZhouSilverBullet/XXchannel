package com.sdxxtop.meau_manager.widget.menu;

/**
 * Email: zhousaito@163.com
 * Created by zhousaito 2019-11-22 11:40
 * Version: 1.0
 * Description:
 */
public interface IShow {
    /**
     * 是否显示这个item
     * @return
     */
    boolean isShow();

    void setShow(boolean show);

    int getItemType();
}
