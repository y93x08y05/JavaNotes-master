package com.jack.nowcoder.spring.A163.A2015;


/**
 * 任意2n个整数，从其中选出n个整数，使得选出的n个整数和同剩下的n个整数之和的差最小
 * 即从2n个数里面取n个数，满足其大小最接近所有数总和的一半
 * 即有一个没有排序，元素个数为2N的正整数数组。要求把它分割为元素个数为N的两个数组，
 * 并使两个子数组的和最接近
 * 假设数组A[1..2N]所有元素的和是SUM
 * 动态规划解0-1背包问题的策略，令S(k, i)表示前k个元素中任意i个元素的和的集合
 * S(k, 1) = {A[i] | 1<= i <= k}
 * S(k, k) = {A[1]+A[2]+…+A[k]}
 * S(k, i) = S(k-1, i) U {A[k] + x | x属于S(k-1, i-1) }
 * 递推最后找出集合S(2N, N)中与SUM最接近的那个和
 */
public class A163_2015_2 {
    public static void main(String [] args){
        int A [] = {1,2,3,5,7,8,9};
        func(A);
    }
    static void func(int A []){
        int i,j;
        int n2 = A.length;
        int n = n2/2;
        int sum = 0;
        for(i=0;i<A.length;i++){
            sum += A[i];
        }
        boolean flag[][] = new boolean[A.length+1][sum/2+1];
        for (i=0;i<A.length;i++){
            for (j=0;j<sum/2+1;j++){
                flag[i][j] = false;
            }
        }
        flag[0][0] = true;
        for(int k=0;k<n2;k++){
            for(i=0>n?n:k;i>=1;i--){
                for (j=0;j<=sum/2;j++){
                    if (j>=A[k] && flag[i-1][j-A[k]]){
                        flag[i][j] = true;
                    }
                }
            }
        }
        for (i=sum/2;i>=0;i++){
            if (flag[n][i]){
                System.out.println("sum is " + sum);
                System.out.println("sum/2 is " + sum / 2);
                System.out.println("i is " + i);
                System.out.println("minimum delta is " + Math.abs(2 * i - sum));
                break;
            }
        }
    }
}