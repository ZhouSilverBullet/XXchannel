package com.sdxxtop.meau_manager;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

import com.sdxxtop.meau_manager.entity.MenuItemEntry;
import com.sdxxtop.meau_manager.helper.ItemTouchCallback;
import com.sdxxtop.meau_manager.widget.adapter.MenuAdapterManager;
import com.sdxxtop.meau_manager.widget.adapter.NavAdapter;
import com.sdxxtop.meau_manager.widget.menu.IAddListener;
import com.sdxxtop.meau_manager.widget.menu.IRemoveListener;
import com.sdxxtop.meau_manager.widget.menu.MenuManagerItemView;

import java.util.ArrayList;

public class MenuManagerActivity extends AppCompatActivity {

    private RecyclerView rvNav;
    private MenuManagerItemView mmivApply;
    private MenuManagerItemView mmivClassManager;
    private MenuManagerItemView mmivOffice;

    private MenuAdapterManager<MenuItemEntry> menuAdapterManager;
    private NavAdapter navAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_manager);

        initView();
    }

    private void initView() {

        menuAdapterManager = new MenuAdapterManager<>();

        initNavRv();

        initApply();

        initClassManager();

        initOffice();

    }

    private void initOffice() {
        mmivOffice = findViewById(R.id.mmiv_office);
        NavAdapter officeAdapter = new NavAdapter(this);

        menuAdapterManager.addAdapter(officeAdapter);
        ArrayList<MenuItemEntry> list = handleOfficeData();
        if (list.size() > 0) {
            officeAdapter.setOutType(list.get(0).getOutType());
        }

        mmivOffice.setAdapter(officeAdapter);
        officeAdapter.saveAllAndAddDataList(list);

        officeAdapter.setAddListener(new IAddListener<MenuItemEntry>() {
            @Override
            public void addAndGone(MenuItemEntry entry) {
                navAdapter.addData(entry);
            }
        });

        officeAdapter.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
//                mmivApply.addItemDecoration();
                menuAdapterManager.addAllItemDecorationAndEdit();
                return false;
            }
        });
    }

    private void initClassManager() {
        mmivClassManager = findViewById(R.id.mmiv_class_manager);
        NavAdapter classManagerAdapter = new NavAdapter(this);

        menuAdapterManager.addAdapter(classManagerAdapter);
        ArrayList<MenuItemEntry> list = handleClassManagerData();
        if (list.size() > 0) {
            classManagerAdapter.setOutType(list.get(0).getOutType());
        }

        mmivClassManager.setAdapter(classManagerAdapter);
        classManagerAdapter.saveAllAndAddDataList(list);

        classManagerAdapter.setAddListener(new IAddListener<MenuItemEntry>() {
            @Override
            public void addAndGone(MenuItemEntry entry) {
                navAdapter.addData(entry);
            }
        });

        classManagerAdapter.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
//                mmivApply.addItemDecoration();
                menuAdapterManager.addAllItemDecorationAndEdit();
                return false;
            }
        });
    }

    private void initApply() {
        mmivApply = findViewById(R.id.mmiv_apply);
        NavAdapter applyAdapter = new NavAdapter(this);

        menuAdapterManager.addAdapter(applyAdapter);

        ArrayList<MenuItemEntry> list = handleApplyData();
        if (list.size() > 0) {
            applyAdapter.setOutType(list.get(0).getOutType());
        }

        mmivApply.setAdapter(applyAdapter);
        applyAdapter.saveAllAndAddDataList(list);

        applyAdapter.setAddListener(new IAddListener<MenuItemEntry>() {
            @Override
            public void addAndGone(MenuItemEntry entry) {
                navAdapter.addData(entry);
            }
        });

        applyAdapter.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
//                mmivApply.addItemDecoration();
                menuAdapterManager.addAllItemDecorationAndEdit();
                return false;
            }
        });
    }

    private void initNavRv() {
        rvNav = findViewById(R.id.rv_nav);
        rvNav.setLayoutManager(new GridLayoutManager(this, 4));

        ArrayList<MenuItemEntry> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(new MenuItemEntry());
        }

        navAdapter = new NavAdapter(this);
        rvNav.setAdapter(navAdapter);
        navAdapter.setEmptyView(R.layout.nav_empty_view, rvNav);

        menuAdapterManager.setNavAdapter(navAdapter);

        navAdapter.setCanDelItem(true);

        navAdapter.replaceData(list);
        navAdapter.bindToRecyclerView(rvNav);

        ItemTouchCallback callback = new ItemTouchCallback();
        new ItemTouchHelper(callback).attachToRecyclerView(rvNav);
        callback.setMoveListener(navAdapter);

        navAdapter.setRemoveListener(new IRemoveListener<MenuItemEntry>() {
            @Override
            public void removeAndShow(MenuItemEntry entry) {
                menuAdapterManager.handleRemoveAdapterData(entry);
            }
        });

        navAdapter.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
//                mmivApply.addItemDecoration();
                menuAdapterManager.addAllItemDecorationAndEdit();
                return false;
            }
        });
    }

    private ArrayList<MenuItemEntry> handleApplyData() {
        ArrayList<MenuItemEntry> list = new ArrayList<>();
        list.add(new MenuItemEntry(R.drawable.meau_leave, "请假", 100, 1, true));
        list.add(new MenuItemEntry(R.drawable.meau_overtime, "加班", 100, 2, true));
        list.add(new MenuItemEntry(R.drawable.meau_evection, "出差", 100, 3, true));
        list.add(new MenuItemEntry(R.drawable.meau_kaoqinshenqing, "免考勤申请", 100, 4, true));
        list.add(new MenuItemEntry(R.drawable.meau_waiqin, "外勤", 100, 5, true));
        list.add(new MenuItemEntry(R.drawable.meau_shenpi, "我申请的", 100, 6, true));
        list.add(new MenuItemEntry(R.drawable.meau_shenpi, "我审批的", 100, 7, true));
        return list;
    }

    private ArrayList<MenuItemEntry> handleClassManagerData() {
        ArrayList<MenuItemEntry> list = new ArrayList<>();
        list.add(new MenuItemEntry(R.drawable.meau_tongzhi, "班级通知", 101, 1, true));
        list.add(new MenuItemEntry(R.drawable.meau_my_homework, "布置作业", 101, 2, true));
        list.add(new MenuItemEntry(R.drawable.meau_attendance, "学生出勤", 101, 3, true));
        list.add(new MenuItemEntry(R.drawable.meau_dianming, "课堂点名", 101, 4, true));
        list.add(new MenuItemEntry(R.drawable.meau_kunnanshenqing, "困难申请", 101, 5, true));
        list.add(new MenuItemEntry(R.drawable.meau_xinliceping, "心理测评", 101, 6, true));
        list.add(new MenuItemEntry(R.drawable.meau_chengyuan, "成员管理", 101, 7, true));

        return list;
    }

    private ArrayList<MenuItemEntry> handleOfficeData() {
        ArrayList<MenuItemEntry> list = new ArrayList<>();
        list.add(new MenuItemEntry(R.drawable.meau_gonggao, "公告", 102, 1, true));
        list.add(new MenuItemEntry(R.drawable.meau_work, "工作汇报", 102, 2, true));
        list.add(new MenuItemEntry(R.drawable.meau_statistics, "统计", 102, 3, true));
        list.add(new MenuItemEntry(R.drawable.meau_classes, "排班", 102, 4, true));
        list.add(new MenuItemEntry(R.drawable.meau_vote, "民主评议", 102, 5, true));

        return list;
    }
}
