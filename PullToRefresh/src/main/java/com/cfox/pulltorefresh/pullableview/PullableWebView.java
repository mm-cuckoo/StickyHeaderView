package com.cfox.pulltorefresh.pullableview;

import android.content.Context;
import android.util.AttributeSet;
import android.webkit.WebView;

/**
 * <br/>************************************************
 * <br/>PROJECT_NAME : PullToRefresh
 * <br/>PACKAGE_NAME : com.cfox.pulltorefresha.pullableview
 * <br/>AUTHOR : CFOX
 * <br/>MSG :
 * <br/>************************************************
 */
public class PullableWebView extends WebView implements Pullable {

    private boolean isCanPullDown = true;

    public PullableWebView(Context context) {
        super(context);
    }

    public PullableWebView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public PullableWebView(Context context, AttributeSet attrs, int defStyle) {
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
