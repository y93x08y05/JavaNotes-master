package com.jack.leetcode;

import java.util.Scanner;

/**
 * @Author: Jack
 * @Date: 2018/9/9 23:58
 * LeetCode 640
 * 求解方程
 * 求解一个给定的方程，将x以字符串"x=#value"的形式返回。
 * 该方程仅包含'+'，' - '操作，变量 x 和其对应系数。
 * 如果方程没有解，请返回“No solution”。
 * 如果方程有无限解，则返回“Infinite solutions”。
 * 如果方程中只有一个解，要保证返回值 x 是一个整数。
 * 例1：
 * 输入: "x+5-3+x=6+x-2"
 * 输出: "x=2"
 * 例2:
 * 输入: "x=x"
 * 输出: "Infinite solutions"
 * 例3:
 * 输入: "2x=x"
 * 输出: "x=0"
 * 例4:
 * 输入: "2x+3x-6x=x+2"
 * 输出: "x=-1"
 * 例5:
 * 输入: "x=x+2"
 * 输出: "No solution"
 */
public class SolveEquation {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        System.out.println(solveEquation(s));
    }
    private static String solveEquation(String s) {
        int []res1=evaluateExpression(s.split("=")[0]);
        int []res2=evaluateExpression(s.split("=")[1]);
        res1[0]-=res2[0];
        res1[1]=res2[1]-res1[1];
        if (res1[0]==0&&res1[1]==0)
            return "Infinite solutions";
        if (res1[0]==0)
            return "No solution";
        return "x="+res1[1]/res1[0];
    }
    private static int[] evaluateExpression(String exp) {
        String []tokens=exp.split("(?=[-+])");
        int []res=new int[2];
        for (String token:tokens) {
            if (token.equals("+x")||token.equals("x"))
                res[0]+=1;
            else if (token.equals("-x"))
                res[0]-=1;
            else if (token.contains("x"))
                res[0]+=Integer.parseInt(token.substring(0,token.indexOf("x")));
            else
                res[1]+=Integer.parseInt(token);
        }
        return res;
    }
}