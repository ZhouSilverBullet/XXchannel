package com.sdxxtop.analysis.impl;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.sdxxtop.analysis.callback.OnFragmentVisibleListener;

import java.util.Map;
import java.util.WeakHashMap;

/**
 * Email: zhousaito@163.com
 * Created by zhousaito 2019-08-07 14:34
 * Version: 1.0
 * Description:
 */
public class FragmentLifecycleListener extends FragmentManager.FragmentLifecycleCallbacks implements OnFragmentVisibleListener  {

    private Map<Fragment, Long> resumeTimeMap = new WeakHashMap<>();
    private Map<Fragment, Long> durationMap = new WeakHashMap<>();
//    private Map<Fragment, Boolean> eventTrackerMap = new WeakHashMap<>();

    @Override
    public void onFragmentAttached(@NonNull FragmentManager fm, @NonNull Fragment f, @NonNull Context context) {
        super.onFragmentAttached(fm, f, f.getActivity());
        resumeTimeMap.put(f, 0L);
        durationMap.put(f, 0L);
//        eventTrackerMap.put(f, false);
        if (f instanceof LifecycleFragment) {
            ((LifecycleFragment) f).listener = this;
        }
    }

    @Override
    public void onFragmentResumed(@NonNull FragmentManager fm, @NonNull Fragment f) {
        super.onFragmentResumed(fm, f);
        if (!f.isHidden() && f.getUserVisibleHint()) {
            onVisibleChanged(f, true);
        }
//        LogUtil.i(f.getClass().getSimpleName() + " onFragmentResumed");
    }

    @Override
    public void onFragmentPaused(@NonNull FragmentManager fm, @NonNull Fragment f) {
        super.onFragmentPaused(fm, f);
        if (!f.isHidden() && f.getUserVisibleHint()) {
            onVisibleChanged(f, false);
        }
        // 解决viewpager中fragment切换时事件统计失效的问题
//        eventTrackerMap.put(f, false);
//        LogUtil.i(f.getClass().getSimpleName() + " onFragmentPaused");
    }

    @Override
    public void onFragmentDetached(@NonNull FragmentManager fm, @NonNull Fragment f) {
        super.onFragmentDetached(fm, f);
        long duration = durationMap.get(f);
//        if (duration > 0) {
//            Tracker.getInstance().addViewEvent(f.getActivity(), f, duration);
//        }
        resumeTimeMap.remove(f);
        durationMap.remove(f);
//        eventTrackerMap.remove(f);
    }

    @Override
    public void onVisibleChanged(Fragment f, boolean visible) {
        if (visible) {
            resumeTimeMap.put(f, System.currentTimeMillis());
        } else {
            durationMap.put(f, durationMap.get(f) + System.currentTimeMillis() - resumeTimeMap.get(f));
        }
//        LogUtil.i(f.getClass().getSimpleName() + " Visible is " + visible);
    }

}
