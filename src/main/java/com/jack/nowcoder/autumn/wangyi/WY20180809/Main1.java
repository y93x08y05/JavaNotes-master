package com.jack.nowcoder.autumn.wangyi.WY20180809;

import java.util.Scanner;

/**
 * Created by Jack on 8/11/2018 10:45 AM
 * 个税缴纳问题
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double [] arr = new double[n];
        for (int i=0;i<n;i++) {
            double money = sc.nextInt();
            arr[i] = money;
        }
        for (double i : arr)
            System.out.println(Math.round(tax(i)));
    }
    private static double tax(double money) {
        double sum = 0;
        double bar = 5000;
        if (money <= bar)
            return sum;
        else if (money-bar<=3000) {
            sum+=(money-bar)*0.03;
            return sum;
        } else if (money-bar<=12000) {
            sum+=3000*0.03+(money-bar-3000)*0.1;
            return sum;
        } else if (money-bar<=25000) {
            sum+=3000*0.03+9000*0.1+(money-bar-12000)*0.2;
            return sum;
        } else if (money-bar<=35000) {
            sum+=3000*0.03+9000*0.1+13000*0.2+(money-bar-25000)*0.25;
            return sum;
        } else if (money-bar<=55000) {
            sum+=3000*0.03+9000*0.1+13000*0.2+10000*0.25+(money-bar-35000)*0.3;
            return sum;
        } else if (money-bar<=80000) {
            sum+=3000*0.03+9000*0.1+13000*0.2+10000*0.25+20000*0.3+(money-bar-55000)*0.35;
            return sum;
        } else {
            sum+=3000*0.03+9000*0.1+13000*0.2+10000*0.25+20000*0.3+25000*0.35+(money-bar-80000)*0.45;
            return sum;
        }
    }
}
