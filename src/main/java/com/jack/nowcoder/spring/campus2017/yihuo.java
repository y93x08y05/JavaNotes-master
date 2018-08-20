package com.jack.nowcoder.spring.campus2017;

import java.util.Scanner;

/**
 * Created by zhangta on 3/17/2018.
 * 给定整数m以及n各数字A1,A2,..An，将数列A中所有元素两两异或，
 * 共能得到n(n-1)/2个结果，请求出这些结果中大于m的有多少个
 * 第一行包含两个整数n,m.
 * 第二行给出n个整数A1，A2，...，An。
 * 数据范围
 * 对于30%的数据，1 <= n, m <= 1000
 * 对于100%的数据，1 <= n, m, Ai <= 10^5
 * 输出仅包括一行，即所求的答案
 * 输入
 * 3 10
 * 6 5 10
 * 输出
 * 2
 */
public class yihuo {
    public static class Tree{
        Tree [] next = new Tree[2];
        int count = 1;
    }
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n = sc.nextInt();
            int m = sc.nextInt();
            int [] a = new int[n];
            for(int i=0;i<n;i++){
                a[i] = sc.nextInt();
            }
            System.out.println(solve(a,m));
        }
    }
    private static long solve(int [] a,int m){
        Tree tree = buildTree(a);
        long result = 0;
        for(int i=0;i<a.length;i++){
            result +=queryTree(tree,a[i],m,31);
        }
        return result/2;
    }
    private static long queryTree(Tree tree,int a,int m,int index){
        if(tree==null)return 0;
        Tree current = tree;
        for(int i=index;i>=0;i--){
            int aDigit = (a>>i)&1;
            int mDigit = (m>>i)&1;
            if(aDigit==1&&mDigit==1){
                if(current.next[0]==null)
                    return 0;
                current = current.next[0];
            }else if (aDigit==0&&mDigit==1){
                if (current.next[1]==null){
                    return 0;
                }
                current = current.next[1];
            }else if (aDigit==1&&mDigit==0){
                long p = queryTree(current.next[1],a,m,i-1);
                long q = current.next[0] == null?0:current.next[0].count;
                return p+q;
            }else if ((aDigit==0&&mDigit==0)){
                long p = queryTree(current.next[0],a,m,i-1);
                long q = current.next[1] == null?0:current.next[1].count;
                return p+q;
            }
        }
        return 0;
    }
    private static Tree buildTree(int[] a){
        Tree tree = new Tree();
        for(int i=0;i<a.length;i++){
            Tree current = tree;
            for (int j=31;j>=0;j--){
                int digit = (a[i]>>j)&1;
                if (current.next[digit]==null){
                    current.next[digit] = new Tree();
                }else {
                    current.next[digit].count++;
                }
                current = current.next[digit];
            }
        }
        return tree;
    }
}
