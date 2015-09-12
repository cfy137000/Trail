package com.fengyao.trail.data.tables;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.fengyao.trail.base.BaseTable;
import com.fengyao.trail.data.SQLValues;
import com.fengyao.trail.util.MLogger;

/**
 * Created by Chen fengYao on 2015/9/4.
 * 记录默认通知时间的表
 */
public class SettingNoticeTimeTable extends BaseTable implements SQLValues {
    int remind = 10, missionBefor = 10, missionAfter = 10;

    public SettingNoticeTimeTable(SQLiteDatabase database) {
        super(database);
        this.database = database;
        mLogger = new MLogger(SettingNoticeTimeTable.class);
        tableName = SETTING_NOTICE_TIME_TABLE;
        creat();
        if (queryUserCount() == 0) {//表里没有数据
            ContentValues values = new ContentValues();

            values.put(COLUMN_SETTING_NOTICE_TIME_REMIND, 10);
            values.put(COLUMN_SETTING_NOTICE_TIME_MISSION_BEFOR, 10);
            values.put(COLUMN_SETTING_NOTICE_TIME_MISSION_AFTER, 10);

            database.insert(tableName, null, values);
        }
    }

    @Override
    public void creat() {
        String sqlNoticeTimeSetting = "create table " + SETTING_NOTICE_TIME_TABLE +
                "(_id integer primary key autoincrement," +
                COLUMN_SETTING_NOTICE_TIME_REMIND + " integer," +
                COLUMN_SETTING_NOTICE_TIME_MISSION_BEFOR + " integer," +
                COLUMN_SETTING_NOTICE_TIME_MISSION_AFTER + " integer)";
        database.execSQL(sqlNoticeTimeSetting);
    }

    //获得提醒时间
    public int getSettingNoticeTimeRemind() {

        Cursor cursor = database.query(tableName, null, null, null, null, null, null);
        if (cursor.moveToFirst()) {
            do {
                remind = cursor.getInt(cursor.getColumnIndex(COLUMN_SETTING_NOTICE_TIME_REMIND));
                mLogger.info("从数据库返回的");
            } while (cursor.moveToNext());
        }
        return remind;
    }

    //获得通知_前提醒时间
    public int getSettingNoticeTimeMissionBefor() {
        Cursor cursor = database.query(tableName, null, null, null, null, null, null);
        if (cursor.moveToFirst()) {
            do {
                missionBefor = cursor.getInt(cursor.getColumnIndex(COLUMN_SETTING_NOTICE_TIME_MISSION_BEFOR));
            } while (cursor.moveToNext());

        }
        return missionBefor;
    }

    //获得通知_后提醒时间
    public int getSettingNoticeTimeAfter() {
        Cursor cursor = database.query(tableName, null, null, null, null, null, null);
        if (cursor.moveToFirst()) {
            do {
                missionAfter = cursor.getInt(cursor.getColumnIndex(COLUMN_SETTING_NOTICE_TIME_MISSION_AFTER));
            } while (cursor.moveToNext());

        }
        return missionAfter;
    }

    public void setRemind(int remind) {
        this.remind = remind;
        ContentValues values = new ContentValues();
        values.put(COLUMN_SETTING_NOTICE_TIME_REMIND, remind);
        database.update(tableName, values, null, null);
    }

    public void setMissionBefor(int missionBefor) {
        this.missionBefor = missionBefor;
        ContentValues values = new ContentValues();
        values.put(COLUMN_SETTING_NOTICE_TIME_MISSION_BEFOR, missionBefor);
        database.update(tableName, values, null, null);
    }

    public void setMissionAfter(int missionAfter) {
        this.missionAfter = missionAfter;
        ContentValues values = new ContentValues();
        values.put(COLUMN_SETTING_NOTICE_TIME_MISSION_AFTER, missionAfter);
        database.update(tableName, values, null, null);
    }
}
