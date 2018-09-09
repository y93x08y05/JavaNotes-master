package com.jack.nowcoder.autumn.wangyi.WY20180908_1;

import java.util.Scanner;

/**
 * @Author: Jack
 * @Date: 2018/9/8 14:38
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        for (int i=0;i<t;i++) {
            int n=sc.nextInt();
            int k=sc.nextInt();
            findMinAndMax(n,k);
        }
    }
    private static void findMinAndMax(int n,int k) {
        if (n<3||n<=k+1)
            System.out.println(0+" "+0);
        else {
            if (n/2<k) {
                int val=n-k;
                System.out.println(0+" "+val);
            } else if (n/2>=k){
                int val=k-1;
                System.out.println(0+" "+val);
            }
        }
    }
}