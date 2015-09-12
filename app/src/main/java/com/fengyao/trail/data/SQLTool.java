package com.fengyao.trail.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.fengyao.trail.base.BaseApplication;
import com.fengyao.trail.base.BaseTable;
import com.fengyao.trail.data.tables.GoalTable;
import com.fengyao.trail.data.tables.MissionTable;
import com.fengyao.trail.data.tables.SettingNoticeTimeTable;
import com.fengyao.trail.data.tables.SettingTomatoTable;
import com.fengyao.trail.data.tables.SettingUserTable;
import com.fengyao.trail.data.tables.StatisticTomatoTable;

import java.io.File;

/**
 * Created by Chen fengYao on 2015/9/3.
 * 数据库的工具类,用来创造各个子表
 */
public class SQLTool {
    private Context context;
    private SQLiteDatabase database;
    private TableName tableName;
    private static SQLTool sqlTool = new SQLTool();

    public enum TableName {
        settingUser,
        settingTomato,
        settingNoticeTime,
        goal,
        statisticTomato,
        mission
    }

    public SQLTool() {
        super();
        context = BaseApplication.getContext();
        init();
    }

    public static SQLTool getInstance() {

        return sqlTool;
    }


    //初始化数据库
    private void init() {
        File file = context.getFilesDir();
        String dbPath = file.getAbsolutePath() + DataBaseHelper.DATA_BASE_NAME;

        DataBaseHelper helper = new DataBaseHelper(context, dbPath, null, 1);

        database = helper.getWritableDatabase();
        Log.i("DataBase", "已初始化数据库");
    }

    public BaseTable tableFactory(TableName tableName) {

        switch (tableName) {
            case settingUser://个人中心表
                return new SettingUserTable(database);
            case settingTomato://番茄设置表
                return new SettingTomatoTable(database);
            case settingNoticeTime://通知时间表
                return new SettingNoticeTimeTable(database);
            case goal://人生目标
                return new GoalTable(database);
            case statisticTomato://番茄统计
                return new StatisticTomatoTable(database);
            case mission:
                return new MissionTable(database);

        }
        return null;

    }

}
