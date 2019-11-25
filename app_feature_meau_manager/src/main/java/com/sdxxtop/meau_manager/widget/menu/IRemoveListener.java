package com.sdxxtop.meau_manager.widget.menu;

/**
 * Email: zhousaito@163.com
 * Created by zhousaito 2019-11-22 11:33
 * Version: 1.0
 * Description:
 */
public interface IRemoveListener<T> {
    /**
     * 移除，然后添加匹配对应的recyclerView的item
     * @param t
     */
    void removeAndShow(T t);
}
