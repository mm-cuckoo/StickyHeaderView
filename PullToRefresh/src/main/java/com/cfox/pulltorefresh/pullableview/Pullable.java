package com.cfox.pulltorefresh.pullableview;

/**
 * <br/>************************************************
 * <br/>PROJECT_NAME : PullToRefresh
 * <br/>PACKAGE_NAME : com.cfox.pulltorefresh.pullableview
 * <br/>AUTHOR : CFOX
 * <br/>MSG :
 * <br/>************************************************
 */
public interface Pullable {
    /**
     * 判断是否可以下拉，如果不需要下拉功能可以直接return false
     *
     * @return true如果可以下拉否则返回false
     */
    boolean canPullDown();
}
