package com.jack.leetcode;

import java.util.Scanner;

/**
 * @Author: Jack
 * @Date: 2018/9/10 0:15
 * LeetCode 592
 * 分数加减运算
 * 给定一个表示分数加减运算表达式的字符串，你需要返回一个字符串形式的计算结果。
 * 这个结果应该是不可约分的分数。
 * 如果最终结果是一个整数，例如 2，你需要将它转换成分数形式，其分母为 1。
 * 所以在上述例子中, 2 应该被转换
 * 例1:
 * 输入:"-1/2+1/2"
 * 输出: "0/1"
 * 例2:
 * 输入:"-1/2+1/2+1/3"
 * 输出: "1/3"
 * 例3:
 * 输入:"1/3-1/2"
 * 输出: "-1/6"
 * 例4:
 * 输入:"5/3+1/3"
 * 输出: "2/1"
 * (1)输入和输出字符串只包含 '0' 到 '9' 的数字，以及 '/', '+' 和 '-'。
 * (2)输入和输出分数格式均为 ±分子/分母。
 * 如果输入的第一个分数或者输出的分数是正数，则 '+' 会被省略掉。
 * (3)输入只包含合法的最简分数，每个分数的分子与分母的范围是  [1,10]。
 * 如果分母是1，意味着这个分数实际上是一个整数。
 * (4)输入的分数个数范围是 [1,10]。
 * (5)最终结果的分子与分母保证是 32 位整数范围内的有效整数。
 */
public class FractionAddition {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String expression=sc.nextLine();
        System.out.println(findExpression(expression));
    }
    private static String findExpression(String expression) {
//        if (expression.length()<=5)
            return expression;
//        int []t1=
    }
    private static int [] find(String expression) {
//        return
        int []res=new int[3];
        return res;
////        int i=0;
//        if (expression.charAt(i)=='-'||expression.charAt(i)=='+')
//            i++;
//        String s=new String();
//        while (expression.charAt(i)!='/') {
//            s+=String.valueOf(expression.charAt(i++));
//        }
//        res[0]=Integer.parseInt(s);
//        if (expression.charAt(0)=='-')
//            res[0]=-res[0];
//        i++;
//        String s1=new String();
//        while (i<expression.length()&&expression.charAt(i)!=)
    }
}