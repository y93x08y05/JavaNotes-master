package com.jack.nowcoder.autumn.tencent.tencent0916;

import java.util.Scanner;

/**
 * @Author: Jack
 * @Date: 2018/9/16 9:41
 */
public class Main2 {
    public static int maxLimit=1000000;
    public static int []prime=new int[maxLimit];
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        for (int i=2;i*i<maxLimit;i++) {
            if (prime[i]<=0) {
                for (int j=2*i;j<maxLimit;j+=i)
                    prime[j]=1;
            }
        }
        int n=sc.nextInt();
        System.out.println(findZuiXiaoGongBeiShu(n));
    }
    private static int findZuiXiaoGongBeiShu(int n) {
        if (n==0)
            return 0;
        int result=2;
        for (int i=2;i<=n;i++) {
            if (prime[i]<=0) {
                int temp1= (int) (Math.log(n)/Math.log(i));
                int temp2= (int) Math.pow(i,temp1);
                for (int j=2;;++j) {
                    if (temp2*j>n) {
                        temp2*=j;
                        break;
                    }
                }
                result=Math.max(result,temp2);
            }
        }
        return result;
    }
}