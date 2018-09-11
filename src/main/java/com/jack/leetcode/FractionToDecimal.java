package com.jack.leetcode;

import java.util.*;

/**
 * @Author: Jack
 * @Date: 2018/9/11 13:48
 * LeetCode 166
 * 分数到小数
 * 给定两个整数，分别表示分数的分子 numerator 和分母 denominator，
 * 以字符串形式返回小数。
 * 如果小数部分为循环小数，则将循环的部分括在括号内。
 * 例1:
 * 输入: numerator = 1, denominator = 2
 * 输出: "0.5"
 * 例2:
 * 输入: numerator = 2, denominator = 1
 * 输出: "2"
 * 例3:
 * 输入: numerator = 2, denominator = 3
 * 输出: "0.(6)"
 */
public class FractionToDecimal {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int a=sc.nextInt();
        int b=sc.nextInt();
        System.out.println(fractionToDecimal(a, b));
    }
    private static String fractionToDecimal(int numerator,int denominator) {
        Map<Long,Integer> map=new HashMap<>();
        List<Long> list=new ArrayList<>();
        int index=0;
        int startIndex=-1;
        StringBuilder sb=new StringBuilder();
        if (denominator==0)
            return "";
        long num1=numerator;
        long num2=denominator;
        if ((num1<0&&num2>0)||(num1>0&&num2<0))
            sb.append("-");
        num1=Math.abs(num1);
        num2=Math.abs(num2);
        long value=num1/num2;
        sb.append(String.valueOf(value));
        num1=(num1%num2)*10;
        while (num1!=0) {
            if (map.containsKey(num1)) {
                startIndex=map.get(num1);
                break;
            } else {
                map.put(num1,index++);
                value=num1/num2;
                num1=(num1%num2)*10;
                list.add(value);
            }
        }
        for (int i=0;i<index;i++) {
            if (i==0) {
                sb.append('.');
            }
            if (i==startIndex) {
                sb.append("(");
            }
            sb.append(list.get(i));
        }
        if (startIndex!=-1)
            sb.append(")");
        return sb.toString();
    }
}