package com.jack.nowcoder.spring.MeiTuan.CodeM2017.second;

import java.util.Scanner;

/**
 * 美团外卖的品牌代言人袋鼠先生最近正在进行音乐研究，两段音频，每段音频是一个
 * 表示音高的序列，现在袋鼠先生想要在第二段音频中找出与第一段音频最相近的部分
 * 具体说，就是在第二段音频中找到一个长度和第一段音频相等且是连续的子序列，使得
 * 他们的difference最小，两段等长音频的difference定义为：
 * difference=SUM(a[i]-b[i])(a[i]-b[i])(1<=i<=n)，其中SUM表示求和。
 * 其中n表示序列长度，a[i]，b[i]分别表示两段音频的音高。现在袋鼠先生想知道
 * difference的最小值是多少，数据保证第一段音频的长度小于等于第二段音频的长度。
 * 输入描述：
 * 第一行一个整数n(1<=n<=1000)，表示第一段音频的长度。
 * 第二行n个整数表示第一段音频的音高(0<=音高<=1000)。
 * 第三行一个整数m(1<=n<=m<=1000)，表示第二段音频的长度。
 * 第四行m个整数表示第一段音频的音高(0<=音高<=1000)。
 * 输出描述：
 * 输出difference的最小值
 * 例子：
 * 输入：
 * 2
 * 1 2
 * 4
 * 3 1 2 4
 * 输出
 * 0
 */
public class P2 {
    public static void main(String [] args) {
        Scanner scanner = new Scanner(System.in);
        int a1 = scanner.nextInt();
        int [] a11 = new int[a1];
        for (int i=0;i<a1;i++) {
            a11[i] = scanner.nextInt();
        }
        int a2 = scanner.nextInt();
        int [] a12 = new int[a2];
        for (int i=0;i<a2;i++) {
            a12[i] = scanner.nextInt();
        }
        System.out.println(getMinDiff(a1, a2, a11, a12));
    }
    public static int getMinDiff(int a1, int a2, int [] a11,int [] a12){
        int min = Integer.MAX_VALUE;
        for (int i=0;i+a1<a2;i++) {
            int temp = getDiff(i, a1, a11,a12);
            min = min<temp?min:temp;
        }
        return min;
    }
    public static int getDiff(int i, int a1, int [] a11,int [] a12) {
        int diff = 0;
        for (int j=0;j<a1;j++) {
            diff += (a11[j]-a12[j+i])*(a11[j]-a12[j+i]);
        }
        return diff;
    }
}