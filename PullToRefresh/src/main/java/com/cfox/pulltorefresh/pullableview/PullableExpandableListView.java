package com.cfox.pulltorefresh.pullableview;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ExpandableListView;

/**
 * <br/>************************************************
 * <br/>PROJECT_NAME : PullToRefresh
 * <br/>PACKAGE_NAME : com.cfox.pulltorefresh.pullableview
 * <br/>AUTHOR : CFOX
 * <br/>MSG :
 * <br/>************************************************
 */
public class PullableExpandableListView extends ExpandableListView implements Pullable {

    private boolean isCanPullDown = true;

    public PullableExpandableListView(Context context) {
        super(context);
    }

    public PullableExpandableListView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public PullableExpandableListView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }


    @Override
    public boolean canPullDown() {

        if (isCanPullDown) {
            if (getCount() == 0) {
                // 没有item的时候也可以下拉刷新
                return true;
            } else if (getFirstVisiblePosition() == 0 && getChildAt(0).getTop() >= 0) {
                // 滑到顶部了
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public void setCanPullDown(boolean canPullDown) {
        isCanPullDown = canPullDown;
    }
}
