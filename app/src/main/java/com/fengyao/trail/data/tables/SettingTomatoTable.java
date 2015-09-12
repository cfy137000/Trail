package com.fengyao.trail.data.tables;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.fengyao.trail.base.BaseTable;
import com.fengyao.trail.data.SQLValues;
import com.fengyao.trail.util.MLogger;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Chen fengYao on 2015/9/4.
 * 用于记录番茄时钟的设置表
 */
public class SettingTomatoTable extends BaseTable implements SQLValues {

    public SettingTomatoTable(SQLiteDatabase database) {
        super(database);
        mLogger = new MLogger(SettingTomatoTable.class);
        tableName = SETTING_TOMATO_TABLE;
    }

    @Override
    public void creat() {
        String sqlTomatoSetting = "create table " + SETTING_TOMATO_TABLE +
                "(_id integer primary key autoincrement," +
                COLUMN_SETTING_TOMATO_WORKTIME + " integer," +
                COLUMN_SETTING_TOMATO_BREAKTIME + " integer)";
        database.execSQL(sqlTomatoSetting);
    }

    //更新休息时间的设置
    public void upDataTomatoBreakTime(int time) {
        ContentValues values = new ContentValues();
        values.put(COLUMN_SETTING_TOMATO_BREAKTIME, time);
        database.update(tableName, values, null, null);
    }

    //更新工作时间的设置
    public void upDataTomatoWorkTime(int time) {
        ContentValues values = new ContentValues();
        values.put(COLUMN_SETTING_TOMATO_WORKTIME, time);
        database.update(tableName, values, null, null);
    }

    //返回番茄信息
    public List<Integer> qureSettingTomato() {
        List<Integer> result = new ArrayList<Integer>();
        if (queryUserCount() != 0) {
            String sql = "select * from " + tableName;
            Cursor cursor = database.rawQuery(sql, null);

            while (cursor.moveToNext()) {

                int breakTimeIndex = cursor.getColumnIndex(COLUMN_SETTING_TOMATO_BREAKTIME);
                int breakTimeType = cursor.getType(breakTimeIndex);
                if (breakTimeType == Cursor.FIELD_TYPE_INTEGER) {
                    result.add(cursor.getInt(breakTimeIndex));
                }

                int workTimeIndex = cursor.getColumnIndex(COLUMN_SETTING_TOMATO_WORKTIME);
                mLogger.info("workTime:" + workTimeIndex);
                int workTimeType = cursor.getType(workTimeIndex);
                if (workTimeType == Cursor.FIELD_TYPE_INTEGER) {
                    result.add(cursor.getInt(workTimeIndex));
                }
            }
        } else {//数据库是空的

            ContentValues values = new ContentValues();

            values.put(COLUMN_SETTING_TOMATO_BREAKTIME, 10);
            values.put(COLUMN_SETTING_TOMATO_WORKTIME, 25);

            Long id = database.insert(tableName, null, values);
            mLogger.info("已插入数据" + id);
            result.add(10);
            result.add(25);
        }
        mLogger.info("从数据库返回番茄时钟设置");
        return result;
    }


}
