package com.jack.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by Jack on 8/26/2018 8:53 PM
 * LeetCode 407
 * 接雨水2
 * 给定一个m x n的矩阵，其中的值均为正整数，代表二维高度图每个单元的高度，
 * 请计算图中形状最多能接多少体积的雨水。
 * m 和 n 都是小于110的整数。每一个单位的高度都大于0 且小于 20000。
 * 给出如下 3x6 的高度图:
 * [
 *   [1,4,3,1,3,2],
 *   [3,2,1,3,2,4],
 *   [2,3,3,2,3,1]
 * ]
 * 返回 4。
 */
public class MaxWaterArea3 {
    public static void main(String[] args) {
        int [][]arr={{1,4,3,1,3,2},{3,2,1,3,2,4},{2,3,3,2,3,1}};
        MaxWaterArea3 maxWaterArea3=new MaxWaterArea3();
        System.out.println(maxWaterArea3.findMaxWaterArea(arr));
    }
    private int findMaxWaterArea(int [][]arr) {
        if (arr==null||arr.length==0||arr[0].length==0)
            return 0;
        int m=arr.length;
        int n=arr[0].length;
        PriorityQueue<Cell> priorityQueue=new PriorityQueue<>(Comparator.comparingInt(v -> v.h));
        boolean [][]flag=new boolean[m][n];
        for (int i=0;i<n;i++) {
            flag[0][i]=true;
            flag[m-1][i]=true;
            priorityQueue.offer(new Cell(0,i,arr[0][i]));
            priorityQueue.offer(new Cell(m-1,i,arr[m-1][i]));
        }
        for (int i=1;i<m-1;i++) {
            flag[i][0]=true;
            flag[i][n-1]=true;
            priorityQueue.offer(new Cell(i,0,arr[i][0]));
            priorityQueue.offer(new Cell(i,n-1,arr[i][n-1]));
        }
        int [] xs={0,0,1,-1};
        int [] ys={1,-1,0,0};
        int sum=0;
        while (!priorityQueue.isEmpty()) {
            Cell cell=priorityQueue.poll();
            for (int i=0;i<4;i++) {
                int nx=cell.x+xs[i];
                int ny=cell.y+ys[i];
                if (nx>=0&&nx<m&&ny>=0&&ny<n&&!flag[nx][ny]) {
                    flag[nx][ny]=true;
                    sum+=Math.max(0,cell.h-arr[nx][ny]);
                    priorityQueue.offer(new Cell(nx,ny,Math.max(arr[nx][ny],cell.h)));
                }
            }
        }
        return sum;
    }
    class Cell {
        int x,y,h;
        Cell(int x,int y,int h) {
            this.x=x;
            this.y=y;
            this.h=h;
        }
    }
}
