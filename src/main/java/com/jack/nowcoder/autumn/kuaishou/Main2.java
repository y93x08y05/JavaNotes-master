package com.jack.nowcoder.autumn.kuaishou;

import java.util.Scanner;

/**
 * @Author: Jack
 * @Date: 2018/9/10 18:40
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String []str=sc.nextLine().split(",");
        int []arr=new int[str.length];
        for (int i=0;i<arr.length;i++) {
            arr[i]=Integer.parseInt(str[i]);
        }
        System.out.println(findMinCost(arr));
    }
    private static int findMinCost(int []arr) {
        int len=arr.length;
        if (len==2)
            return Math.min(arr[0],arr[1]);
        int []dp=new int[len+1];
        dp[0]=arr[0];
        dp[1]=arr[1];
        for (int i=2;i<len;i++) {
            dp[i]=Math.min(dp[i-2],dp[i-1])+arr[i];
        }
        return Math.min(dp[len-1],dp[len-2]);
    }
}