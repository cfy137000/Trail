package com.fengyao.trail.util;

import java.util.Calendar;

/**
 * Created by Chen fengYao on 2015/9/11.
 * 有关时间的工具
 */
public class TimeUtil {
    static Calendar calendar = Calendar.getInstance();

    public static int getYear() {
        return calendar.get(Calendar.YEAR);
    }

    public static int getMonth() {
        return calendar.get(Calendar.MONTH) + 1;
    }

    public static int getDay() {
        return calendar.get(Calendar.DAY_OF_MONTH);
    }

    /**
     * 获取系统的小时
     *
     * @return 系统的小时(24小时制)
     */
    public static int getHour() {
        return calendar.get(Calendar.HOUR_OF_DAY);
    }

    public static int getMinute() {
        return calendar.get(Calendar.MINUTE);
    }

    public static int getSecond() {
        return calendar.get(Calendar.SECOND);
    }


}
