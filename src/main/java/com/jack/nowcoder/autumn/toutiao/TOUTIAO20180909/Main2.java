package com.jack.nowcoder.autumn.toutiao.TOUTIAO20180909;

import java.util.Scanner;

/**
 * @Author: Jack
 * @Date: 2018/9/9 9:48
 * 团队个数
 * 5
 * 1 0 0 1 1
 * 1 0 0 1 1
 * 0 0 1 0 0
 * 0 0 1 0 0
 * 0 0 1 0 0
 */
public class Main2 {
    public static int [][] arr1 = new int[1000][1000];
    public static int [][] arr2 = new int[1000][1000];
    public static int p=0,q=0;
    public static int sum,n;
    public static int [][] location= {{1,0},{0,1},{-1,0},{0,-1},
            {1,1},{1,-1},{-1,1},{-1,-1}};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int  n = sc.nextInt();
        for (int i=0;i<n;i++) {
            for (int j=0;j<n;j++) {
                arr1[i][j] = sc.nextInt();
            }
        }
        for (int i=0;i<n;i++) {
            for (int j=0;j<n;j++) {
                if (arr1[i][j]==1&&arr2[i][j]==0) {
                    sum = 0;
                    p++;
                    dfs(i,j);
                }
            }
        }
        System.out.println(p);
    }
    private static void dfs(int h, int l) {
        sum++;
        arr2[h][l] = 1;
        for (int i=0;i<8;i++) {
            int h1 = location[i][0] + h;
            int l1 = location[i][1] + l;
            if (check(h1,l1))
                dfs(h1,l1);
        }
    }
    private static boolean check(int h2,int l2) {
        if (h2>=0&&h2<n&&l2>=0&&l2<n&&arr1[h2][l2]==1&&arr2[h2][l2]==0)
            return true;
        return false;
    }
}