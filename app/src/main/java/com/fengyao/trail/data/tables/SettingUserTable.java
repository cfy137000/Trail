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
 * Created by Chen fengYao on 2015/9/3.
 * 用于用户信息的数据库工具
 */
public class SettingUserTable extends BaseTable implements SQLValues {

    public SettingUserTable(SQLiteDatabase database) {
        super(database);
        mLogger = new MLogger(SettingUserTable.class);
        tableName = SETTING_USER_TABLE;
    }

    @Override
    public void creat() {
        String sqlUser = "create table " + SETTING_USER_TABLE +
                "(_id integer primary key autoincrement," +
                COLUMN_SETTING_USER_NICK + " varchar(255)," +
                COLUMN_SETTING_USER_BIRTH + " varchar(255)," +
                COLUMN_SETTING_USER_SEX + " varchar(255))";
        database.execSQL(sqlUser);
    }


    //插入数据,会覆盖以前的数据
    public long insert(String nickName, String birthday, String sex) {

        destoryAll();
        ContentValues values = new ContentValues();

        values.put(COLUMN_SETTING_USER_NICK, nickName);
        values.put(COLUMN_SETTING_USER_BIRTH, birthday);
        values.put(COLUMN_SETTING_USER_SEX, sex);

        Long id = database.insert(SETTING_USER_TABLE, null, values);
        mLogger.info("已插入数据" + id);

        return id;
    }

    public void upDataUserNickName(String nickName) {
        if (queryUserCount() == 0) {
            insert("默认昵称", "1992-06-23", "男");
        }
        ContentValues values = new ContentValues();
        values.put(COLUMN_SETTING_USER_NICK, nickName);
        database.update(SETTING_USER_TABLE, values, null, null);
    }

    public void upDataUserBirthday(String birthday) {
        if (queryUserCount() == 0) {
            insert("默认昵称", "1992-06-23", "男");
        }
        ContentValues values = new ContentValues();
        values.put(COLUMN_SETTING_USER_BIRTH, birthday);
        database.update(SETTING_USER_TABLE, values, null, null);
    }

    public void upDataUserSex(String sex) {
        if (queryUserCount() == 0) {
            insert("默认昵称", "1992-06-23", "男");
        }
        ContentValues values = new ContentValues();
        values.put(COLUMN_SETTING_USER_SEX, sex);
        database.update(SETTING_USER_TABLE, values, null, null);
    }

    //返回用户信息
    public List<String> qureUser() {
        List<String> result = new ArrayList<String>();
        if (queryUserCount() != 0) {
            String sql = "select * from " + SETTING_USER_TABLE;
            Cursor cursor = database.rawQuery(sql, null);
            // cursor.moveToFirst();
            while (cursor.moveToNext()) {

                int nickNameIndex = cursor.getColumnIndex(COLUMN_SETTING_USER_NICK);
                int nickNameType = cursor.getType(nickNameIndex);
                if (nickNameType == Cursor.FIELD_TYPE_STRING) {
                    result.add(cursor.getString(nickNameIndex));
                }

                int birthdayIndex = cursor.getColumnIndex(COLUMN_SETTING_USER_BIRTH);
                mLogger.info("birthday:" + birthdayIndex);
                int birthdayType = cursor.getType(birthdayIndex);
                if (birthdayType == Cursor.FIELD_TYPE_STRING) {
                    result.add(cursor.getString(birthdayIndex));
                }

                int sexIndex = cursor.getColumnIndex(COLUMN_SETTING_USER_SEX);
                int sexType = cursor.getType(sexIndex);
                if (sexType == Cursor.FIELD_TYPE_STRING) {
                    result.add(cursor.getString(sexIndex));
                }

            }
        } else {
            insert("默认昵称", "1992-06-23", "男");
            result = qureUser();
        }
        mLogger.info("从数据库返回" + result.get(0) + "的个人信息");
        return result;
    }


}
