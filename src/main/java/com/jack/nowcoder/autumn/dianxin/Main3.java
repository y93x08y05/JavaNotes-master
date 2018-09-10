package com.jack.nowcoder.autumn.dianxin;

import java.util.Scanner;

/**
 * @Author: Jack
 * @Date: 2018/9/10 9:25
 * 给定两个字符串，求它们前后重叠的最长子串的长度，比如"abcde"和"cdefg"，长度为3
 * 比如"abcdeh"和"cdefg"中的"cde"不是前后重叠，所以长度为0。
 * 输入描述：
 * 输入包含多个测试案例，对于每个测试案例只有一行，包含两个字符串，字符串长度不超过
 * 1000000，仅包含字符'a'-'z'。
 * 输出描述：
 * 对于每个测试案例，输出它们前后重叠的最长子串长度；
 * 例1：
 * 输入：
 * abcde cdefg
 * 输出：
 * 3
 * 例2：
 * 输入：
 * eeefffwqerwq  wqerwq
 * 输出：
 * 6
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s1=sc.next();
        String s2=sc.next();
        int l1=findChongFuChangDu(s1, s2);
        int l2=findChongFuChangDu(s2,s1);
        System.out.println(Math.max(l1,l2));
    }
    private static int findChongFuChangDu(String a,String b) {
        if (a.length()==0||b.length()==0||a==null||b==null)
            return 0;
        int maxLength=Integer.MIN_VALUE;
        for (int i=0;i<a.length();i++) {
            String temp1=a.substring(i,a.length());
            if (b.length()>=temp1.length()) {
                if (b.substring(0,temp1.length()).equals(temp1)) {
                    if (maxLength<temp1.length())
                        maxLength=temp1.length();
                }
            }
        }
        return maxLength==Integer.MIN_VALUE?0:maxLength;
    }
}