package com.jack.nowcoder.autumn.mogujie;

import java.util.Scanner;

/**
 * @Author: Jack
 * @Date: 2018/9/27 19:28
 */
public class Main1 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String[] s = sc.nextLine().split(" ");
        int x = Integer.parseInt(s[0]);
        int y = Integer.parseInt(s[1]);
        int[][] matrix = new int[x+1][y+1];
        for (int i = 0; i <= x; i++)
            matrix[i][0] = 1;
        for (int j = 0; j <= y; j++)
            matrix[0][j] = 1;
        for (int i = 1; i <= x; i++) {
            for (int j = 1; j <= y; j++) {
                matrix[i][j] = matrix[i-1][j] + matrix[i][j - 1];
            }
        }
        System.out.println(matrix[x][y]);
    }
}