package com.jack.nowcoder.spring.ShenXinFu;

import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        boolean [] temp = new boolean[m];
        for (int i=0;i<m;i++) {
            temp[i] = false;
        }
        int [] arr = new int[n];
        for (int i=0;i<n;i++) {
            arr[i] = sc.nextInt();
        }
        boolean flag = false;
        for (int i=0;i<m;i++) {
            int tem = i+1;
            if (!getResult(tem,arr)) {
                flag = true;
                System.out.println("No");
                break;
            }
        }
        if (!flag) {
            System.out.println("Yes");
        }
    }
    public static boolean getResult(int tem,int [] arr) {
        if (tem == arr[0]) {
            return true;
        }
        for (int i=0;i<arr.length;i++) {
            if (tem == arr[i]) {
                return true;
            } else if (tem < arr[i]) {
                tem++;
            } else {
                tem--;
            }
        }
        return false;
    }
}