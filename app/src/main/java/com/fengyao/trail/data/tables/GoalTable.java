package com.fengyao.trail.data.tables;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.fengyao.trail.base.BaseTable;
import com.fengyao.trail.data.SQLValues;
import com.fengyao.trail.data.beans.GoalData;
import com.fengyao.trail.util.MLogger;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Chen fengYao on 2015/9/9.
 * 人生目标表
 */
public class GoalTable extends BaseTable {
    private GoalTable goalTable;

    public GoalTable(SQLiteDatabase database) {
        super(database);
        mLogger = new MLogger(GoalTable.class);
        tableName = GOAL_TABLE;
    }


    @Override
    public void creat() {
        //人生目标
        String sqlRemindGoal = "create table " + GOAL_TABLE +
                "(_id integer primary key autoincrement," +
                COLUMN_GOAL_NAME + " varchar(255)," +
                COLUMN_GOAL_GOAL_TIME + " integer," +
                COLUMN_GOAL_FINISH_TIME + " varchar(255)," +
                COLUMN_GOAL_GIVE_UP_TIME + " varchar(255))";
        database.execSQL(sqlRemindGoal);
    }

    //加入一条目标
    public long insert(int age, String goalContext) {

        ContentValues values = new ContentValues();

        values.put(COLUMN_GOAL_GOAL_TIME, age);
        values.put(COLUMN_GOAL_NAME, goalContext);
        values.put(COLUMN_GOAL_FINISH_TIME, "-1");
        values.put(COLUMN_GOAL_GIVE_UP_TIME, "-1");

        Long id = database.insert(tableName, null, values);
        mLogger.info("已插入数据" + id);
        return id;
    }

    //更新完成时间
    public void upDataFinishTime(String goalContext) {
        //TODO 更新完成时间
    }

    //更新放弃时间
    public void upDataGiveUpTime(String goalContext) {
        //TODO 更新放弃时间
    }

    //返回人生目标数据
    public List<GoalData> getGoals() {
        List<GoalData> goalDatas = new ArrayList<>();
        Cursor cursor = database.query(tableName, null, null, null, null, null, null);
        if (cursor.moveToFirst()) {
            do {
                GoalData goalData = new GoalData();
                goalData.setGoalContext(cursor.getString(cursor.getColumnIndex(COLUMN_GOAL_NAME)));
                goalData.setAge(cursor.getInt(cursor.getColumnIndex(COLUMN_GOAL_GOAL_TIME)));
                goalData.setFinishTime(cursor.getString(cursor.getColumnIndex(COLUMN_GOAL_FINISH_TIME)));
                goalData.setGiveUpTime(cursor.getString(cursor.getColumnIndex(COLUMN_GOAL_GIVE_UP_TIME)));
                goalDatas.add(goalData);
            } while (cursor.moveToNext());
        }

        return goalDatas;
    }
}
