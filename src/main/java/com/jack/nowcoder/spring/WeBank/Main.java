package com.jack.nowcoder.spring.WeBank;

import java.util.Scanner;

public class Main {
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        long a = sc.nextLong();
        long b = sc.nextLong();
        long c = sc.nextLong();
        long value = (long)(Math.pow(2,a)+Math.pow(2,b)-Math.pow(2,c));
        long sum = 0;
        while(value != 0){
            sum += value % 2;
            value = value / 2;
        }
        System.out.println(sum);
    }
}