package com.jack.train;

/**
 * @Author: Jack
 * @Date: 2018/10/18 14:39
 * 给定1-n，一共n个连续的正整数，然后在文件中存储n+1个数，取值范围在1-n闭区间中
 * 其中只有一个重复出现一次，找出重复出现的该数。
 * 等差数列{an}的通项公式为：an=a1+(n-1)d。
 * 前n项和公式为：Sn=n*a1+n(n-1)d/2或Sn=n(a1+an)/2。
 * 注意： 以上n均属于正整数。
 */
public class Main7 {
    public static void main(String[] args) {
        int a[] = {1,2,3,4,5,6,6,7,8};
        int zs  = 0;
        int all = 0;
        int chongfu;
        for (int i = 0; i < a.length-1; i++) {
            zs += a[i];
            System.out.println("运行次数 " + i);
            System.out.println("ZS " + zs);
            System.out.println("......");
            all += (i + 1);
            System.out.println("ALL" + all);
        }
        zs += a[a.length-1];
        chongfu = zs - all;
        System.out.println("chongfu " + chongfu);
    }
}