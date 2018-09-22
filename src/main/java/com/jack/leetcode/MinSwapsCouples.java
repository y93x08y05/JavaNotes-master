package com.jack.leetcode;

import java.util.Scanner;

/**
 * @Author: Jack
 * @Date: 2018/9/22 10:19
 * LeetCode 765
 * 情侣牵手
 * N 对情侣坐在连续排列的 2N 个座位上，想要牵到对方的手。
 * 计算最少交换座位的次数，以便每对情侣可以并肩坐在一起。
 * 一次交换可选择任意两人，让他们站起来交换座位。
 * 人和座位用 0 到 2N-1 的整数表示，情侣们按顺序编号，
 * 第一对是 (0, 1)，第二对是 (2, 3)，以此类推，
 * 最后一对是 (2N-2, 2N-1)。
 * 这些情侣的初始座位
 * row[i] 是由最初始坐在第 i 个座位上的人决定的。
 * 例1:
 * 输入: row = [0, 2, 1, 3]
 * 输出: 1
 * 解释: 我们只需要交换row[1]和row[2]的位置即可。
 * 例2:
 * 输入: row = [3, 2, 0, 1]
 * 输出: 0
 * 解释: 无需交换座位，所有的情侣都已经可以手牵手了。
 * len(row) 是偶数且数值在 [4, 60]范围内。
 * 可以保证row 是序列 0...len(row)-1 的一个全排列。
 */
public class MinSwapsCouples {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int []arr=new int[n];
        for (int i=0;i<n;i++) {
            arr[i]=sc.nextInt();
        }
        System.out.println(find(arr));
    }
    private static int find(int []arr) {
        int []pos=new int[arr.length];
        //记录每一个人在数组中的位置
        for (int i=0;i<arr.length;i++) {
            pos[arr[i]]=i;
        }
        int res=0;
        for (int i=0;i<arr.length;i+=2) {
            if (arr[i]/2==arr[i+1]/2) {//如果是夫妇，则不需要调整
                continue;
            }
            int where;//表示另一半的位置
            //如果为偶数，则另一半比自己大1，否则另一半比自己小1
            if (arr[i]%2==0) {
                where=pos[arr[i]/2*2+1];
            } else {
                where=pos[arr[i]/2*2];
            }
            res++;
            pos[arr[i+1]]=where;//更新位置数组并交换位置使得夫妇相邻
            swap(i+1,where,arr);
        }
        return res;
    }
    private static void swap(int i,int j,int []arr) {
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
    /**
     * O(n)解法，一次考虑两个凳子，假设不为夫妇，为了让这两个位置坐的
     * 恰好是一对夫妇，则需要调整其中一个人的位置。直到所有的夫妇相邻
     * 交换的次数即为解。
     * 将给定的row抽象成一个n个顶点的无向图(可能含重边)
     * v1--v2-----vn
     * vi和vj之间存在边，当且仅当vi和vj中至少存在一对夫妇，
     * 如vi=(0,2)，vj=(1,4)存在一对夫妇(0,1)。
     * 如vi=(0,2)，vj=(1,3)存在两对夫妇(0,1)和(2,3)。则视为存在重边
     * 数组组成的无向图，或者是估计的单个节点，或者是孤立的圈。
     * row=(0,1)是一个孤立的点，row=(0,2,1,3)则包含圈v1，v2。
     * row=[0,3,4,1,2,5,6,8,7,9]包含两个孤立的圈v1，v2，v3和v4，v5
     * 对于一个圈来说，假设n个节点，则至少需要n-1次交换使每个夫妇相邻。
     * 加入数组有n个点，m个孤立的圈，则至少需要n-m次交换即可。
     */
}