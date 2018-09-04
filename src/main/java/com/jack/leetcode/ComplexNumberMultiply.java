package com.jack.leetcode;

import java.util.Scanner;

/**
 * @Author: Jack
 * @Date: 2018/9/5 0:03
 * LeetCode 537
 * 给定两个表示复数的字符串。
 * 返回表示它们乘积的字符串。注意，根据定义 i2 = -1 。
 * 例1:
 * 输入: "1+1i", "1+1i"
 * 输出: "0+2i"
 * 解释: (1 + i) * (1 + i) = 1 + i2 + 2 * i = 2i ，转换为 0+2i 的形式。
 * 例2:
 * 输入: "1+-1i", "1+-1i"
 * 输出: "0+-2i"
 * 解释: (1 - i) * (1 - i) = 1 + i2 - 2 * i = -2i ，转换为 0+-2i 的形式。
 */
public class ComplexNumberMultiply {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s1=sc.nextLine();
        String s2=sc.nextLine();
        System.out.println(complexNumberMultiply(s1, s2));
    }
    private static String complexNumberMultiply(String s1,String s2) {
        int []aa=new int[2];
        int []bb=new int[2];
        String []str1;
        String []str2;
        int real,virtual;
        String res;
        str1=s1.split("[+]");
        str2=s2.split("[+]");
        aa[0]=Integer.parseInt(str1[0]);
        aa[1]=Integer.parseInt(str1[1].split("i")[0]);
        bb[0]=Integer.parseInt(str2[0]);
        bb[1]=Integer.parseInt(str2[1].split("i")[0]);
        real=aa[0]*bb[0]+(-1)*aa[1]*bb[1];
        virtual=aa[0]*bb[1]+aa[1]*bb[0];
        res=real+"+"+virtual+"i";
        return res;
    }
}