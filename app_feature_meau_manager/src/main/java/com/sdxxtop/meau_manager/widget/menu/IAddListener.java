package com.sdxxtop.meau_manager.widget.menu;

/**
 * Email: zhousaito@163.com
 * Created by zhousaito 2019-11-22 11:33
 * Version: 1.0
 * Description:
 */
public interface IAddListener<T> {
    /**
     * 添加出去，然后隐藏当前的
     * @param t
     */
    void addAndGone(T t);
}
