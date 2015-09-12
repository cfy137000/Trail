package com.fengyao.trail.data.beans;

/**
 * Created by Chen fengYao on 2015/9/10.
 * 用于携带番茄的一系列数据
 */
public class TomatoData {
    private String tomatoName;
    private String tomatoStartTime;
    private String tomatoFinishTime;

    public String getTomatoName() {
        return tomatoName;
    }

    public void setTomatoName(String tomatoName) {
        this.tomatoName = tomatoName;
    }

    public String getTomatoStartTime() {
        return tomatoStartTime;
    }

    public void setTomatoStartTime(String tomatoStartTime) {
        this.tomatoStartTime = tomatoStartTime;
    }

    public String getTomatoFinishTime() {
        return tomatoFinishTime;
    }

    public void setTomatoFinishTime(String tomatoFinishTime) {
        this.tomatoFinishTime = tomatoFinishTime;
    }
}
