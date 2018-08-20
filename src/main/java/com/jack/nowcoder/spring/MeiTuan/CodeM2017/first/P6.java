package com.jack.nowcoder.spring.MeiTuan.CodeM2017.first;

import java.util.HashMap;
import java.util.Scanner;

/**
 * 树链是指树里的一条路径。美团外卖的形象代言人袋鼠先生
 * 最近在研究一个特殊的最长树链问题，现在树中的每个点都有
 * 一个正整数值，他想在树中找出最长的树链，使得这条树链上
 * 所有对应点的值的最大公约数大于1。请求出树链的长度。
 * 输入描述：
 * 第一行：整数n，1<=n<=100000，表示点的个数
 * 第2-n，每行两个整数x和表示xy之间有边，数据保证给出的是一棵树，
 * 第n+1行：n个整数，依次表示点1-n对应的权值，1<=权值<=1000000000
 * 输出描述：
 * 满足最长路径的长度
 * 输入
 * 4
 * 1 2
 * 1 3
 * 2 4
 * 6 4 5 2
 * 输出
 * 3
 */
public class P6 {
    public static int maxLen = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        int n = sc.nextInt();
        int [][] mp = new int[n-1][2];
        for (int i=0;i<n-1;i++) {

        }
    }
    public static int gcd(int a,int b) {
        int c;
        if(a<b) {
            a=a+b;
            b=a-b;
            a=a-b;
        }
        c=a%b;
        while(a%b!=0) {
            a=b;
            b=c;
            c=a%b;
        }
        return b;
    }
//    public static void dfs(int i,int len,int val,int [][]mp){
//        maxLen=Math.max(len,maxLen);
//        int p=mp[i].length;
//        for(int j=0;j<p;j++){
//            int next=mp[i][j];
//            int gys=gcd(val,v[next]);
//            if(gys==1){
//                dfs(next, 1, v[next]);
//            }else{
//                dfs(next, len+1, gys,mp);
//            }
//        }
//    }
}