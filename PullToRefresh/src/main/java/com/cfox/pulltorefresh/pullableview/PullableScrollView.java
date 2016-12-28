package com.cfox.pulltorefresh.pullableview;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ScrollView;

/**
 * <br/>************************************************
 * <br/>PROJECT_NAME : PullToRefresh
 * <br/>PACKAGE_NAME : com.cfox.pulltorefresh.pullableview
 * <br/>AUTHOR : CFOX
 * <br/>MSG :
 * <br/>************************************************
 */
public class PullableScrollView extends ScrollView implements Pullable {
    private boolean isCanPullDown = true;

    public PullableScrollView(Context context) {
        super(context);
    }

    public PullableScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public PullableScrollView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    public boolean canPullDown() {
        if (isCanPullDown){
            if (getScrollY() == 0)
                return true;
            else
                return false;
        }else {
            return false;
        }
    }


    public void setCanPullDown(boolean canPullDown) {
        isCanPullDown = canPullDown;
    }

}
