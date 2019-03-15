package com.jack.leetcode;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @Author: Jack
 * @Date: 2019/3/14 20:59
 * LeetCode 130
 * 给定一个二维的矩阵，包含 'X' 和 'O'（字母 O）
 * 找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。
 * 被围绕的区间不会存在于边界上，换句话说，任何边界上的 'O' 都不会被填充为 'X'。
 * 任何不在边界上，或不与边界上的 'O' 相连的 'O' 最终都会被填充为 'X'。
 * 如果两个元素在水平或垂直方向相邻，则称它们是“相连”的。
 */
public class SurroundedRegions {
    public static char[][] board = {
            {'X', 'X', 'O', 'X'},
            {'X', 'O', 'X', 'X'},
            {'X', 'O', 'O', 'X'},
            {'X', 'X', 'X', 'X'},
            {'X', 'O', 'X', 'X'}};
    public static void main(String[] args) {
//        new SurroundedRegions().solve1(board);
        new SurroundedRegions().solve2(board);
        System.out.println(Arrays.deepToString(board));
    }
    private void solve1(char[][] board) {
        int row = board.length;
        if (row < 2)
            return;
        int col = board[0].length;
        if (col < 2)
            return;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == 'O') {
                    HashSet<Integer> set = new HashSet<>();
                    if (helper(board, i, j, set, false)) {
                        helps('O', set, board);
                    } else {
                        helps('X', set, board);
                    }
                }
            }
        }
        for (int i = 0 ; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'O';
                }
            }
        }
    }
    private void solve2(char[][] board) {
        if (board.length == 0)
            return;
        int row = board.length;
        int col = board[0].length;
        for (int i = 0; i < row; i++) {
            if (board[i][0] == 'O') {
                dfs(board, i, 0);
            }
            if (board[i][col - 1] == 'O') {
                dfs(board, i, col - 1);
            }
        }
        for (int i = 1; i < col - 1; i++) {
            if (board[0][i] == 'O')
                dfs(board, 0, i);
            if (board[row - 1][i] == 'O')
                dfs(board, row - 1, i);
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j]  == '1') {
                    board[i][j] = 'O';
                } else {
                    board[i][j] = 'X';
                }
            }
        }
    }
    private void dfs(char[][] board, int m, int n) {
        if (board[m][n] != 'O')
            return;
        board[m][n] = '1';
        if (m < board.length - 2)
            dfs(board, m + 1, n);
        if (m > 1)
            dfs(board, m - 1, n);
        if (n < board[0].length - 2)
            dfs(board, m, n + 1);
        if (n > 1)
            dfs(board, m, n - 1);
    }
    private void helps(char ch, HashSet<Integer> set, char[][] board) {
        for (int i : set) {
            int row = i / board[0].length;
            int col = i % board[0].length;
            board[row][col] = ch;
        }
    }
    private boolean helper(char[][] board, int num1, int num2, HashSet<Integer> set, boolean flag) {
        boolean result = flag;
        if (num1 - 1 >= 0 && board[num1 - 1][num2] == 'O') {
            int num = (num1 - 1) * board[0].length + num2;
            if (!set.contains(num)) {
                set.add(num);
                result = result || helper(board, num1 - 1, num2, set, flag);
            }
        }
        if (num1 + 1 < board.length && board[num1 + 1][num2] == 'O') {
            int num = (num1 + 1) * board[0].length + num2;
            if (!set.contains(num)) {
                set.add(num);
                result = result || helper(board, num1 + 1, num2, set, flag);
            }
        }
        if ( num2 - 1 >= 0 && board[num1][num2 - 1] == 'O') {
            int num = num1 * board[0].length + num2 - 1;
            if( !set.contains(num) ){
                set.add(num);
                result = result || helper(board, num1, num2 - 1, set, flag);
            }
        }
        if ( num2 + 1 < board[0].length && board[num1][num2 + 1] == 'O') {
            int num = num1 * board[0].length + num2 + 1;
            if( !set.contains(num) ){
                set.add(num);
                result = result || helper(board, num1, num2 + 1, set, flag);
            }
        }
        if ( num1 == 0 || num1 == board.length - 1 || num2 == 0 || num2 == board[0].length - 1)
            return true;
        return result;
    }
}