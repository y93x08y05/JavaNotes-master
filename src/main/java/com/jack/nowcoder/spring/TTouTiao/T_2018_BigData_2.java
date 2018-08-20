package com.jack.nowcoder.spring.TTouTiao;

import java.util.Scanner;

/**
 * 给定一个数组序列, 需要求选出一个区间, 使得该区间是所有区间中经过如下计算的值最大的一个：
 * 区间中的最小数 * 区间所有数的和最后程序输出经过计算后的最大值即可，不需要输出具体的区间。
 * 如给定序列  [6 2 1]则根据上述公式, 可得到所有可以选定各个区间的计算值:
 * [6] = 6 * 6 = 36;
 * [2] = 2 * 2 = 4;
 * [1] = 1 * 1 = 1;
 * [6,2] = 2 * 8 = 16;
 * [2,1] = 1 * 3 = 3;
 * [6, 2, 1] = 1 * 9 = 9;
 * 从上述计算可见选定区间 [6] ，计算值为 36， 则程序输出为 36。
 * 区间内的所有数字都在[0, 100]的范围内;
 * 输入描述
 * 第一行输入数组序列长度n，第二行输入数组序列。
 * 对于 50%的数据,  1 <= n <= 10000;
 * 对于 100%的数据, 1 <= n <= 500000;
 * 输出描述
 * 输出数组经过计算后的最大值。
 * 输入例子
 * 3
 * 6 2 1
 * 输出例子
 * 36
 */
public class T_2018_BigData_2 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int [] input  =new int [size];
        for(int i=0;i<input.length;i++){
            input[i] = sc.nextInt();
        }
        long max=input[0]*input[0];
        for(int i=0;i<size;i++){
            long sum=input[i];
            int min=input[i];
            for(int j=i+1;j<size;j++){
                if(input[j]==0){
                    break;
                }
                sum+=input[j];
                if(input[j]<min){
                    min = input[j];
                }
                if(min*sum>max){
                    max=min*sum;
                }
            }
        }
        System.out.println(max);
    }
}
