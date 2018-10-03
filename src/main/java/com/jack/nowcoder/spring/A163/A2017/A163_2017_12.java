package com.jack.nowcoder.spring.A163.A2017;

import java.util.Scanner;

/***
 * 易老师购买了一盒饼干，盒子中一共有k块饼干，但是数字k有些数位变得模糊了，
 * 看不清楚数字具体是多少了。易老师需要你帮忙把这k块饼干平分给n个小朋友，
 * 易老师保证这盒饼干能平分给n个小朋友。现在你需要计算出k有多少种可能的数值
 * 输入描述
 * 输入包括两行：
 * 第一行为盒子上的数值k，模糊的数位用X表示，长度小于18(可能有多个模糊的数位)
 * 第二行为小朋友的人数n
 * 输出描述
 * 输出k可能的数值种数，保证至少为1
 * 输入例子
 * 9999999999999X 3
 * 输出例子
 * 4
 * 动态规划：状态转移方程dp[i][newJ] += 动态规划[i-1][J].其中i代表数字串的长度，J代表余数，
 * 结果值代表i长度的数字串中求余n余J的所有可能结果总数
 * 根据以上的说明，显而易见newJ==(J*10+k)%n ，k代表当前数字串中个位的值
 * （也就是数字串的第i位）
 * 以下两段代码均经过测试可AC，如果去除if条件判断，则程序运行的结果为：
 * 输入长度为n的字符串，则求出长度为n的数字串中，求余n余数为0的所有结果总数，
 * 但题意不是这么要求的，所以枚举的时候，需要进行判断，
 * 如果判断到X则可以枚举0~10（也就是k的值可以取值为0~10），如果不是X，
 * 则k只能取值为数字串中的对应值，举个例子：
 * 如果输入的数字串长度为3，不加if判断的话，则枚举到的所有结果为：0~999
 * 如果加了判断，如X33X，则枚举到的结果值为330~339,1330~1339 ... 1339~9339 符合题意
 * 在以上枚举到的结果中，进行求余判断并且记录结果，关键是要理解好状态转移方程
 */
public class A163_2017_12 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int n = sc.nextInt();
        long[] dp = new long[n];
        dp[0] = 1;
        for(int i = 1;i<=str.length();i++){
            char c = str.charAt(i-1);
            long[] tmp = new long[n];
            for(int j = 0;j<n;j++){
                for(int k = 0;k<10;k++){
                    if(c=='X'||c=='0'+k){
                        tmp[(j*10+k)%n]+=dp[j];
                    }
                }
            }
            dp = tmp;
        }
        System.out.println(dp[0]);
    }
}
/**
 *  public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int n = sc.nextInt();
        long[][] 动态规划 = new long[str.length()+1][]; //不用long的话通过率只能为90%
        for(int i = 0;i<=str.length();i++){
            动态规划[i] = new long[n];
        }
        动态规划[0][0] = 1;
        for(int i = 1;i<=str.length();i++){
            char c = str.charAt(i-1);
            for(int j = 0;j<n;j++){
                for(int k = 0;k<10;k++){
                    if(c=='X'||c=='0'+k){
                        动态规划[i][(j*10+k)%n]+=动态规划[i-1][j];
                    }
                }
             }
         }
        System.out.println(动态规划[str.length()][0]);
    }
 */