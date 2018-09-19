package com.jack.nowcoder.autumn.tencent.tencent0916;

import java.util.Scanner;

/**
 * @Author: Jack
 * @Date: 2018/9/16 10:43
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        for (int i=0;i<n;i++) {
            int A=sc.nextInt();
            int B=sc.nextInt();
            int C=sc.nextInt();
            System.out.println(find(A, B, C));
        }
    }
    private static String find(int A,int B,int C) {
        int max=Integer.MAX_VALUE;
        int val;
        for (int i=1;i*A<10000;i++) {
            val=i*A;
            if (val%B==C) {
                return "YES";
            }
        }
        return "NO";
    }
    private static void find1(int n) {
        if (n==1) {
            System.out.println("YES");
        }
        else if (n==2) {
            System.out.println("YES");
            System.out.println("NO");
        } else if (n==3) {
            System.out.println("YES");
            System.out.println("YES");
            System.out.println("NO");
        }
    }
}