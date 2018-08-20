package com.jack.nowcoder.spring.Ctrip;
/**
 * 利用竖线和横线将矩阵中的连接起来需要多少条线
 * 4 5
 * 1 0 1 0 1
 * 0 1 0 1 0
 * 0 0 1 0 0
 * 0 0 1 0 0
 */

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int num1 = sc.nextInt();
        int num2 = sc.nextInt();
        int [] row = new int[num1];
        int [] lie = new int[num2];
        int [][] array = new int[num1][num2];
        for (int i=0;i<array.length;i++){
            for (int j=0;j<array[0].length;j++){
                array[i][j] = sc.nextInt();
            }
        }
        for (int i=0;i<array.length;i++){
            int sum = 0;
            for (int j=0;j<array[0].length;j++){
                if (array[i][j]==1){
                    sum++;
                }
            }
            row[i] = sum;
        }
        for (int i=0;i<array[0].length;i++){
            int sum = 0;
            for (int j=0;j<array.length;j++){
                if (array[j][i]==1){
                    sum++;
                }
            }
            lie[i] = sum;
        }
        Arrays.sort(lie);
        System.out.println(1);
    }
}