package com.jack.leetcode;

/**
 * @Author: Jack
 * @Date: 2018/9/20 13:16
 * LeetCode 79
 * 单词搜索
 * 给定一个二维网格和一个单词，找出该单词是否存在于网格中。
 * 单词必须按照字母顺序，通过相邻的单元格内的字母组成，
 * 其中“相邻”单元格是那些水平相邻或者垂直相邻的单元格。
 * 同一个单元格内的字母不允许被重复使用。
 * 例:
 * board =
 * [
 *   ['A','B','C','E'],
 *   ['S','F','C','S'],
 *   ['A','D','E','E']
 * ]
 * 给定 word = "ABCCED", 返回 true.
 * 给定 word = "SEE", 返回 true.
 * 给定 word = "ABCB", 返回 false.
 */
public class ExistWordMatrix {
    public static void main(String[] args) {
        ExistWordMatrix matrix=new ExistWordMatrix();
        char [][]chars={{'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'}};
        String word="ABCCED";
        System.out.println(matrix.exist(chars, word));
    }
    public boolean resultFlag=false;
    public boolean exist(char [][]board,String word) {
        int row=board.length;
        int col=board[0].length;
        for (int i=0;i<row;i++) {
            for (int j=0;j<col;j++) {
                if (board[i][j]==word.charAt(0)) {
                    boolean [][]isVisited=new boolean[row][col];
                    isVisited[i][j]=true;
                   dfs(board,isVisited,word,1,i,j);
                   if (resultFlag==true)
                       return true;
                }
            }
        }
        return false;
    }
    public void dfs(char [][]board,boolean [][]isVisited,String word,int index,int row,int col) {
        if (index==word.length()) {
            resultFlag=true;
            return;
        }
        if (row-1>=0&&board[row-1][col]==word.charAt(index)
                &&isVisited[row-1][col]==false
                &&resultFlag==false) {
            isVisited[row-1][col]=true;
            dfs(board,isVisited,word,index+1,row-1,col);
            isVisited[row-1][col]=false;
        }
        if (row+1<=board.length-1&&board[row+1][col]==word.charAt(index)
                &&isVisited[row+1][col]==false
                &&resultFlag==false) {
            isVisited[row+1][col]=true;
            dfs(board,isVisited,word,index+1,row+1,col);
            isVisited[row+1][col]=false;
        }
        if (col-1>=0&&board[row][col-1]==word.charAt(index)
                &&isVisited[row][col-1]==false
                &&resultFlag==false) {
            isVisited[row][col-1]=true;
            dfs(board,isVisited,word,index+1,row,col-1);
            isVisited[row][col-1]=false;
        }
        if (col+1<=board[0].length-1&&board[row][col+1]==word.charAt(index)
                &&isVisited[row][col+1]==false
                &&resultFlag==false) {
            isVisited[row][col+1]=true;
            dfs(board,isVisited,word,index+1,row,col+1);
            isVisited[row][col+1]=false;
        }
    }
}