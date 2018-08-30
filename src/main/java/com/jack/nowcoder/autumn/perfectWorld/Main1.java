package com.jack.nowcoder.autumn.perfectWorld;

import java.util.Scanner;

/**
 * Created by Jack on 8/28/2018 6:24 PM
 * 输入：n,p,无向连通带权图g.g是一个n*n的邻接矩阵。
 * 如果i，j之间无法通行，则G[i][j] = -1。
 * 第p个点到其他点的最短距离。用逗号分隔。顺序为从0到n。
 * 使用迪杰斯特拉算法，计算无向带权图上任意一个节点到其他节点的距离。
 * 输入
 * 6 0
 * -1 1 4 -1 -1 -1
 * 1 -1 2 7 5 -1
 * 4 2 -1 -1 1 -1
 * -1 7 -1 -1 3 2
 * -1 5 1 3 -1 6
 * -1 -1 -1 2 6 -1
 * 输出
 * 1,3,7,4,9
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        int [][]arr=new int[n][n];
        for (int i=0;i<arr.length;i++) {
            for (int j=0;j<arr.length;j++) {
                arr[i][j]=sc.nextInt();
            }
        }
        System.out.println(dijkstra(arr, m, 6));
    }
    public static int dijkstra(int[][] W1, int start, int end) {
        boolean[] isLabel = new boolean[W1[0].length];
        int[] indexX = new int[W1[0].length];
        int i_count = -1;
        int[] distance =W1[start].clone();
        int index = start;
        int presentShortest=0;
        indexX[++i_count]=index;
        isLabel[index]=true;
        while (i_count<W1[0].length){
            int min=Integer.MAX_VALUE;
            for(int i=0;i<distance.length;i++){
                if(!isLabel[i]&&distance[i]!=-1&&i!=index){
                    if(distance[i]<min){
                        min=distance[i];
                        index=i;
                    }
                }
            }
            if(index==end){
                break;
            }
            isLabel[index]=true;
            indexX[++i_count]=index;
            if(W1[indexX[i_count-1]][index]==-1
                    ||presentShortest+W1[indexX[i_count-1]][index]>distance[index]){
                presentShortest=distance[index];
            }else{
                presentShortest+=W1[indexX[i_count-1]][index];
            }
            for(int i=0;i<distance.length;i++){
                if(distance[i]==-1&&W1[index][i]!=-1){
                    distance[i]=presentShortest+W1[index][i];
                }else if(W1[index][i]!=-1
                        &&presentShortest+W1[index][i]<distance[i]){
                    distance[i]=presentShortest+W1[index][i];
                }
            }
        }
        return distance[end]-distance[start];
    }
}
