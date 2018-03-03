package com.peterfarber;

import org.apache.log4j.Logger;
import sun.rmi.runtime.Log;

public class LoggingUtil {

    private static Logger log  = Logger.getRootLogger();

    public static void logFatal(String s){
        log.fatal(s);
    }

    public static void logError(String s){
        log.error(s);
    }

    public static void logWarn(String s){
        log.warn(s);
    }

    public static void logDebug(String s){
        log.debug(s);
    }

    public static void logInfo(String s){
        log.info(s);
    }

}
