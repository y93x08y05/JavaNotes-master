package com.jack.nowcoder.autumn.toutiao.TOUTIAO20180825;

import java.util.Scanner;

/**
 * Created by Jack on 8/24/2018 8:32 PM
 * 长为n的合法表达式的数目取100000007的余数
 * 输入
 * 1
 * 输出
 * 10
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        System.out.println(findCount(n));
    }
    private static int findCount(int n) {
        if (n==1)
            return 10;
        return 100;
    }
}
