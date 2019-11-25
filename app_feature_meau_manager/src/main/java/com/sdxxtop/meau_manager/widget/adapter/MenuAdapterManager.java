package com.sdxxtop.meau_manager.widget.adapter;

import com.sdxxtop.meau_manager.entity.MenuItemEntry;
import com.sdxxtop.meau_manager.widget.menu.IShow;

import java.util.ArrayList;
import java.util.List;

/**
 * Email: zhousaito@163.com
 * Created by zhousaito 2019-11-22 12:10
 * Version: 1.0
 * Description:
 */
public class MenuAdapterManager<T extends MenuItemEntry> {
    private CanCloseAdapter navAdapter;
    private List<CanCloseAdapter> list = new ArrayList<>();


    public void setNavAdapter(CanCloseAdapter navAdapter) {
        this.navAdapter = navAdapter;
    }

    public void addAdapter(CanCloseAdapter adapter) {
        list.add(adapter);
    }

    public void removeAdapter(CanCloseAdapter adapter) {
        list.remove(adapter);
    }

    /**
     * nav adapter 不添加到这里面
     * @param t
     */
    public void handleRemoveAdapterData(T t) {
        //1 先默认是申请
        for (CanCloseAdapter canCloseAdapter : list) {
            if (canCloseAdapter.getOutType() == t.getOutType()) {
                for (Object datum : canCloseAdapter.getTempList()) {
                    if (datum instanceof IShow && ((IShow) datum).getItemType() == t.getItemType()) {
                        ((MenuItemEntry) datum).setShow(true);
                        break;
                    }
                }
                canCloseAdapter.replaceCloseData(canCloseAdapter.isClose);
                canCloseAdapter.notifyDataSetChanged();
                break;
            }
        }


    }

    public void release() {
        list = null;
        if (navAdapter != null) {
            navAdapter = null;
        }
    }

    public void addAllItemDecorationAndEdit() {
        if (list == null) {
            return;
        }
        for (CanCloseAdapter canCloseAdapter : list) {
            canCloseAdapter.addItemDecoration();
            //进入编辑状态
            canCloseAdapter.enterEdit();
        }

        //上面的enterEdit也进入了编辑页面
        if (navAdapter != null) {
            navAdapter.enterEdit();
        }
    }
}
