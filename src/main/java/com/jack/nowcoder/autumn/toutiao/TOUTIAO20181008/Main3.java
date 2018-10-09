package com.jack.nowcoder.autumn.toutiao.TOUTIAO20181008;

import java.util.Scanner;

/**
 * @Author: Jack
 * @Date: 2018/10/8 18:53
 * 字符串的每个位置都可以选择是否加一个'+'或'-'
 * 要求最后形成一个合法的算式
 * 并且算出所有可能的组合中计算结果为0的组合数量。
 * 比如输入“11”，因为1-1=0，-1+1=0。所以输出为2
 * 输入“1111”，输出为8。
 * 输入描述：
 * 输入格式
 * 一个字符串
 * 输出格式
 * 一个数字
 * 输入样例
 * 第一行N表示这个测试集合有多少个测试用例，下边N行每行是一个1-9
 * 数字组成的字符串
 * 输入：
 * 1
 * 1111
 * 输出：
 * 8
 */
public class Main3 {
    private static int number = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            String s = sc.nextLine();
            find(s,0,0,0,true);
            System.out.println(number);
            number = 0;
        }
    }
    public static void find(String s,int start, int now, int sum, boolean minus) {
        String s1 = s.substring(start,now);
        if (s1.length() >= 1) {
            long subSum = Long.parseLong(s1);
            if (!minus) {
                sum += subSum;
            } else {
                sum -= subSum;
            }
        }
        if (now >= s.length() && start != 0) {
            if (sum == 0) {
                number++;
            }
            return;
        }
        for (int i = now + 1; i <= s.length(); i++) {
            find(s,now,i,sum,true);
            find(s,now,i,sum,false);
        }
    }
}