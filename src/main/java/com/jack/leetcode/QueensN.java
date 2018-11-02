package com.jack.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Jack on 8/12/2018 9:16 PM
 * LeetCode 51
 * n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，
 * 并且使皇后彼此之间不能相互攻击。
 * 给定一个整数 n，返回所有不同的 n 皇后问题的解决方案。
 * 每一种解法包含一个明确的 n 皇后问题的棋子放置方案，
 * 该方案中 'Q' 和 '.' 分别代表了皇后和空位。
 */
public class QueensN {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(findQueen(n).size());
    }
    private static List<List<String>> findQueen(int n) {
        List<List<String>> res = new ArrayList<>();
        int [] queenList = new int[n];
        placeQueen(queenList, 0, n, res);
        return res;
    }
    private static void placeQueen(int [] queenList, int row, int n, List<List<String>> res) {
        if (row == n) {
            ArrayList<String> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                String str = "";
                for (int col = 0; col < n; col++) {
                    if (queenList[i] == col)
                        str += "Q";
                    else
                        str += ".";
                }
                list.add(str);
            }
            res.add(list);
        }
        for (int col = 0; col < n; col++) {
            if (isValid(queenList, row, col)) {
                queenList[row] = col;
                placeQueen(queenList, row + 1, n, res);
            }
        }
    }
    private static boolean isValid(int [] queenList, int row, int col) {
        for (int i = 0; i < row; i++) {
            int pos = queenList[i];
            if (pos == col)
                return false;
            if (pos + row - i == col)
                return false;
            if (pos - row + i == col)
                return false;
        }
        return true;
    }
}
