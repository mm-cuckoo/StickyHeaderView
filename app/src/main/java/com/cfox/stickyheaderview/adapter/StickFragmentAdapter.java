package com.cfox.stickyheaderview.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.cfox.stickyheaderview.stickyview.baseview.StickHeaderViewFragment;

import java.util.List;

/**
 * <br/>************************************************
 * <br/>PROJECT_NAME : StickyHeaderView
 * <br/>PACKAGE_NAME : com.cfox.stickyheaderview.adapter
 * <br/>AUTHOR : CFOX
 * <br/>MSG :
 * <br/>************************************************
 */
public class StickFragmentAdapter extends FragmentPagerAdapter {
    private List<StickHeaderViewFragment> mFragments;
    public StickFragmentAdapter(List<StickHeaderViewFragment> fragments,FragmentManager fm) {
        super(fm);
        mFragments = fragments;
    }


    @Override
    public CharSequence getPageTitle(int position) {
        return mFragments.get(position).getViewName();
    }

    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }
}
