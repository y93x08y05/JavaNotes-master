package com.jack.nowcoder.spring.Ctrip;

import java.util.Scanner;

public class tripMain2 {
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int num1 = sc.nextInt();
        int num2 = sc.nextInt();
        int count = 0;
        for (int i=num1;i<=num2;i++){
            if ((Math.pow(i/100,3)+
                    Math.pow((i%100)/10,3)+
                    Math.pow(((i%100)%10),3))==i){
                count++;
                System.out.print(i+" ");
            }
        }
        if (count==0){
            System.out.print("no");
        }
    }
}