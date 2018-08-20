package com.jack.nowcoder.spring.campus2017;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by zhangta on 3/16/2018.
 * 有一个X*Y的网格，小团要在此网格上从左上角到右下角，只能走格点且只能向右或向下走。
 * 请设计一个算法，计算小团有多少种走法。给定两个正整数int x,int y，请返回小团的走法数目
 * 输入包括一行，逗号隔开的两个正整数x和y，取值范围[1,10]。
 * 输出包括一行，为走法的数目。
 * 输入 3 2
 * 输出 10
 */
public class grid {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
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
                System.out.println("matrix["+i+"]"+"["+j+"]="+matrix[i][j]);
            }
        }
        System.out.println(matrix[x][y]);
    }
}
