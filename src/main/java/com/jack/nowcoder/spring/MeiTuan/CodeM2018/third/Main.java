package com.jack.nowcoder.spring.MeiTuan.CodeM2018.third;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int r = sc.nextInt();
        int a1 = sc.nextInt();
        int b1 = sc.nextInt();
        int c1 = sc.nextInt();
        int d1 = sc.nextInt();
        double point1 = Math.sqrt(a1*a1+b1*b1);
        double point2 = Math.sqrt(c1*c1+d1*d1);
        if (a1 == 0 && c1 == 0){
            double re = Math.min(Math.abs(b1-d1),Math.abs(r-Math.abs(d1))+Math.abs(r-Math.abs(b1)));
            System.out.println(String.valueOf(re));
        } else if (b1 == 0 && d1 == 0) {
            double re = Math.min(Math.abs(a1-c1),Math.abs(r-Math.abs(c1))+Math.abs(r-Math.abs(c1)));
            System.out.println(String.valueOf(re));
        } else if (a1 == c1) {

        } else if (b1 == d1){

        }else {
            double temp1 = Math.sqrt((b1-d1)*(b1-d1)+(a1-c1)*(a1-c1));
            double a2 = r/point1*Math.abs(a1);
            double b2 = r/point1*Math.abs(b1);
            if (a1 > 0) {
                a2 = a2 * -1;
            }
            if (b2 > 0) {
                b2 = b2 * -1;
            }
            double temp2 = Math.sqrt((b2-d1)*(b2-d1)+(a2-c1)*(a2-c1));
            double re = Math.min(temp1,temp2);
            System.out.println(String.valueOf(re));
        }
    }
}