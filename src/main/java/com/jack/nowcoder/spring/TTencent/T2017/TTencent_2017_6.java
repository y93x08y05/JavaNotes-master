package com.jack.nowcoder.spring.TTencent.T2017;

import java.util.Scanner;

/**
 * Created by zhangta on 1/10/2018.
 * 给定一个正整数，编写程序计算有多少对质数的和等于输入的这个正整数，并输出结果。输入值小于1000。
 * 如，输入为10, 程序应该输出结果为2。（共有两对质数的和为10,分别为(5,5),(3,7)）
 */
public class TTencent_2017_6 {
    //素数对
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int sum = 0;
        for(int i=2; i<=n/2; i++){
            if(is(i) && is(n-i)){
                sum++;
            }
        }
        System.out.println(sum);
    }
    //判断是否为素数
    //素数即只能被1和其自身整除的数
    public static boolean is(int n){
        for(int i=2; i<=Math.sqrt(n); i++){
            //如果其能够被其他数整除，则返回false，否则返回true
            if(n % i == 0)
                return false;
        }  return true;
    }
}
