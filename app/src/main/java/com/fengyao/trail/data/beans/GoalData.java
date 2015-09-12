package com.fengyao.trail.data.beans;

/**
 * Created by Chen fengYao on 2015/9/9.
 * 携带着人生目标的数据
 */
public class GoalData {
    private String goalContext;
    private int age;
    private String finishTime;
    private String giveUpTime;
    private boolean isDone;

    public boolean isDone() {
        return isDone;
    }

    public void setIsDone(boolean isDone) {
        this.isDone = isDone;
    }

    public String getGoalContext() {
        return goalContext;
    }

    public void setGoalContext(String goalContext) {
        this.goalContext = goalContext;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(String finishTime) {
        this.finishTime = finishTime;
    }

    public String getGiveUpTime() {
        return giveUpTime;
    }

    public void setGiveUpTime(String giveUpTime) {
        this.giveUpTime = giveUpTime;
    }
}
