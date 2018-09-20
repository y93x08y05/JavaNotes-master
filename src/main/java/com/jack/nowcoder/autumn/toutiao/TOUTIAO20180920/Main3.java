package com.jack.nowcoder.autumn.toutiao.TOUTIAO20180920;

import java.util.Scanner;

/**
 * @Author: Jack
 * @Date: 2018/9/20 20:33
 * 给定一个M*N二维的字母字典和一组单词列表，长度为K，
 * M为行数，N为列数，从词典中找出所有单词，单词要遵循的
 * 规则是所有的字母要在词典中是相邻的，可以上下相邻也可以
 * 左右相邻，词典中每个字母单元只能使用一次。
 * 输入描述：
 * 第一行三个整数分别代表M，N，K
 * 第二行K个单词
 * 第三行到第N+3行为词典
 * 输出描述：
 * 找到的单词，每行一个
 * 例1：
 * 输入：
 * 5 5 3
 * hello help high
 * p a b h m
 * f h e c p
 * o i l l h
 * b g h o n
 * h x c m l
 * 输出：
 * hello
 * high
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int M=sc.nextInt();
        int N=sc.nextInt();
        int K=sc.nextInt();
        sc.nextLine();
        String []words=sc.nextLine().split(" ");
        char [][]chars=new char[N][M];
        for (int i=0;i<N;i++) {
            for (int j=0;j<M;j++) {
                chars[i][j]=sc.next().toCharArray()[0];
            }
        }
        Main3 matrix2=new Main3();
        matrix2.findWords(chars, words);
    }
    private void findWords(char [][]board, String []words) {
        Trie trie=new Trie();
        for (String s:words) {
            trie.insert(s);
        }
        int n=board.length;
        if (n<1)
            return;
        int m=board[0].length;
        boolean [][]visited=new boolean[n][m];
        for (int i=0;i<n;i++) {
            for (int j=0;j<m;j++) {
                findWords(board,visited,"",i,j,trie);
            }
        }
        return;
    }
    public void findWords(char [][]board,boolean [][]visited,String str,int x,int y,Trie trie) {
        if (x<0||x>=board.length||y<0||y>=board[0].length)
            return;
        if (visited[x][y])
            return;
        String newStr=str+board[x][y];
        if (!trie.startWith(newStr))
            return;
        if (trie.search(newStr))
            System.out.println(newStr);
        visited[x][y]=true;
        findWords(board,visited,newStr,x-1,y,trie);
        findWords(board,visited,newStr,x+1,y,trie);
        findWords(board,visited,newStr,x,y-1,trie);
        findWords(board,visited,newStr,x,y+1,trie);
        visited[x][y]=false;
    }
}
class Trie {
    private TrieNode root;
    public Trie() {
        root=new TrieNode();
    }
    public void insert(String word) {
        TrieNode node=this.root;
        for (char c:word.toCharArray()) {
            if (node.children[c-'a']==null) {
                node.children[c-'a']=new TrieNode();
            }
            node=node.children[c-'a'];
        }
        node.item=word;
    }
    public boolean search(String word) {
        TrieNode node=this.root;
        for (char c:word.toCharArray()) {
            if (node.children[c-'a']==null) {
                return false;
            }
            node=node.children[c-'a'];
        }
        return node.item.equals(word);
    }
    public boolean startWith(String prefix) {
        TrieNode node=this.root;
        for (char c:prefix.toCharArray()) {
            if (node.children[c-'a']==null) {
                return false;
            }
            node=node.children[c-'a'];
        }
        return true;
    }
}
class TrieNode {
    TrieNode []children=new TrieNode[26];
    String item="";
    public TrieNode() {

    }
}