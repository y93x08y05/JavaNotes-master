package com.jack.leetcode;

import java.util.HashSet;

/**
 * @Author: Jack
 * @Date: 2018/9/6 9:48
 * LeetCode 36
 * 判断一个 9x9 的数独是否有效。
 * 只需要根据以下规则，验证已经填入的数字是否有效即可。
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
 * 例1：
 * 输入:
 * [
 *   ["5","3",".",".","7",".",".",".","."],
 *   ["6",".",".","1","9","5",".",".","."],
 *   [".","9","8",".",".",".",".","6","."],
 *   ["8",".",".",".","6",".",".",".","3"],
 *   ["4",".",".","8",".","3",".",".","1"],
 *   ["7",".",".",".","2",".",".",".","6"],
 *   [".","6",".",".",".",".","2","8","."],
 *   [".",".",".","4","1","9",".",".","5"],
 *   [".",".",".",".","8",".",".","7","9"]
 * ]
 * 输出: true
 * 例2：
 * 输入:
 * [
 *   ["8","3",".",".","7",".",".",".","."],
 *   ["6",".",".","1","9","5",".",".","."],
 *   [".","9","8",".",".",".",".","6","."],
 *   ["8",".",".",".","6",".",".",".","3"],
 *   ["4",".",".","8",".","3",".",".","1"],
 *   ["7",".",".",".","2",".",".",".","6"],
 *   [".","6",".",".",".",".","2","8","."],
 *   [".",".",".","4","1","9",".",".","5"],
 *   [".",".",".",".","8",".",".","7","9"]
 * ]
 * 输出: false
 * 解释: 除了第一行的第一个数字从5改为8以外，空格内其他数字均与例1相同。
 * 但由于位于左上角的3x3宫内有两个8存在, 因此这个数独是无效的。
 *
 */
public class ValidSudoku {
    public static void main(String[] args) {
        char [][] arr={
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
                 };
        System.out.println(idValidSudoku0(arr));
        System.out.println(idValidSudoku1(arr));
    }
    private static boolean idValidSudoku0(char [][]board) {
        for (int i=0;i<9;i++) {
            int []bit_row=new int[9];
            int []bit_col=new int[9];
            int []bit_cube=new int[9];
            for (int j=0;j<9;j++) {
                if (board[i][j]!='.') {
                    if (bit_row[board[i][j]-'1']==1)
                        return false;
                    else
                        bit_row[board[i][j]-'1']=1;
                }
                if (board[j][i]!='.') {
                    if (bit_col[board[j][i]-'1']==1) {
                        return false;
                    } else {
                        bit_col[board[j][i]-'1']=1;
                    }
                }
                int rowIndex=3*(i/3)+j/3;
                int colIndex=3*(i%3)+j%3;
                int val=board[rowIndex][colIndex];
                if (val!='.') {
                    if (bit_cube[val-'1']==1) {
                        return false;
                    } else {
                        bit_cube[val-'1']=1;
                    }
                }
            }
        }
        return true;
    }
    private static boolean idValidSudoku1(char [][]board) {
        for (int i=0;i<9;i++) {
            HashSet<Character> row=new HashSet<>();
            HashSet<Character> column=new HashSet<>();
            HashSet<Character> cube=new HashSet<>();
            for (int j=0;j<9;j++) {
                if (board[i][j]!='.'&&!row.add(board[i][j])) {
                        return false;
                }
                if (board[j][i]!='.'&&!column.add(board[j][i])) {
                        return false;
                }
                int rowIndex=3*(i/3)+j/3;
                int colIndex=3*(i%3)+j%3;
                char val=board[rowIndex][colIndex];
                if (val!='.'&&!cube.add(val)) {
                        return false;
                }
            }
        }
        return true;
    }
}