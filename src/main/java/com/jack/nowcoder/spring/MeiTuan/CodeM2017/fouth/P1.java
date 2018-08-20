package com.jack.nowcoder.spring.MeiTuan.CodeM2017.fouth;

import java.util.Scanner;

/**
 * 给出一个正整数n，把1..n在k进制下的表示连起来记为s(n,k)，例如
 * s(16,16)=123456789ABCDEF10,s(5,2)=110111100101。
 * 现在对于给定的n和字符串t，我们想知道是否存在一个k(2<=k<=16)
 * 使得t是s(n,k)的子串。
 * 输入描述：
 * 第一行一个整数n(1<=n<=50000)
 * 第二行一个字符串t(<=10000000)
 * 输出描述：
 * "yes"表示存在满足条件的k，否则输出"no"
 * 输入
 * 8
 * 01112
 * 输出
 * yes
 */
public class P1 {
    public static void main(String [] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            String s = sc.next();
            boolean flag = false;
            for (int i=2;i<=16 && !flag;i++) {
                StringBuffer sb = new StringBuffer();
                for (int j=1;j<=n;j++) {
                    sb.append(Integer.toString(j,i));
                }
                String str = sb.toString().toUpperCase();
                if (str.contains(s)) {
                    flag = true;
                    break;
                }
            }
            if (flag) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }
    }
}