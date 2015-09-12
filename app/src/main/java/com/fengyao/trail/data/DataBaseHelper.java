package com.fengyao.trail.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.fengyao.trail.data.tables.GoalTable;
import com.fengyao.trail.data.tables.SettingNoticeTimeTable;
import com.fengyao.trail.data.tables.SettingTomatoTable;
import com.fengyao.trail.data.tables.SettingUserTable;
import com.fengyao.trail.data.tables.StatisticTomatoTable;

/**
 * Created by Chen fengYao on 2015/9/3.
 * 用来创建,初始化数据库
 */
public class DataBaseHelper extends SQLiteOpenHelper implements SQLValues {

    public DataBaseHelper(Context context, String name,
                          SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    //创建数据库
    @Override
    public void onCreate(SQLiteDatabase db) {
        //个人信息
        String sqlUser = "create table " + SETTING_USER_TABLE +
                "(_id integer primary key autoincrement," +
                COLUMN_SETTING_USER_NICK + " varchar(255)," +
                COLUMN_SETTING_USER_BIRTH + " varchar(255)," +
                COLUMN_SETTING_USER_SEX + " varchar(255))";
        db.execSQL(sqlUser);

        //番茄设置
        String sqlTomatoSetting = "create table " + SETTING_TOMATO_TABLE +
                "(_id integer primary key autoincrement," +
                COLUMN_SETTING_TOMATO_WORKTIME + " integer," +
                COLUMN_SETTING_TOMATO_BREAKTIME + " integer)";
        db.execSQL(sqlTomatoSetting);

        //通知时间设置
        String sqlNoticeTimeSetting = "create table " + SETTING_NOTICE_TIME_TABLE +
                "(_id integer primary key autoincrement," +
                COLUMN_SETTING_NOTICE_TIME_REMIND + " integer," +
                COLUMN_SETTING_NOTICE_TIME_MISSION_BEFOR + " integer," +
                COLUMN_SETTING_NOTICE_TIME_MISSION_AFTER + " integer)";
        db.execSQL(sqlNoticeTimeSetting);

        //提醒
        String sqlRemindSetting = "create table " + REMIND_TABLE +
                "(_id integer primary key autoincrement," +
                COLUMN_REMIND_NAME + " varchar(255)," +
                COLUMN_REMIND_TIME + " varchar(255)," +
                COLUMN_REMIND_NOTICE_TIME + " varchar(255)," +
                COLUMN_REMIND_BOX + " varchar(255)," +
                COLUMN_REMIND_PLACE + " varchar(255))";
        db.execSQL(sqlRemindSetting);

        //任务
        String sqlRemindMission = "create table " + MISSION_TABLE +
                "(_id integer primary key autoincrement," +
                COLUMN_MISSION_NAME + " varchar(255)," +
                COLUMN_MISSION_NOTICE_BEFOR + " varchar(255)," +
                COLUMN_MISSION_NOTICE_AFTER + " varchar(255)," +
                COLUMN_MISSION_FROM_YEAR + " integer," +
                COLUMN_MISSION_FROM_MOUNTN + " integer," +
                COLUMN_MISSION_FROM_DAY + " integer," +
                COLUMN_MISSION_FROM_HOUR + " integer," +
                COLUMN_MISSION_FROM_MINUTE + " integer," +
                COLUMN_MISSION_TO_YEAR + " integer," +
                COLUMN_MISSION_TO_MOUNTN + " integer," +
                COLUMN_MISSION_TO_DAY + " integer," +
                COLUMN_MISSION_TO_HOUR + " integer," +
                COLUMN_MISSION_TO_MINUTE + " integer," +
                COLUMN_MISSION_BOX + " varchar(255))";
        db.execSQL(sqlRemindMission);


//人生目标
        String sqlRemindGoal = "create table " + GOAL_TABLE +
                "(_id integer primary key autoincrement," +
                COLUMN_GOAL_NAME + " varchar(255)," +
                COLUMN_GOAL_GOAL_TIME + " integer," +
                COLUMN_GOAL_FINISH_TIME + " varchar(255)," +
                COLUMN_GOAL_GIVE_UP_TIME + " varchar(255))";
        db.execSQL(sqlRemindGoal);

        //提醒箱
        String sqlRemindBox = "create table " + REMIND_BOX_TABLE +
                "(_id integer primary key autoincrement," +
                COLUMN_REMIND_BOX_NAME + " varchar(255)," +
                COLUMN_REMIND_BOX_REMINDS + " varchar(255))";
        db.execSQL(sqlRemindBox);

        //任务箱
        String sqlMissionBox = "create table " + MISSION_BOX_TABLE +
                "(_id integer primary key autoincrement," +
                COLUMN_MISSION_BOX_NAME + " varchar(255)," +
                COLUMN_MISSION_BOX_MISSIONS + " varchar(255))";
        db.execSQL(sqlMissionBox);

        //番茄统计
        StatisticTomatoTable statisticTomatoTable = new StatisticTomatoTable(db);
        statisticTomatoTable.creat();

        //提醒统计
        String sqlStatisticRemind = "create table " + STATISTIC_REMIND_TABLE +
                "(_id integer primary key autoincrement," +
                COLUMN_STATISTIC_REMIND_NAME + " varchar(255)," +
                COLUMN_STATISTIC_REMIND_AIM_TIME + " varchar(255)," +
                COLUMN_STATISTIC_REMIND_FINISH_TIME + " varchar(255))";
        db.execSQL(sqlStatisticRemind);

        //任务统计
        String sqlStatisticMission = "create table " + STATISTIC_MISSION_TABLE +
                "(_id integer primary key autoincrement," +
                COLUMN_STATISTIC_MISSION_NAME + " varchar(255)," +
                COLUMN_STATISTIC_MISSION_AIM_TIME + " varchar(255)," +
                COLUMN_STATISTIC_MISSION_FINISH_TIME + " varchar(255))";
        db.execSQL(sqlStatisticMission);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
