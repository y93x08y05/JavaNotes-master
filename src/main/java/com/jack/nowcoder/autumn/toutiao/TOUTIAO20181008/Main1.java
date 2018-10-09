package com.jack.nowcoder.autumn.toutiao.TOUTIAO20181008;

import java.util.Scanner;
/**
 * @Author: Jack
 * @Date: 2018/10/8 18:53
 * 小A有两个幸运数字字符a和b。他认为一个数字很美，
 * 当且仅当这个数字只包含数字字符a和b，且这个数字每位
 * 数字之和也只包含数字字符a和b。
 * 例如：幸运数字字符为1和2，那么11很美，其每位数字之和为2
 * 11和2都只含有数字字符1和2。但是12，21，111都不美，虽然
 * 他们本身都只含有数字字符1和2，但它们每位数字之和都为3
 * 而3不是幸运数字字符。
 * 现在小A想知道对于所有的K位数字，有多少个美丽的数字？
 * 输入描述：
 * 一行包含三个数字，a，b，k。
 * 1<=a,b<=9
 * 输出描述：
 * 一行包含一个数字，即美丽的数字个数。
 * 由于答案可能很大，请对100000007取模。
 * 输入：
 * 1 2 2
 * 输出：
 * 1
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int a=sc.nextInt();
        int b=sc.nextInt();
        int k=sc.nextInt();
        System.out.println(find(a, b, k));
    }
    private static int find(int a,int b,int k) {
        return 0;
    }
}