package com.jack.nowcoder.duoduopin;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by Jack on 8/4/2018 7:10 PM
 * 假设一个探险家被困在了地底的迷宫中，要从当前位置开始找到一条通往迷宫的路径，迷宫可以
 * 用一个二维矩阵组成，有的部分是墙，有的部分是路，迷宫之中有的路上还有门，每扇门都在
 * 迷宫的某个地方有与之匹配的钥匙，只有先拿到钥匙才能打开门。请设计一个算法，帮助
 * 探险家找到脱困的最短途径。二维矩阵每个元素的值的含义如下
 * 0-墙 1-路 2-探险家的起始位置 3-迷宫的出口，大写字母-门，小写字母-对应大写字母
 * 所代表的门的钥匙
 * 输入描述：
 * 迷宫的地图，用二维矩阵表示，第一行是表示矩阵的行数和列数M和N
 * 后面的M行是矩阵的数据，M和N都不超过100，门不超过10扇。
 * 输出描述：
 * 路径的长度，是一个整数
 * 输入例子
 * 5 5
 * 02111
 * 01a0A
 * 01003
 * 01001
 * 01111
 * 输出例子
 * 7
 */
public class PathFinding {
    public static int [][] next = {{1,0},{-1,0},{0,1},{0,-1}};
    public static boolean [][][] flag;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine();
        flag = new boolean [n][m][1025];
        char [][] chars = new char[n][m];
        for (int i=0;i<n;i++) {
            chars[i] = sc.nextLine().toCharArray();
        }
        for (int i=0;i<n;i++) {
            for (int j=0;j<m;j++) {
                if (chars[i][j] == '2') {
                    System.out.println(BFSFind(i,j,n,m,chars));
                }
            }
        }
    }
    private static int BFSFind(int i,int j,int n,int m,char [][] chars) {
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(new Node(i,j,0,0));
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            for (int k=0;k<4;k++) {
                int tempX = node.x + next[k][0];
                int tempY = node.y + next[k][1];
                int key = node.key;
                int temp = node.temp + 1;
                if (tempX<0||tempX>=n||tempY<0||tempY>=m||chars[tempX][tempY]=='0') {
                    continue;
                }
                if (chars[tempX][tempY]=='3')
                    return temp;
                if (chars[tempX][tempY]<='z'&&chars[tempX][tempY]>='a')
                    key = key|1<<(chars[tempX][tempY]-'a');
                if (chars[tempX][tempY]<='Z' && chars[tempX][tempY]>='A' && (key & (1<<(chars[tempX][tempY]-'A')))==0)
                    continue;
                if (!flag[tempX][tempY][key]) {
                    flag[tempX][tempY][key] = true;
                    queue.offer(new Node(tempX,tempY,key,temp));
                }
            }
        }
        return -1;
    }
    private static class Node {
        int x;
        int y;
        int key;
        int temp;
        public Node(int x,int y,int key,int temp) {
            this.x = x;
            this.y = y;
            this.key = key;
            this.temp = temp;

        }
    }
}
