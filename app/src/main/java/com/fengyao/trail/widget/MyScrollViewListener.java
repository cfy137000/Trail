package com.fengyao.trail.widget;

/**
 * Created by Chen fengYao on 2015/8/7.
 * 用于自定义滚动条的接口
 */
public interface MyScrollViewListener {

    void onScrollChanged(MyScrollView scrollView, int x, int y, int oldx, int oldy);

}