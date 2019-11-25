package com.sdxxtop.meau_manager.widget.menu;

import java.util.List;

/**
 * Email: zhousaito@163.com
 * Created by zhousaito 2019-11-21 17:49
 * Version: 1.0
 * Description:
 */
public interface IExtendAdapter<T> {
    /**
     * 关闭和开启的时候，进行的操作
     * @param isClose
     */
    void replaceCloseData(boolean isClose);

    void saveAllAndAddDataList(List<T> list);
}
