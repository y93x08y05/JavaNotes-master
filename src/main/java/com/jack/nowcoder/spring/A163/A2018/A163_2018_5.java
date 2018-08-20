package com.jack.nowcoder.spring.A163.A2018;

import java.util.Scanner;

/**
 * Created by zhangta on 1/6/2018.
 * 一个长度为N的正整数数列A = {A[1], A[2], A[3]..., A[N]}
 * 数列A进行重新排列,使数列A满足所有的A[i] * A[i + 1](1 ≤ i ≤ N - 1)都是4的倍数
 * 输入描述
 * 输入的第一行为数列的个数t(1 ≤ t ≤ 10),
 * 接下来每两行描述一个数列A,第一行为数列长度n(1 ≤ n ≤ 10^5),
 * 第二行为n个正整数A[i](1 ≤ A[i] ≤ 10^9)
 * 对于每个数列输出一行表示是否可以满足要求,如果可以输出Yes,否则输出No。
 * 输入
 * 2
 * 3
 * 1 10 100
 * 4
 * 1 2 3 4
 * 输出
 * Yes
 * No
 */
public class A163_2018_5 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            int t = in.nextInt();
            for(int i = 0;i<t;i++){
                int n = in.nextInt();
                int a[] = new int[n];
                for(int j = 0;j<n;j++){
                    a[j] = in.nextInt();
                }
                int mod4_num=0 , mod2_num=0 , odd=0;
                for(int k = 0;k<a.length;k++){
                    if(a[k] % 4 ==0){
                        mod4_num++;
                    }else if(a[k] % 2 ==0){
                        mod2_num++;
                    }else{
                        odd++;
                    }
                }
                if(mod2_num > 0){
                    //如果2的个数大于1，则两个2可以组成一个4来用
                    //所以mod4大于等于odd时，将mod2视为odd，mod4放中间
                    if(mod4_num >= odd){
                        System.out.println("Yes");
                    }else{
                        System.out.println("No");
                    }
                }else{
                    //不存在mod2时，将mod4放中间便可
                    if(mod4_num >=(odd-1)){
                        System.out.println("Yes");
                    }else{
                        System.out.println("No");
                    }
                }
            }
        }
    }
}
