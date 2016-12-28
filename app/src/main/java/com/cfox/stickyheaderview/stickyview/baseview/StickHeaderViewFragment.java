package com.cfox.stickyheaderview.stickyview.baseview;

import android.support.v4.app.Fragment;

import com.cfox.stickyheaderview.stickyview.HeaderScrollHelper;

/**
 * <br/>************************************************
 * <br/>PROJECT_NAME : StickyHeaderView
 * <br/>PACKAGE_NAME : com.cfox.stickyheaderview.stickyview.baseview
 * <br/>AUTHOR : CFOX
 * <br/>MSG :
 * <br/>************************************************
 */
public abstract class StickHeaderViewFragment extends Fragment implements HeaderScrollHelper.ScrollableContainer {

    public abstract String getViewName();
}
