package com.jack.nowcoder.autumn.duoduopin.duoduo20180830;

import java.util.Scanner;

/**
 * Created by Jack on 8/30/2018 10:10 PM
 */
public class A {
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        if(c>2*b){
            int x = a/c;
            x*=2;
            a-=x*c/2;
            if(a!=0){
                if(a<=b)x++;
                else x+=2;
            }
            System.out.println(x);
        }else{
            int x = a/b;
            if(a%b!=0)x++;
            System.out.println(x);
        }
    }
}
