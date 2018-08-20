package com.jack.nowcoder.spring.campus2017;

import java.util.Scanner;

/**
 * Created by zhangta on 3/12/2018.
 * 酒店房间的价格录入是通过时间段来录入的，比如10月1日至10月7日800元，10月8日至10月20日500元，
 * 请实现以下函数int[][] merge(int[][] dateRangePrices)，输入是某个酒店多个日期段的价格，
 * 每个日期段（终止日期大于等于起始日期）和对应的价格使用长度为3的数组来表示，
 * 比如[0, 19, 300], [10, 40, 250]分别表示从某天开始第1天到第20天价格都是300，
 * 第11天到第41天价格都是250，这些日期端有可能重复，重复的日期的价格以后面的为准，
 * 请以以下规则合并并输出合并结果：
 * 1.相邻两天的价格如果相同，那么这两个日期段应该合并
 * 2.合并的结果应该以起始日期从小到大排序
 * 输入数据包括多行，输出数据只有一行
 * 输入
 * 1 1 100
 * 2 3 100
 * 4 5 110
 * 输出
 * [1, 3, 100],[4, 5, 110]
 */
public class hotel {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int a[] = new int[100000];
        int maxDay=Integer.MIN_VALUE;
        while (in.hasNext()) {
            String str = in.nextLine();
            String s[] = str.split(" ");
            int begin = Integer.parseInt(s[0]);
            int end = Integer.parseInt(s[1]);
            int money = Integer.parseInt(s[2]);
            for (int i = begin; i <= end; i++) {
                a[i] = money;
            }
            maxDay=Math.max(end,maxDay);
        }
        int begin=-1;
        for(int i=0;i<=maxDay;i++){
            if(a[i]!=0){
                if(begin==-1){
                    begin=i;
                }
                if(a[i]!=a[i+1]){
                    if(i==maxDay){
                        System.out.print("["+begin+", "+i+", "+a[i]+"]");
                    }else {
                        System.out.print("[" + begin + ", " + i + ", " + a[i] + "],");
                    }
                    begin=-1;
                }
            }
        }
    }
}
