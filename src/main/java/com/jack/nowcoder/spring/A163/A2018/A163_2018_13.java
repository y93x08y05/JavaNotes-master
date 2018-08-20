package com.jack.nowcoder.spring.A163.A2018;

import java.util.Scanner;

/**
 * Created by zhangta on 1/8/2018.
 * A每天必须吃一个水果并且需要每天支付x元的房屋租金
 * 已经有f个水果和d元钱,也能去商店购买一些水果,商店每个水果售卖p元
 * 计算一下他最多能独立生活多少天
 * 输入包括一行,四个整数x, f, d, p(1 ≤ x,f,d,p ≤ 2 * 10^9),以空格分割
 * 输出一个整数, 表示最多能独立生活多少天
 */
public class A163_2018_13 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int rentPay=sc.nextInt();
        int appleNum=sc.nextInt();
        int totalMoney=sc.nextInt();
        int applePrice=sc.nextInt();
        if(totalMoney/rentPay<=appleNum)
            System.out.println(totalMoney/rentPay);
        else
            System.out.println(appleNum+(totalMoney-appleNum*rentPay)/(applePrice+rentPay));
        sc.close();
    }
}
