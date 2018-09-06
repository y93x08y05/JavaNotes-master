package com.jack.nowcoder.autumn.MEITUAN;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @Author: Jack
 * @Date: 2018/9/6 18:40
 * 小明拿到了一个数列a1 , a2 , ... an ，
 * 小明想知道存在多少个区间[l,r]同时满足下列两个条件：
 * 1、r-l+1=k;
 * 2、在a l , a l+1,...ar中，存在一个数至少出现了 t 次。
 * 输出满足条件的区间个数。
 * 输入
 * 输入第一行三个整数n,k,t(1≤n,k,t≤105。
 * 第二行 n 个整数，a1 , a2 , ... an (1≤ai≤105)。
 * 输出
 * 输出一个数，问题的答案。
 * 样例输入
 * 5 3 2
 * 3 1 1 1 2
 * 样例输出
 * 3
 * 区间[1,3]中1出现了2次，区间[2,4]中1出现了3次，
 * 区间[3,5]中1出现了2次。所以一共有3个区间满足条件。
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int k=sc.nextInt();
        int t=sc.nextInt();
        int []arr=new int[n];
        for (int i=0;i<arr.length;i++) {
            arr[i]=sc.nextInt();
        }
        System.out.println(findQuJian(arr, k, t));
    }
    private static int findQuJian(int []arr,int k,int t) {
        int count=0;
        if (arr.length==0||arr==null||arr.length<t)
            return 0;
        for (int i=0;i<arr.length-1;i++) {
            for (int j=i+1;j<arr.length;j++) {
                if (j-i+1<t) {
                    continue;
                } else {
                    if (atLeast(arr,i,j,t)) {
                        if (j-i+1==k)
                            count++;
                    } else {
                        continue;
                    }
                }
            }
        }
        return count;
    }
    private static boolean atLeast(int []arr,int i,int j,int t) {
        Map<Integer,Integer> map=new HashMap<>();
        for (int k=i;k<=j;k++) {
            if (map.containsKey(arr[k])) {
                map.put(arr[k],map.get(arr[k])+1);
            } else {
                map.put(arr[k],1);
            }
        }
        for (int val:map.values()) {
            if (val>=t)
                return true;
        }
        return false;
    }
}