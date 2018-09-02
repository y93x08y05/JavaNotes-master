package com.jack.nowcoder.spring.tencent.T2018;

import java.util.Scanner;

public class Tencent_2018_4 {
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        int a = sc.nextInt();
        int x = sc.nextInt();
        int [] array1 = new int[x];
        int b = sc.nextInt();
        int y = sc.nextInt();
        int [] array2 = new int[y];
        int sum = 0;
        for (int i=0;i<array1.length;i++){
            array1[i] = a;
        }
        for (int i=0;i<array2.length;i++){
            array2[i] = b;
        }
        for (int i=0;i<array1.length;i++){
            for (int j=0;j<array2.length;j++){
                if (array1[i]+array2[j] == count){
                    sum++;
                }
            }
        }
        System.out.println(sum);
    }
}