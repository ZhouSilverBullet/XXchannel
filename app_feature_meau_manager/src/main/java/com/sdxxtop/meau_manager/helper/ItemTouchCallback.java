package com.sdxxtop.meau_manager.helper;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

/**
 * Email: zhousaito@163.com
 * Created by zhousaito 2019-11-21 16:38
 * Version: 1.0
 * Description:
 */
public class ItemTouchCallback extends ItemTouchHelper.Callback {

    /**
     * 判断动作方向
     *
     * @param recyclerView
     * @param viewHolder
     * @return
     */
    @Override
    public int getMovementFlags(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder) {
        int dragFlags = ItemTouchHelper.UP | ItemTouchHelper.DOWN | ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT;
//        int swipeFlags = ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT;
//        int flags = makeMovementFlags(dragFlags, swipeFlags);
        return makeMovementFlags(dragFlags, 0);
    }

    /**
     * 拖拽回调
     *
     * @param recyclerView
     * @param viewHolder
     * @param target
     * @return
     */
    @Override
    public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
        if (viewHolder.getItemViewType() != target.getItemViewType()) {
            return false;
        }
        //将我们的真实（List）数据位置交换
        if (moveListener != null) {
            moveListener.onItemMove(viewHolder.getAdapterPosition(), target.getAdapterPosition());
        }
        return true;
    }

    @Override
    public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {

    }

    @Override
    public boolean isLongPressDragEnabled() {
        return true;
    }

    private MoveListener moveListener;

    public void setMoveListener(MoveListener moveListener) {
        this.moveListener = moveListener;
    }

    public interface MoveListener {
        void onItemMove(int position, int targetPosition);
    }
}
