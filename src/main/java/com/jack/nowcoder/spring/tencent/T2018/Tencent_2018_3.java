package com.jack.nowcoder.spring.tencent.T2018;

import java.util.Scanner;

public class Tencent_2018_3 {
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int num1 = sc.nextInt();
        int num2 = sc.nextInt();
        int sum = 0;
        int temp = 0;
        boolean is = true;
        for (int i=1;i<=num1;i++){
            if (is){
                sum -= i;
                temp++;
                if(temp == num2){
                    is = false;
                }
            }else {
                sum += i;
                temp--;
                if(temp == 0){
                    is = true;
                }
            }
        }
        System.out.println(sum);
    }
}