package com.cfox.stickyheaderview;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;

import com.cfox.bannerlibrary.CircleIndicator;
import com.cfox.bannerlibrary.LoopViewPager;
import com.cfox.pulltorefresh.PullToRefreshLayout;
import com.cfox.stickyheaderview.adapter.LooperViewAdapter;
import com.cfox.stickyheaderview.adapter.StickFragmentAdapter;
import com.cfox.stickyheaderview.dataservice.DataService;
import com.cfox.stickyheaderview.fragment.GridViewFragment;
import com.cfox.stickyheaderview.fragment.ListViewFragment;
import com.cfox.stickyheaderview.fragment.RecyclerViewFragment;
import com.cfox.stickyheaderview.fragment.ScrollViewFragment;
import com.cfox.stickyheaderview.stickyview.PagerSlidingTabStrip;
import com.cfox.stickyheaderview.stickyview.StickHeaderView;
import com.cfox.stickyheaderview.stickyview.baseview.StickHeaderViewFragment;

import java.util.ArrayList;
import java.util.List;
/**
 * <br/>************************************************
 * <br/>PROJECT_NAME : StickyHeaderView
 * <br/>PACKAGE_NAME : com.cfox.stickyheaderview
 * <br/>AUTHOR : CFOX
 * <br/>MSG :
 * <br/>************************************************
 */
public class MainActivity extends FragmentActivity {

    private List<StickHeaderViewFragment > mStickFragment;
    private StickHeaderView mStickHeaderView;
    private PagerSlidingTabStrip mTabs;
    private ViewPager mViewPager;

    private LoopViewPager mLooperView;
    private CircleIndicator mCircleIndicator;

    private PullToRefreshLayout mRefreshView;
    private RefreshLinearLayout mRefreshLinearView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        /**
         * 下拉刷新
         */
        mRefreshView = (PullToRefreshLayout) findViewById(R.id.refresh_view);
        mRefreshLinearView = (RefreshLinearLayout) findViewById(R.id.refresh_linear_view);
        mRefreshLinearView.setCanRefresh(true);
        mRefreshView.setOnRefreshListener(new PullToRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh(PullToRefreshLayout pullToRefreshLayout) {

                // 下拉刷新操作
                new Handler() {
                    @Override
                    public void handleMessage(Message msg) {
                        // 千万别忘了告诉控件刷新完毕了哦！
                        mRefreshView.refreshFinish(PullToRefreshLayout.SUCCEED);
                    }
                }.sendEmptyMessageDelayed(0, 5000);
            }
        });



        /**
         * banner View
         */
        mLooperView = (LoopViewPager) findViewById(R.id.banner_view);
        mLooperView.setAdapter(new LooperViewAdapter(this, DataService.getLoopData()));
        mCircleIndicator = (CircleIndicator) findViewById(R.id.circle_point);
        mCircleIndicator.setViewPager(mLooperView);


        /**
         * 创建StickView
         */
        mStickFragment = new ArrayList<>();
        mStickFragment.add(ListViewFragment.newInstance().setViewName("ListView"));
        mStickFragment.add(ScrollViewFragment.newInstance().setViewName("ScrollView"));
        mStickFragment.add(RecyclerViewFragment.newInstance().setViewName("RecyClerView"));
        mStickFragment.add(GridViewFragment.newInstance().setViewName("GridView"));


        mStickHeaderView = (StickHeaderView) findViewById(R.id.stick_header_view);
        //设置第一个view
        mStickHeaderView.setCurrentScrollableContainer(mStickFragment.get(0));

        mViewPager = (ViewPager) findViewById(R.id.viewPager);
        mTabs = (PagerSlidingTabStrip) findViewById(R.id.stick_tabs);
        mViewPager.setAdapter(new StickFragmentAdapter(mStickFragment,getSupportFragmentManager()));
        mTabs.setViewPager(mViewPager);

        /**
         * 通过监听viewpager 改变设置fragment
         */
        mViewPager.addOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener(){
            @Override
            public void onPageSelected(int position) {
                mStickHeaderView.setCurrentScrollableContainer(mStickFragment.get(position));
            }
        });

        mStickHeaderView.setOnScrollListener(new StickHeaderView.OnScrollListener() {
            @Override
            public void onScroll(int currentY, int maxY) {
                if (currentY == 0){
                    mRefreshLinearView.setCanRefresh(true);
                }else {
                    mRefreshLinearView.setCanRefresh(false);
                }
            }
        });
    }
}
