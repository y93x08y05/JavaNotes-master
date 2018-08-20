package com.jack.basic.Other2;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by zhangta on 1/4/2018.
 */
public class hashCode {
    public  static  String location = " I'm in HP company at";
    public  static  String date;
    public static void main(String [] args){
        String format = "yyyy-MM-dd HH:mm:ss";
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        date = sdf.format(new Date());
        int dateHashCode = date.hashCode();
        System.out.println(date);
        System.out.println(dateHashCode);
    }
    /**
     * when println output  object will auto execute toString fun!
     * @return
     */
    @Override
    public  String toString(){
            return location+date;
    }
}
