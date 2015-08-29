package com.fengyao.trail.util;

/**
 * Created by Chen fengYao on 2015/8/27.
 * 一个单例模式的Values,用来记录一些公共类需要用到的值
 */
public class Values {
    private Values(){
    }
    private static Values values = new Values();

    public static Values getValues(){
        return values;
    }


    private int toolBarColor = 0xFF607D8B;//默认的主题颜色

    public int getToolBarColor() {
        return toolBarColor;
    }

    public void setToolBarColor(int toolBarColor) {
        this.toolBarColor = toolBarColor;
    }
}
