package com.jack.nowcoder.spring.HUAWEI;

/**
 *  13号恰好是星期五的几率比出现在其他周日的几率大吗
 *  写一个程序计算13日出现在某个星期的次数（在给定的N年时间中）
 *  时间段为1900年1月1日到1900+N-1年12月31日
 *  N为非负整数，不超过400，（1900年1月1日是星期一）
 *  输入描述：1 0
 *  第一个参数是years，表示距离1900年1月1日的年数
 *  第二个参数是weeks，表示星期数（分别用0-6表示星期日到星期六）
 *  输出描述：
 *  13日出现在星期数为weeks的次数，若异常失败则输出-1
 *  输入1 0时，输出为1
 */

import java.util.Scanner;

public class SpringJava2 {
    static int [] day = {12,31,28,31,30,31,30,31,31,30,31,30};
    public static void main(String [] args){
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        if (c > 0){
            System.out.println(c);
        }else{
            System.out.println(-1);
        }
    }
    private static int Result(int years,int weeks){
        int count = 0;
        int days = 0;
        try {
            if (weeks <= 6 && weeks >= 0 && years >= 0 && years <= 400){
                for (int i=1900;i<1900+years;i++){
                    days += i==1900?0:(run(i-1)?366:365);
                    int day = days;
                    for (int j=1;j<=12;j++){
                        days += getDay(i,j);
                        if ((days-(weeks-1)%7==0)){
                            count++;
                        }
                    }
                    days = day;
                }
                if (weeks < 0 || weeks > 6 || years < 0 || years > 400){
                    return -1;
                }
            }
        }
        catch (Exception e){
            return -1;
        }
        return count;
    }
    private static int getDay(int i,int j){
        if (!run(i)){
            return day[j-1];
        }
        return j==3?29:day[j-1];
    }
    private static boolean run(int i){
        return (i % 4 == 0 && i % 100 != 0)|| i % 400 == 0;
    }
}