package com.jack.designMode.create.Singleton2018;

import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Properties;

public class LogManager2018 {
    public static final String DefalutLogFilePathName = "d:\\love.log";
    private static LogManager2018 logManager2018;
    private static InputStream inputStream;
    private static Properties properties;
    private static PrintWriter printWriter;
    private static String logFileName;
    private LogManager2018(){
        outInit();
    }
    public static synchronized void log(String message){
        if (logManager2018 == null || printWriter == null){
            logManager2018 = new LogManager2018();
        }
    }
    public static synchronized void log(Exception e){
        if (logManager2018 == null || printWriter == null){
            logManager2018 = new LogManager2018();
        }
        if (printWriter != null){
            printWriter.println(new java.util.Date() + ": ");
            e.printStackTrace(printWriter);
        }
    }
    private void outInit(){
        if (logFileName == null){
            logFileName = getLogFileName();
            try {
                if (printWriter == null){
                    printWriter = new PrintWriter(new FileWriter(logFileName,true),true);
                }
            }
            catch (IOException e){
                System.out.println("无法打开日志文件" + logFileName);
                e.printStackTrace();
                printWriter = null;
            }
        }
    }
    public void destroy(){
        try {
            this.logManager2018 = null;
            if (printWriter != null){
                this.printWriter.close();
            }
            if (inputStream != null){
                this.inputStream.close();
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    private String getLogFileName() {
        try {
            if (properties == null){
                properties = new Properties();
                inputStream = getClass().getResourceAsStream("log.properties");
                properties.load(inputStream);
                inputStream.close();
            }
        }
        catch (IOException e){
            System.out.println("无法打开属性配置文件:log.properties");
            e.printStackTrace();
        }
        return properties.getProperty("logfile",DefalutLogFilePathName);
    }
}