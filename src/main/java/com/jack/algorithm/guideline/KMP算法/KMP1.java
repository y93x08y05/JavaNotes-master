package com.jack.algorithm.guideline.KMP算法;

import java.util.Scanner;

/**
 * @Author: Jack
 * @Date: 2018/10/3 9:42
 */
public class KMP1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s1=sc.nextLine();
        String s2=sc.nextLine();
        System.out.println(find(s1, s2));
    }

    /**
     * s1为主串，s2为模式串，返回在主串汇总第一个字符
     * 出现的下标，否则为1
     * @param s1
     * @param s2
     * @return
     */
    private static int find(String s1,String s2) {
        char []t=s1.toCharArray();
        char []p=s2.toCharArray();
        int i=0;//主串的位置
        int j=0;//模式串的位置
        while (i<t.length&&j<p.length) {
            if (t[i]==p[j]) {//当两个字符相同时就比较下一个
                i++;
                j++;
            } else {//不匹配则i后退，j从0开始
                i=i-j+1;
                j=0;
            }
        }
        if (j==p.length)
            return i-j;
        else
            return -1;
    }
}