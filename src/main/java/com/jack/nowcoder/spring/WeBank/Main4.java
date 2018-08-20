package com.jack.nowcoder.spring.WeBank;

/**
 * 求N以内所有是质数的幂的数字的个数
 */

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main4 {
    public static void main(String [] args){
        //求指定范围内的素数和由素数组成幂次数
        Set<Integer> set = new HashSet<>() ;
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        //使用标记法
        boolean [] isPrime = new boolean[n+1];
        for (int i=2;i<=n;i++){
            isPrime[i] = true;
        }
        for (int i=2;i*i<=n;i++){
            if (!isPrime[i]){
                continue;
            }
            for (int j=i*i;j<=n;j++){
                isPrime[j] = false;
            }
        }
        //统计素数
        for (int i=2;i<=n;i++){
            if (isPrime[i]){
                set.add(i);
                //对数进行幂次运算
                for (int j=1;Math.pow(i,j)<=n;j++){
                    //按幂次装入
                    set.add((int)Math.pow(i,j));
                }
            }
        }
        System.out.println(set.size());
    }
}