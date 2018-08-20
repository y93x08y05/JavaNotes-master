package com.jack.nowcoder.spring.Alibaba;

import java.util.Scanner;

/**
 * 2018年阿里巴巴春季校园招聘测评
 * 编程题1:给定长和宽的纸片，将其切割成正方形，剩下的纸片再继续切割成正方形
 * 使得切出来的正方向纸片最小，求出所有正方形的周长之和。
 */
public class Alibaba2018 {
    public static void main(String [ ] args){
        Scanner sc= new Scanner(System.in);
        int l = Integer.parseInt(sc.next());
        int w = Integer.parseInt(sc.next());
        int sum = 0 ;
        GetResult(l,w,sum);
    }
    public static void GetResult(int l,int w,int sum){
        if(l==w){
            sum+=4*w;
            System.out.println(sum);
        }else{
            int m=l/w;
            int n=l%w;
            sum += 4*w*m;
            if(n!=0){
                GetResult(w,n,sum);
            }else{
                System.out.println(sum);
            }
        }
    }
}