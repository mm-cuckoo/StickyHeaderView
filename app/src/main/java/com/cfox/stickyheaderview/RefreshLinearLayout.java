package com.cfox.stickyheaderview;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;

import com.cfox.pulltorefresh.pullableview.Pullable;

/**
 * <br/>************************************************
 * <br/>PROJECT_NAME : StickyHeaderView
 * <br/>PACKAGE_NAME : com.cfox.stickyheaderview
 * <br/>AUTHOR : CFOX
 * <br/>MSG :
 * <br/>************************************************
 */
public class RefreshLinearLayout extends LinearLayout implements Pullable {

    private boolean isCanRefresh = true;

    public RefreshLinearLayout(Context context) {
        super(context);
    }

    public RefreshLinearLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public RefreshLinearLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void setCanRefresh(boolean canRefresh) {
        isCanRefresh = canRefresh;
    }

    @Override
    public boolean canPullDown() {
        return isCanRefresh;
    }
}
