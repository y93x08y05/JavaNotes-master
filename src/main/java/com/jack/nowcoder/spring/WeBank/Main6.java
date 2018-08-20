package com.jack.nowcoder.spring.WeBank;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * 求小于或等于整数N的整数的二进制形式下回文数的个数
 * 输入3
 * 输出3 0,1,11
 */
public class Main6 {
    public static void main(String [] args){
        Scanner scanner = new Scanner(System.in);
        BigInteger n = scanner.nextBigInteger();
        BigInteger i = BigInteger.valueOf(0);
        BigInteger one = BigInteger.valueOf(1);
        int [] a = new int[200];
        for (int p=0;p<200;p++){
            a[p] = 0;
        }
        int len = 1;
        Integer ans = (Integer)1;
        while (n.compareTo(i) > 0){
            len = fun(a,len);
            if (fun2(a,len)){
                ans++;
            }
            i = i.add(one);
        }
        System.out.println(ans);
    }
    public static int fun(int a [] , int len){
        if (a[0] == 0){
            a[0] = 1;
            return len;
        }
        int flag = 1;
        for (int i=0;i<len;i++){
            if (a[i] + flag == 2){
                flag = 1;
                a[i] = 0;
            }else {
                a[i] = 1;
                flag = 0;
                break;
            }
            if (i == len){
                a[i] = 1;
                len++;
            }
        }
        return len;
    }
    public static boolean fun2(int [] a , int len){
        int low = 0;
        int high = len-1;
        while (low<=high && a[low] == a[high]){
            low++;
            high--;
        }
        if (low>high){
            return true;
        }
        return false;
    }
}