package com.jack.nowcoder.autumn.toutiao.TOUTIAO20180812;

import java.util.Scanner;

/**
 * Created by Jack on 8/12/2018 9:43 AM
 */
public class Main4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [][] arr = new int[n][2];
        for (int i=0;i<n;i++) {
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        }
        int sum = 0;
        int count;
        for (int i=0;i<n-1;i++) {
            int temp = arr[i][0];
            count = 0;
            for (int j=i+1;j<n;j++) {
                count += arr[j][0];
                if (count==temp) {
                    int temp2 = arr[i][1];
                    for (int k=i+1;k<=j;k++) {
                        temp2+=arr[k][1];
                    }
                    if (temp2>sum) {
                        sum=temp2;
                    }
                }
            }
        }
        System.out.println(sum);
    }
}
