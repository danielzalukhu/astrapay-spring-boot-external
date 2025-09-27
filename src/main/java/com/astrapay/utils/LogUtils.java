package com.astrapay.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Timestamp;

public class LogUtils {
    private static final Logger log = LoggerFactory.getLogger(LogUtils.class);
    private static final String LOG_VER = "v1.0";

    public LogUtils() {
    }

    private static Timestamp getCurrentTimestamp() {
        return new Timestamp(System.currentTimeMillis());
    }


    public static void logInfo(String module, String logMessage) {
        log.info("{} | {} | {} | {} | {} | {} | {} | {}", new Object[]{getCurrentTimestamp(), "info", "astrapay", "log", module, logMessage});
    }

    public static void logEvent(String module, String eventType, String data) {
        log.info("{} | {} | {} | {} | {} | {} | {} | {}", new Object[]{getCurrentTimestamp(), "event", "astrapay", "log", module, eventType, data, "v1.0"});
    }

    public static void logError(String module, String logMessage) {
        log.info("{} | {} | {} | {} | {} | {} | {} | {}", new Object[]{getCurrentTimestamp(), "error", "astrapay", "log", module, logMessage});
    }

    public static void logWarning(String module, String logMessage) {
        log.info("{} | {} | {} | {} | {} | {} | {} | {}", new Object[]{getCurrentTimestamp(), "waring", "astarpay", "AppLog", module, logMessage});
    }
}
