package com.jack.nowcoder.spring.BBaidu;

import java.util.Scanner;

/**
 * 一个数轴上共有N个点，第一个点的坐标是现在位置，第N-1个点是家。
 * 现在他需要依次的从0号坐标走到N-1号坐标，每个坐标都需要经过。
 * 但是除了0号坐标和N-1号坐标，他可以在其余的N-2个坐标中选出一个点，
 * 并直接将这个点忽略掉，问回家至少走多少距离？
 * 输入一个正整数N, N <= 50。
 * 接下来N个整数表示坐标，正数表示X轴的正方向，负数表示X轴的负方向。绝对值小于等于100
 * 输出一个整数表示最少需要走的距离。
 * 输入
 * 4
 * 1 4 -1 3
 * 输出
 * 4
 */
public class BaiDu_2017_2 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] dian = new int[n];
        for(int i=0; i<n; i++){
            dian[i] = sc.nextInt();
        }
        if(n<=1){
            System.out.println(0);
        }
        if(n==2){
            System.out.println(Math.abs(dian[1]-dian[0]));
        }
        int distance = 0;
        //取得除了开始和结尾的中间所有值，每次过滤顺序的过滤掉中间一个值
        //然后计算加起来的总的距离，然后动态更新距离
        for(int i=1; i<=n-2; i++){
            int temp = 0;
            for(int j=0; j<n-1; j++){
                if(j+1 == i){//跳过中间的某一个数，用后一个数减去前一个数
                    temp += Math.abs(dian[j+2] - dian[j]);
                    j++;
                } else{
                    temp += Math.abs(dian[j+1] - dian[j]);
                }
            }
            //第一次先赋值，后边需要判断距离大小
            if(i==1){
                distance = temp;
            } else{
                if(temp < distance){
                    distance = temp;
                }
            }
        }
        System.out.println(distance);
    }
}
