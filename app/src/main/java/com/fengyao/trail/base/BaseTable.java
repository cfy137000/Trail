package com.fengyao.trail.base;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.fengyao.trail.data.SQLValues;
import com.fengyao.trail.util.MLogger;

/**
 * Created by Chen fengYao on 2015/9/4.
 * 所有表的基类
 */
public abstract class BaseTable implements SQLValues {
    public SQLiteDatabase database;
    public MLogger mLogger;
    public String tableName;

    public BaseTable(SQLiteDatabase database) {
        this.database = database;
    }

    public abstract void creat();

    //删除所有数据
    public void destoryAll() {
        database.delete(tableName, null, null);
        mLogger.info("已经删除全部数据");
    }

    //查询数据库中数据的条数
    public int queryUserCount() {
        if (tableName != null) {
            Cursor cursor = database.query(tableName, null, null, null, null, null, null);
            mLogger.info("数据库中有" + cursor.getCount() + "条数据");
            return cursor.getCount();//如何return 0;则没有该条数据

        }
        return 0;
    }

    //上一条写错了,很难改...
    public int queryDataCount() {
        Cursor cursor = database.query(tableName, null, null, null, null, null, null);
        mLogger.info("数据库中有" + cursor.getCount() + "条数据");
        return cursor.getCount();//如何return 0;则没有该条数据
    }
}
