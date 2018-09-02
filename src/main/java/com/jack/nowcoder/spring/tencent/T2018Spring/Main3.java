package com.jack.nowcoder.spring.tencent.T2018Spring;

import java.util.Scanner;

/**
 * Created by Jack on 9/1/2018 9:42 AM
 * 小Q的父母要出差N天，走之前给小Q留下了M块巧克力。小Q决定每天吃的
 * 巧克力数量不少于前一天吃的一半，但是他又不想在父母没有回来之前的
 * 某一天没有巧克力吃，请问他第一天最多能吃多少块巧克力。
 * 输入描述；
 * 每个输入包含一个测试用例
 * 每个测试用例的第一行包含两个正整数，表示父母出差的天数N和巧克力的
 * 数量M
 * 输出描述：
 * 输出一个数，表示小Q第一天最多能吃多少块巧克力
 * 输入例子：
 * 3 7
 * 输出例子：
 * 4
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        int M=sc.nextInt();
        int low=1;
        int high=M;
        while (low<high) {
            int mid=(low+high+1)>>1;
            int need=findMaxEat(N,mid);
            if (need>M) {
                high=mid-1;
            } else if (need==M) {
                high=mid;
                break;
            } else {
                low=mid;
            }
        }
        System.out.println(high);
    }
    private static int findMaxEat(int n,int mid) {
        int need=0;
        for (int i=0;i<n;i++) {
            need+=mid;
            mid=(mid+1)>>1;
        }
        return need;
    }
}
