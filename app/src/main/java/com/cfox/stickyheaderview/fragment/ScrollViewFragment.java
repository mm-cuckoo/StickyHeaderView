package com.cfox.stickyheaderview.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.cfox.stickyheaderview.R;
import com.cfox.stickyheaderview.stickyview.baseview.StickHeaderViewFragment;

/**
 * <br/>************************************************
 * <br/>PROJECT_NAME : StickyHeaderView
 * <br/>PACKAGE_NAME : com.cfox.stickyheaderview.fragment
 * <br/>AUTHOR : CFOX
 * <br/>MSG :
 * <br/>************************************************
 */
public class ScrollViewFragment extends StickHeaderViewFragment {

    private View scrollView;
    private String mName;

    public static ScrollViewFragment newInstance() {
        return new ScrollViewFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        scrollView = inflater.inflate(R.layout.fragment_scrollview, container, false);
        LinearLayout views = (LinearLayout) scrollView.findViewById(R.id.container);
        for (int i = 0; i < 10; i++) {
            View view = new View(getActivity());
            view.setBackgroundColor(Utils.generateBeautifulColor());
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 300);
            view.setLayoutParams(params);
            views.addView(view);
        }
        return scrollView;
    }

    public ScrollViewFragment setViewName(String name) {
        this.mName = name;
        return this;
    }
    @Override
    public String getViewName() {
        if (mName == null){
            mName = this.getClass().getSimpleName();
        }
        return mName;
    }

    @Override
    public View getScrollableView() {
        return scrollView;
    }
}
