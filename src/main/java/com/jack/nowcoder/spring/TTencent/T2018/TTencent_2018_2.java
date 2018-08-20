package com.jack.nowcoder.spring.TTencent.T2018;

import java.util.Scanner;

/**
 * 去商店买东西，k是非负的整数
 * 有两个2的k次方的零钱
 * 比如2的0/1/2/3次方即1,1,2,2,4,4,8,8...种
 * 输入6则输出有5种组合方式利用现有的用2的k次方组成的数
 * Java 的Math.log(double a) 函数是以e(2.71828...)为底来计算的，如果我们想知道log(2)(8)的计算结果
 * 利用换底公式：log(x)(y) =log(e)(x) / log(e)(y)，Math.log(8) / Math.log(2)
 */
public class TTencent_2018_2 {
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        System.out.println(Math.pow(2, num));
        System.out.println(Math.sqrt(4));
        System.out.println(Math.sqrt(Math.pow(4, num)));
        System.out.println((int)(Math.log(6) / Math.log(2)));
    }
}