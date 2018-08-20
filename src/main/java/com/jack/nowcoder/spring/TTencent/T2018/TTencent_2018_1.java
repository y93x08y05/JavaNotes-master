package com.jack.nowcoder.spring.TTencent.T2018;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 给定平面上的4个点，判断这4个坐标点是不是构成一个正方形
 * 相邻两边相等,对角线相等的四边形是正方形
 */

public class TTencent_2018_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [][] array = new int[2][4];
        double [] result =new double[6];
        int ram = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<8;j++){
                if(j<4){
                    array[0][j] = sc.nextInt();
                }else{
                    array[1][j-4] = sc.nextInt();
                }
            }
           getResult(array,ram,result);
        }
    }
    public static void getResult(int [][] array,int ram,double [] result){
        for(int i=0;i<array[0].length;i++){
            for(int j=i+1;j<array[0].length;j++){
                result[ram++] = Math.pow((array[0][i]-array[0][j]),2)+
                        Math.pow((array[1][i]-array[1][j]),2);
            }
        }
        Arrays.sort(result);
        if(result[0]==result[1] &&
                result[1] == result[2] &&
                result[2] == result[3] &&
                result[4]==result[5]){
            System.out.println("Yes");
        }else{
            System.out.println("No");
        }
    }
}