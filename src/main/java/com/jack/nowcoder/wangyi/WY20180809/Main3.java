package com.jack.nowcoder.wangyi.WY20180809;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by Jack on 8/11/2018 11:13 AM
 * 时间区间问题
 */
public class Main3 {
    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);
        HashMap<Integer,List<String>> map = new HashMap<>();
        int T = sc.nextInt();
        for (int i=0;i<T;i++) {
            int K = sc.nextInt();
            for (int j=0;j<K;j++) {
                int W = sc.nextInt();
                int M = sc.nextInt();
                for (int k=0;k<M;k++) {
                    String time = sc.next();
                    if (map.containsKey(W)) {
                        map.put(W,new ArrayList<>());
                        map.get(W).add(time);
                    } else
                        map.get(W).add(time);
                }
            }
            int C = sc.nextInt();
            String [][] s = new String[C][2];
            for (int w=0;w<C;w++) {
                s[w][0] = sc.next();
                s[w][1] = sc.next();
            }
            for (int w=0;w<C;w++)
                System.out.println(nextTime(map,Integer.parseInt(s[w][0]),s[w][1]));
        }
    }
    private static long nextTime(HashMap<Integer,List<String>> map,int day,String now) throws ParseException {
        long wait = Long.MAX_VALUE;
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        Date nowTime = sdf.parse(now);
        List<String> times = new ArrayList<>();
        int newDay = 0;
        if (map.containsKey(day))
            times = map.get(day);
        else {
            for (int i=1;i<7;i++) {
                if (map.containsKey((day+i)%7)) {
                    times = map.get((day+i)%7);
                    newDay = day + i;
                }
            }
            for (String time : times) {
                String [] s = time.split("-");
                Date begin = sdf.parse(s[0]);
                Date end = sdf.parse(s[1]);
                int days = newDay - day;
                if (nowTime.after(begin)&&nowTime.before(end)) {
                    long interval = (nowTime.getTime()-begin.getTime())/1000;
                    if (day == newDay) {
                        wait = 0;
                        return wait;
                    } else {
                        wait = Math.min(wait,days*24*60*60-interval);
                    }
                } else if (nowTime.before(begin)) {
                    long interval = (begin.getTime()-nowTime.getTime())/1000;
                    wait = Math.min(wait,days*24*60*60+interval);
                } else {
                    long interval = (nowTime.getTime()-begin.getTime())/1000;
                    wait = Math.min(wait,days*24*60*60+interval);
                }
            }
        }
        return wait;
    }
}
