package com.jack.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Jack
 * @Date: 2018/9/6 10:14
 * LeetCode 37
 * 编写一个程序，通过已填充的空格来解决数独问题。
 * 一个数独的解法需遵循如下规则：
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
 * 空白格用 '.' 表示。
 * 答案被标成红色。
 * 给定的数独序列只包含数字 1-9 和字符 '.' 。
 * 你可以假设给定的数独只有唯一解。
 * 给定数独永远是 9x9 形式的。
 * 回溯算法也叫试探法，基本思想是从一条路往前走，能进则进，
 * 不能进则退回来，换一条路再试。
 */
public class SolveSudoku {
    public static void main(String[] args){
        SolveSudoku sol = new SolveSudoku();
        char[][] chars1 = {
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}};
        char[][] chars2 = {
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}};
        solveSudotu0(chars1);
        boolean result = sol.solveSudoku(chars2);
        System.out.println(result);
        for(char[] ch : chars2){
            for(char c : ch){
                System.out.print(String.valueOf(c) + " ");
            }
            System.out.println();
        }

    }
    private static void solveSudotu0(char[][] board) {
        solve(board);
    }
    private static boolean solve(char[][] board) {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (board[row][col] == '.') {
                    for (char i = '1'; i <= '9'; i++) {
                        board[row][col] = i;
                        if (isValid0(board, row, col) && solve(board))
                            return true;
                        board[row][col] = '.';
                    }
                    return false;
                }
            }
        }
        return true;
    }
    private static boolean isValid0(char[][] board, int row, int col) {
        for (int i = 0; i < 9; i++) {
            if (i != col && board[row][i] == board[row][col])
                return false;
        }
        for (int i = 0; i < 9; i++) {
            if (i != row && board[i][col] == board[row][col])
                return false;
        }
        int beginRow = 3 * (row / 3);
        int beginCol = 3 * (col / 3);
        for (int i = beginRow; i < beginRow + 3; i++) {
            for (int j = beginCol; j < beginCol + 3; j++) {
                if (i != row&&j != col && board[i][j] == board[row][col])
                    return false;
            }
        }
        return true;
    }
    public boolean solveSudoku(char[][] board) {
        int nextNode = nextNode(board);
        return solveSudoku(board, nextNode);
    }
    private boolean solveSudoku(char[][] board, int Node){
        List<Integer> list = available(board, Node);
        if(list.isEmpty()){
            return false;
        }
        int line = Node / 10;
        int col = Node % 10;
        for(int node : list){
            board[line][col] = (char)(node + '0');
            int nextNode = nextNode(board);
            if(nextNode == -1){
                return true;
            }else if(solveSudoku(board, nextNode)){
                return true;
            }
        }
        board[line][col] = '.';
        return false;
    }
    private List<Integer> available(char[][] board, int Node){
        boolean[] flags = new boolean[9];
        int line = Node / 10;
        int col = Node % 10;
        for(int m = 0; m < 3; m++){
            for(int n = 0; n < 3; n++){
                char ch = board[m + line / 3 * 3][n + col / 3 * 3];
                if(ch != '.'){
                    flags[Integer.parseInt(String.valueOf(ch)) - 1] = true;
                }
            }
        }
        for(char ch : board[line]){
            if(ch != '.'){
                flags[Integer.parseInt(String.valueOf(ch)) - 1] = true;
            }
        }
        for(int i = 0; i < 9; i++){
            char ch = board[i][col];
            if(ch != '.'){
                flags[Integer.parseInt(String.valueOf(ch)) - 1] = true;
            }
        }
        List<Integer> result = new ArrayList<>();
        for(int i = 0; i < 9; i++){
            if(!flags[i]){
                result.add(i + 1);
            }
        }
        return result;
    }
    private int nextNode(char[][] board){
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                if(board[i][j] == '.'){
                    return (i * 10 + j);
                }
            }
        }
        return -1;
    }
}
