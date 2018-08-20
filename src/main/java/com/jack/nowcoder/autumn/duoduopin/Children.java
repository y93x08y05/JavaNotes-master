package com.jack.nowcoder.autumn.duoduopin;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Jack on 8/4/2018 6:52 PM
 * 六一儿童节，老师带了很多好吃的巧克力到幼儿园，每块巧克力的重量为w[j]，对于每个小朋友i，
 * 当他分到的巧克力大小达到h[i](w[j]>=h[i])，他才会上去表演节目。老师的目标是将巧克力
 * 分发给孩子们，使得最多的小孩上台表演。可以保证每个w[i]>0且不能将多块巧克力分给一个孩子
 * 或者将一块巧克力分给多个孩子。
 * 输入描述：
 * 第一行：n表示h数组元素个数
 * 第二行：n个h数组元素
 * 第三行：m表示w数组元素个数
 * 第四行：m个w数组元素
 * 输出描述：
 * 上台表演学生人数
 * 输入例子
 * 3
 * 2 2 3
 * 2
 * 3 1
 * 输出例子
 * 1
 */
public class Children {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] h = new int[n];
        for (int i=0;i<n;i++) {
            h[i] = sc.nextInt();
        }
        int m = sc.nextInt();
        int [] w = new int[m];
        for (int i=0;i<m;i++) {
            w[i] = sc.nextInt();
        }
        Arrays.sort(h);
        Arrays.sort(w);
        int count = 0;
        for (int i=0,j=0;i<h.length && j<w.length;j++) {
            if (h[i] <= w[j]) {
                i++;
                count++;
            }
        }
        System.out.println(count);
    }
}
