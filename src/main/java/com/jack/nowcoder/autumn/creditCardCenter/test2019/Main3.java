package com.jack.nowcoder.autumn.creditCardCenter.test2019;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Jack on 8/30/2018 7:49 PM
 * 输入描述
 * 第一行输入为猫粮数组，以空格分割
 * 第二行为主人离开H小时，每个小时选择一个数组吃掉K粒
 * 如果不足K粒则吃掉剩下的，然后这一个小时不会再吃更多的猫粮
 * 想在主人回来之前吃掉所有的猫粮
 * 输出描述
 * 最小速度K
 * 例子
 * 输入
 * 3 6 7 11
 * 8
 * 输出
 * 4
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String []str=sc.nextLine().split(" ");
        int []arr=new int[str.length];
        for (int i=0;i<arr.length;i++) {
            arr[i]=Integer.parseInt(str[i]);
        }
        int h=sc.nextInt();
        System.out.println(findMinValue(arr, h));
    }
    private static int findMinValue(int []arr,int h) {
        Arrays.sort(arr);
        int left=1;
        int right=arr[arr.length-1]+1;
        while(left<right) {
            int m=(right-left)/2+left;
            int w=0;
            for(int i=0;i<arr.length;i++) {
                w+=(arr[i]+m-1)/m;
            }
            if(w<=h) {
                right=m;
            } else {
                left=m+1;
            }
        }
        return left;
    }
}


