package com.jack.nowcoder.autumn.shell;

import java.util.Scanner;

/**
 * Created by Jack on 8/18/2018 6:28 PM
 * 5
 * 4 1 8 2 5
 * 村庄修道路，使得费用最少问题，以两个村庄最大值为修路费用
 * sum-min means mergeSort array and sum-array[0];
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        int [] arr = new int[n];
        String [] str = sc.nextLine().split(" ");
        for (int i=0;i<arr.length;i++) {
            arr[i]=Integer.parseInt(str[i]);
        }
        System.out.println(findMinCost(arr));
    }
    private static long findMinCost(int [] arr) {
        long sum = 0;
        for (int i=0;i<arr.length-1;i++) {
            sum+=Math.abs(arr[i+1]-arr[i]);
        }
        return sum;
    }
}
