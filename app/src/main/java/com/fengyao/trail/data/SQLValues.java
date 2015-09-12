package com.fengyao.trail.data;

/**
 * Created by Chen fengYao on 2015/9/3.
 * 用于数据库的一些常量
 */
public interface SQLValues {
    String DATA_BASE_NAME = "/trailData.db";//数据库的名称
    //表名
    String SETTING_USER_TABLE = "userTable";
    String SETTING_TOMATO_TABLE = "tomatoTable";
    String SETTING_NOTICE_TIME_TABLE = "noticeTimeTable";
    String REMIND_TABLE = "remindTable";
    String MISSION_TABLE = "missionTable";
    String GOAL_TABLE = "goalTable";
    String REMIND_BOX_TABLE = "remindBoxTable";
    String MISSION_BOX_TABLE = "missionBoxTable";
    String STATISTIC_TOMATO_TABLE = "statisticTomatoTable";
    String STATISTIC_REMIND_TABLE = "statisticRemindTable";
    String STATISTIC_MISSION_TABLE = "statisticMissionTable";

    //列名
    String COLUMN_SETTING_USER_NICK = "settingUserNick";
    String COLUMN_SETTING_USER_BIRTH = "settingUserBirth";
    String COLUMN_SETTING_USER_SEX = "settingUserSex";

    String COLUMN_SETTING_TOMATO_WORKTIME = "settingTomatoWorktime";
    String COLUMN_SETTING_TOMATO_BREAKTIME = "settingTomatoBreaktime";

    String COLUMN_SETTING_NOTICE_TIME_REMIND = "settingNoticeTimeRemind";
    String COLUMN_SETTING_NOTICE_TIME_MISSION_BEFOR = "settingNoticeTimeMissionBefor";
    String COLUMN_SETTING_NOTICE_TIME_MISSION_AFTER = "settingNoticeTimeMissionAfter";

    String COLUMN_REMIND_ID = "remindId";
    String COLUMN_REMIND_NAME = "remindName";
    String COLUMN_REMIND_TIME = "remindTime";
    String COLUMN_REMIND_NOTICE_TIME = "remindNoticeTime";
    String COLUMN_REMIND_BOX = "remindBox";
    String COLUMN_REMIND_PLACE = "remindPlace";

    String COLUMN_MISSION_ID = "missionId";
    String COLUMN_MISSION_NAME = "missionName";
    String COLUMN_MISSION_NOTICE_BEFOR = "missionNoticeBefor";
    String COLUMN_MISSION_NOTICE_AFTER = "missionNoticeAfter";
    String COLUMN_MISSION_BOX = "missionBox";
    String COLUMN_MISSION_FROM_YEAR = "missionFromYear";
    String COLUMN_MISSION_FROM_MOUNTN = "missionFromMounth";
    String COLUMN_MISSION_FROM_DAY = "missionFromDay";
    String COLUMN_MISSION_FROM_HOUR = "missionFromHour";
    String COLUMN_MISSION_FROM_MINUTE = "missionFromMinute";
    String COLUMN_MISSION_TO_YEAR = "missionToYear";
    String COLUMN_MISSION_TO_MOUNTN = "missionToMounth";
    String COLUMN_MISSION_TO_DAY = "missionToDay";
    String COLUMN_MISSION_TO_HOUR = "missionToHour";
    String COLUMN_MISSION_TO_MINUTE = "missionToMinute";

    String COLUMN_GOAL_ID = "goalId";
    String COLUMN_GOAL_NAME = "goalName";
    String COLUMN_GOAL_GOAL_TIME = "goalTime";
    String COLUMN_GOAL_FINISH_TIME = "finishTime";
    String COLUMN_GOAL_GIVE_UP_TIME = "giveUpTime";

    String COLUMN_REMIND_BOX_ID = "remindBoxId";
    String COLUMN_REMIND_BOX_NAME = "remindBoxName";
    String COLUMN_REMIND_BOX_REMINDS = "remindBoxReminds";

    String COLUMN_MISSION_BOX_ID = "missionBoxId";
    String COLUMN_MISSION_BOX_NAME = "missionBoxName";
    String COLUMN_MISSION_BOX_MISSIONS = "missionBoxReminds";

    String COLUMN_STATISTIC_TOMATO_ID = "statisticTomatoId";
    String COLUMN_STATISTIC_TOMATO_NAME = "statisticTomatoName";
    String COLUMN_STATISTIC_TOMATO_START_TIME = "statisticTomatoStartTime";
    String COLUMN_STATISTIC_TOMATO_FINISH_TIME = "statisticTomatoFinishTime";

    String COLUMN_STATISTIC_REMIND_ID = "statisticRemindId";
    String COLUMN_STATISTIC_REMIND_NAME = "statisticRemindName";
    String COLUMN_STATISTIC_REMIND_AIM_TIME = "statisticRemindAimTime";
    String COLUMN_STATISTIC_REMIND_FINISH_TIME = "statisticRemindFindishTime";

    String COLUMN_STATISTIC_MISSION_ID = "statisticMissionId";
    String COLUMN_STATISTIC_MISSION_NAME = "statisticMissionName";
    String COLUMN_STATISTIC_MISSION_AIM_TIME = "statisticMissionAimTime";
    String COLUMN_STATISTIC_MISSION_FINISH_TIME = "statisticMissionFinishTime";

}
