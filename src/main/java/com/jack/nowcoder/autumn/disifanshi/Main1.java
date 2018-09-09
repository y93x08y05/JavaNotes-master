package com.jack.nowcoder.autumn.disifanshi;

import java.util.Scanner;

/**
 * @Author: Jack
 * @Date: 2018/9/9 15:30
 * 输入描述：
 * 第一行为第一个数字字符串
 * 第二行为第二个数字字符串
 * 输出描述：
 * 乘积字符串
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println(findMultiplyTwoString(sc.nextLine(), sc.nextLine()));
    }
    private static String findMultiplyTwoString(String s1, String s2) {
        int len1=s1.length();
        int len2=s2.length();
        int num1,num2;
        int carry=0;
        int temp;
        int [] res=new int[len1+len2];
        StringBuilder sb = new StringBuilder();
        for (int i=len1-1;i>=0;i--) {
            num1=s1.charAt(i)-'0';
            for (int j=len2-1;j>=0;j--) {
                num2=s2.charAt(j)-'0';
                res[i+j+1]+=num1*num2;
            }
        }
        for (int i=res.length-1;i>=0;i--) {
            temp=(res[i]+carry)%10;
            carry=(res[i]+carry)/10;
            res[i]=temp;
        }
        for (int num:res)
            sb.append(num);
        while (sb.length()>1&&sb.charAt(0)=='0')
            sb.deleteCharAt(0);
        return sb.toString();
    }
}