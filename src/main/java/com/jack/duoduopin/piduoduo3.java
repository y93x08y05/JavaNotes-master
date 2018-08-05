package com.jack.duoduopin;

import java.util.Scanner;

/**
 * Created by Jack on 8/5/2018 10:06 PM
 */
public class piduoduo3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        sc.nextLine();
        String [][] arr = new String[m][m];
        for (int i=0;i<m;i++) {
            String [] temp = sc.nextLine().split(" ");
            arr[i] = temp;
        }
        int value = -1;
        for (int i=0;i<arr.length;i++) {
            if (i == n) {
                for (int j=0;j<arr[i].length;j++) {
                    int count = 0;
                    int temp = 0;
                    for (int k=0;k<arr.length;k++) {
                        if (k != n) {
                            if (!arr[i][j].equals(String.valueOf(k))) {
                                for (int p=0;p<arr[i].length;p++) {
                                    for (int q=0;q<arr[k].length;k++) {
                                        if (k != n) {
                                            if (arr[i][p].equals(arr[k][q])) {
                                                temp++;
                                                continue;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        if (temp > count) {
                            value = k;
                            count = temp;
                        }
                    }
                }
            }
        }
        System.out.println(value);
    }
}
