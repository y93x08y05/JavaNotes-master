package com.jack.nowcoder.autumn.beijing360;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Jack on 8/27/2018 4:35 PM
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int [] arr1=new int[n];
        int [] arr2=new int[n];
        for (int i=0;i<n;i++) {
            arr1[i]=sc.nextInt();
            arr2[i]=sc.nextInt();
        }
        System.out.println(findMinArea(arr1, arr2));
    }
    private static long findMinArea(int []arr1,int []arr2) {
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        int x=Math.abs(arr1[arr1.length-1]-arr1[0]);
        int y=Math.abs(arr2[arr2.length-1]-arr2[0]);
        return x>y?(long)x*x:(long)y*y;
    }
}
