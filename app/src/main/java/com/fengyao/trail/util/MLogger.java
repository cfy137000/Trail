package com.fengyao.trail.util;

import android.content.Context;

import com.google.code.microlog4android.Logger;
import com.google.code.microlog4android.LoggerFactory;
import com.google.code.microlog4android.config.PropertyConfigurator;

/**
 * Created by Chen fengYao on 2015/7/29.
 * 用于日志的打印
 */
public class MLogger {

    private Logger logger;

    public MLogger(Class<?> clas) {
        logger = LoggerFactory.getLogger(clas);
    }

    public static void init(Context context) {
        PropertyConfigurator.getConfigurator(context).configure();
    }

    public void debug(String message) {
        logger.debug(message);
    }

    public void info(String message) {
        logger.info(message);
    }

    public void warn(String message) {
        logger.warn(message);
    }

    public void error(String message) {
        logger.error(message);
    }
}
