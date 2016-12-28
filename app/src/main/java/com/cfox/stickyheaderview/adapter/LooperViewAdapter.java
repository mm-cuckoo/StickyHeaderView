package com.cfox.stickyheaderview.adapter;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.cfox.bannerlibrary.LoopPageAdapter;
import com.cfox.stickyheaderview.bean.LooperBean;

import java.util.List;

/**
 * <br/>************************************************
 * <br/>PROJECT_NAME : StickyHeaderView
 * <br/>PACKAGE_NAME : com.cfox.stickyheaderview
 * <br/>AUTHOR : CFOX
 * <br/>MSG :
 * <br/>************************************************
 */
public class LooperViewAdapter extends LoopPageAdapter<LooperBean> {
    private Context mCtx;
    public LooperViewAdapter(Context context ,List<LooperBean> looperBeen) {
        super(looperBeen);
        mCtx = context;
    }

    @Override
    public void onPageSelected(LooperBean looperBean, int position) {
        Log.e("TAG","selected number+++:" + position  + "title:" + looperBean.getTitle());
    }

    @Override
    public View onLoadPage(ImageView view, LooperBean looperBean, int position) {
        Glide.with(mCtx).load(looperBean.getImgUrl()).into(view);
        return view;
    }
}
