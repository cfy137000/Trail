package com.fengyao.trail.data.tables;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.fengyao.trail.base.BaseTable;
import com.fengyao.trail.data.beans.GoalData;
import com.fengyao.trail.data.beans.TomatoData;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Chen fengYao on 2015/9/10.
 */
public class StatisticTomatoTable extends BaseTable {

    public StatisticTomatoTable(SQLiteDatabase database) {
        super(database);
        tableName = STATISTIC_TOMATO_TABLE;
    }

    @Override
    public void creat() {
        String sqlStatisticTomato = "create table " + STATISTIC_TOMATO_TABLE +
                "(_id integer primary key autoincrement," +
                COLUMN_STATISTIC_TOMATO_NAME + " varchar(255)," +
                COLUMN_STATISTIC_TOMATO_START_TIME + " varchar(255)," +
                COLUMN_STATISTIC_TOMATO_FINISH_TIME + " varchar(255))";
        database.execSQL(sqlStatisticTomato);
    }

    //插入数据
    public long insert(TomatoData tomatoData) {

        ContentValues values = new ContentValues();

        values.put(COLUMN_STATISTIC_TOMATO_NAME, tomatoData.getTomatoName());
        values.put(COLUMN_STATISTIC_TOMATO_START_TIME, tomatoData.getTomatoStartTime());
        values.put(COLUMN_STATISTIC_TOMATO_FINISH_TIME, tomatoData.getTomatoFinishTime());

        Long id = database.insert(tableName, null, values);
        mLogger.info(tableName + "已插入数据" + id);

        return id;
    }

    public List<TomatoData> getTomatoDatas() {
        List<TomatoData> tomatoDatas = new ArrayList<>();
        Cursor cursor = database.query(tableName, null, null, null, null, null, null);
        if (cursor.moveToFirst()) {
            do {
                TomatoData tomatoData = new TomatoData();
                tomatoData.setTomatoName(cursor.getString(cursor.getColumnIndex(COLUMN_STATISTIC_TOMATO_NAME)));
                tomatoData.setTomatoStartTime(cursor.getString(cursor.getColumnIndex(COLUMN_STATISTIC_TOMATO_START_TIME)));
                tomatoData.setTomatoFinishTime(cursor.getString(cursor.getColumnIndex(COLUMN_STATISTIC_TOMATO_FINISH_TIME)));

                tomatoDatas.add(tomatoData);
            } while (cursor.moveToNext());
        }

        return tomatoDatas;
    }


}
