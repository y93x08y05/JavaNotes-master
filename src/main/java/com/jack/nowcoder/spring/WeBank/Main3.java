package com.jack.nowcoder.spring.WeBank;

import java.util.Scanner;

public class Main3 {
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int sum = 0;
        for (int i=2;i<=a;i++){
            if (is(i) || is((int)(Math.sqrt(i)))){
                sum++;
            } else if(is((int)(Math.cbrt(i)))){
                sum++;
            }
        }
        System.out.println(sum);
    }
    public static boolean is(int n){
        for(int i=2; i<=Math.sqrt(n); i++){
            if(n % i == 0)
                return false;
        }  return true;
    }
}