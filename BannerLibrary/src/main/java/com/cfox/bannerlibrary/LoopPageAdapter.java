package com.cfox.bannerlibrary;

import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

/**
 * <br/>************************************************
 * <br/>PROJECT_NAME : BannerView
 * <br/>PACKAGE_NAME : com.cfox.bannerlibrary
 * <br/>AUTHOR : CFOX
 * <br/>MSG :
 * <br/>************************************************
 */
public abstract class LoopPageAdapter<T> {

    private List<T> mDatas = new ArrayList<>();

    public LoopPageAdapter(List<T> ts){
        mDatas.clear();
        if (ts == null){
            return;
        }
        mDatas.addAll(ts);
    }

    public void setData(List<T> ts){
        mDatas.clear();
        if (ts == null){
            return;
        }
        mDatas.addAll(ts);
    }

    public List<T> getDatas(){
        return mDatas;
    }


    public abstract void onPageSelected(T t, int position);

    public abstract View onLoadPage(ImageView view, T t, int position);
}
