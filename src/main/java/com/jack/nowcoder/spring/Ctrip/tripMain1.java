package com.jack.nowcoder.spring.Ctrip;

import java.text.DecimalFormat;
import java.util.Scanner;

public class tripMain1 {
    public static void main(String [] args){
        DecimalFormat  df = new DecimalFormat("######0.00");
        Scanner sc = new Scanner(System.in);
        int num1 = sc.nextInt();
        int num2 = sc.nextInt();
        double sum = num1;
        double value = num1;
        for (int i=1;i<num2;i++){
            value = Math.sqrt(value);
            sum+=value;
        }
        System.out.println(df.format(sum));
    }
}