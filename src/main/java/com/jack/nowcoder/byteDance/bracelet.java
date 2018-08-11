package com.jack.nowcoder.byteDance;

import java.util.*;

/**
 * Created by Jack on 8/9/2018 7:58 PM
 * 作为一个手串艺人，有金主向你订购了一条包含n个杂色串珠的手串-每个手串要么无色，要么
 * 涂上若干种颜色。为了使得手串的色彩看起来不那么单调，手串上的任意一种颜色(不包含无色)
 * 在任意连续的m个串珠里至多出现一次(手串为一个环形)。手串上的颜色一共有c种。现在按顺时针
 * 顺序告诉你n个串珠的手串上，每个串珠用所包含的颜色分别有哪些。请你判断该手串上有多少种
 * 颜色不符合要求，即询问有多少种颜色在任意连续m个串珠中出现了至少两次。
 * 输入描述：
 * 第一行输入n,m,c三个数，用空格隔开。(1<=n<=10000,1<=m<=1000,1<=c<=50)
 * 接下来n行每行的第一个数num_i(0<=num_i<=c)表示第i颗珠子有多少种颜色。接下来依次读入num_i
 * 个数字，每个数字x表示第i颗珠子上包含第x中颜色(1<=x<=c)
 * 输出描述：
 * 一个非负整数，表示该手链上有多少种颜色不符合需求。
 * 输入例子：
 * 5 2 3
 * 3 1 2 3
 * 0
 * 2 2 3
 * 1 2
 * 1 3
 * 输出例子：
 * 2
 * 样例说明：
 * 第一种颜色出现在第1颗串珠，与规则无冲突
 * 第二种颜色分别出现在第1,3,4颗串珠，第3颗与第4颗串珠相邻，所以不和要求。
 * 第三种颜色分别出现在第1,3,5颗串珠，第5颗串珠的下一个是第1颗，所以不合要求。
 * 总计有两种颜色的分布是有问题的。
 */
public class bracelet {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int c = sc.nextInt();
        Map<Integer,Set<Integer>> map = new HashMap<>();
        for (int i=0;i<n;i++) {
            int colorNum = sc.nextInt();
            Set<Integer> set = new HashSet<>();
            for (int j=0;j<colorNum;j++) {
                set.add(sc.nextInt());
            }
            if (set.isEmpty())
                set.add(-1);
            map.put(i,set);
            sc.nextLine();
        }
        for (int i=0;i<m-1;i++) {
            map.put(i+n,map.get(i));
        }
        Set<Integer> setRepeat = new HashSet<>();
        for (int i=0;i<n;i++) {
            Set<Integer> set1 = map.get(i);
            for (int j=1;j<m;j++) {
                Set<Integer> set2 = map.get(i+j);
                for (Integer element : set2) {
                    if (element != -1 && set1.contains(element))
                        setRepeat.add(element);
                }
            }
        }
        System.out.println(setRepeat.size());
    }
}
