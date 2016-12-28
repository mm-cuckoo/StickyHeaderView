package com.cfox.stickyheaderview.dataservice;

import com.cfox.stickyheaderview.bean.LooperBean;

import java.util.ArrayList;
import java.util.List;

/**
 * <br/>************************************************
 * <br/>PROJECT_NAME : StickyHeaderView
 * <br/>PACKAGE_NAME : com.cfox.stickyheaderview.dataservice
 * <br/>AUTHOR : CFOX
 * <br/>MSG :
 * <br/>************************************************
 */
public class DataService {

    public static List getLoopData(){
        List<LooperBean> list = new ArrayList<>();
        LooperBean bean = new LooperBean();
        bean.setImgUrl("http://i-3.yiwan.com/2016/8/25/W3dtOjEucG5nLHI6MTMsYjoxM10=/7841adb0-7039-4c52-8e13-d0e3d3bc7ac4.png");
        bean.setTitle("good");
        list.add(bean);

        bean = new LooperBean();
        bean.setImgUrl("http://img2015.zdface.com/20160816/e11b00654e7441fb4143dfcf8d1ab487.jpg");
        bean.setTitle("北京欢迎您");
        list.add(bean);

        bean = new LooperBean();
        bean.setImgUrl("http://cdn.duitang.com/uploads/item/201509/14/20150914113327_ahWQs.jpeg");
        bean.setTitle("您好马先生");
        list.add(bean);
        return list;

    }
}
