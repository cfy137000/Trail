package com.fengyao.trail.data.tables;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

import com.fengyao.trail.base.BaseTable;
import com.fengyao.trail.data.beans.MissionData;

/**
 * Created by Chen fengYao on 2015/9/10.
 * 记录任务信息的表
 */
public class MissionTable extends BaseTable {
    public MissionTable(SQLiteDatabase database) {
        super(database);
    }

    @Override
    public void creat() {

    }

    //插入一条任务数据
    public long insertMission(MissionData missionData) {
        ContentValues values = new ContentValues();

        values.put(COLUMN_MISSION_NAME, missionData.getName());
        values.put(COLUMN_MISSION_NOTICE_BEFOR, missionData.getMissionNoticeBeror());
        values.put(COLUMN_MISSION_NOTICE_AFTER, missionData.getMissionNoticeAfter());
        values.put(COLUMN_MISSION_BOX, missionData.getMissionBox());
        values.put(COLUMN_MISSION_FROM_YEAR, missionData.getMissionFromYear());
        values.put(COLUMN_MISSION_FROM_MOUNTN, missionData.getMissionFromMounth());
        values.put(COLUMN_MISSION_FROM_DAY, missionData.getMissionFromDay());
        values.put(COLUMN_MISSION_FROM_HOUR, missionData.getMissionFromHour());
        values.put(COLUMN_MISSION_FROM_MINUTE, missionData.getMissionFromMinute());
        values.put(COLUMN_MISSION_TO_YEAR, missionData.getMissionToYear());
        values.put(COLUMN_MISSION_TO_MOUNTN, missionData.getMissionToMounth());
        values.put(COLUMN_MISSION_TO_DAY, missionData.getMissionToDay());
        values.put(COLUMN_MISSION_TO_HOUR, missionData.getMissionToHour());
        values.put(COLUMN_MISSION_TO_MINUTE, missionData.getMissionToMinute());

        Long id = database.insert(tableName, null, values);
        mLogger.info("已插入数据" + id);
        return id;
    }


}
