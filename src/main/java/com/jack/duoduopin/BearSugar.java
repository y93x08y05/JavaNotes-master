package com.jack.duoduopin;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Created by Jack on 8/5/2018 1:45 PM
 * 有n只小熊，他们有着各不相同的战斗力，每次他们吃糖时，会按照战斗力来排，战斗力高的小熊
 * 拥有优先选择权。前面的小熊吃饱了，后面的小熊才能吃。每只小熊有一个饥饿值，每次进食的时候，
 * 小熊们会选择最大的能填饱自己当前饥饿值的那颗糖来吃，可能吃完没饱会重复上述过程，但不会选择吃撑。
 * 仙子阿给出n只小熊的战斗力和饥饿值，并且给出m颗糖能填饱的饥饿值。
 * 求所有小熊进食完之后，每只小熊剩余的饥饿值。
 * 输入描述
 * 第一行两个正整数n和m，分别表示小熊数量和糖的数量。(n<=10,m<=100)
 * 第二行m个正整数，每个表示每颗糖能够填充的饥饿值
 * 接下来的n行，每行2个正整数，分别表示每只小熊的战斗力和当前的饥饿值
 * 题目中所有输入的数值小于等于100
 * 输出描述
 * 输出n行，每行一个整数，代表每只小熊剩余的饥饿值。
 * 输入例子：
 * 2 5
 * 5 6 10 20 30
 * 4 34
 * 3 35
 * 输出例子：
 * 4
 * 0
 * 说明：第一只小熊吃了第5颗糖
 * 第二只小熊吃了第4颗糖
 * 第二只小熊吃了第3颗糖
 * 第二只小熊吃了第1颗糖
 */
public class BearSugar {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int [] sugar = new int[m];
        for (int i=0;i<m;i++) {
            sugar[i] = sc.nextInt();
        }
        int [][] bear = new int[n][2];
        for (int i=0;i<n;i++) {
            bear[i][0] = sc.nextInt();
            bear[i][1] = sc.nextInt();
        }
        int [][] bear2 = bear.clone();
        Arrays.sort(sugar);
        Arrays.sort(bear, Comparator.comparingInt((int[] a) -> a[0]));
        for (int i=n-1;i>=0;i--) {
            for (int j=m-1;j>=0;j--) {
                if (bear[i][1] >= sugar[j]) {
                    bear[i][1] -= sugar[j];
                    sugar[j] = 0;
                }
                if (bear[i][1] == 0)
                    break;
            }
        }
        for (int i=0;i<n;i++) {
            for (int j=0;j<n;j++) {
                if (bear[j][0] == bear2[i][0])
                    System.out.println(bear[j][1]);
            }
        }
    }
}
