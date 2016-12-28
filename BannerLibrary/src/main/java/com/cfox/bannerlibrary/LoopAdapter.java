package com.cfox.bannerlibrary;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;

/**
 * <br/>************************************************
 * <br/>PROJECT_NAME : BannerView
 * <br/>PACKAGE_NAME : com.cfox.bannerlibrary
 * <br/>AUTHOR : CFOX
 * <br/>MSG :
 * <br/>************************************************
 */
public class LoopAdapter<T> extends PagerAdapter{
    private static final String TAG = "LoopAdapter";
    private List<T> mLoopDatas;
    private Context mCtx;

    private LoopPageAdapter mLoopPageAdapter;

    private LoopListener<T> mClickListener;

    public LoopAdapter(Context context , LoopPageAdapter adapter){
        this.mCtx = context;
        this.mLoopPageAdapter = adapter;
        this.mLoopDatas = adapter.getDatas();
    }

    public void setOnClickListener(LoopListener listener){
        this.mClickListener = listener;
    }


    @Override
    public int getCount() {
        return mLoopDatas.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, final int position) {

        View view = new ImageView(mCtx);
        View viewBuffer = null;
        ((ImageView)view).setScaleType(ImageView.ScaleType.CENTER_CROP);

        if(mLoopPageAdapter != null){
            viewBuffer = mLoopPageAdapter.onLoadPage((ImageView) view,mLoopDatas.get(position),position);
            if(viewBuffer != null){
                view = viewBuffer;
                viewBuffer = null;
            }
        }

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mClickListener != null){
                    mClickListener.onItemClickListener(mLoopDatas.get(position),position);
                }
            }
        });
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View)object);

    }


}
