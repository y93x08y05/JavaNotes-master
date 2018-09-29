package com.jack.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Author: Jack
 * @Date: 2018/9/29 14:16
 * LeetCode 140
 * 给定一个非空字符串s和一个包含非空单词列表的字典wordDict，在字符串中增加一些空格
 * 来构建一个句子，使得句子中所有的单词都在词典中，返回所有这些可能的句子。
 * 分隔时可以重复使用字典中的单词，假设字典中没有重复的单词
 * 例1：
 * 输入:
 * s = "catsanddog"
 * wordDict = ["cat", "cats", "and", "sand", "dog"]
 * 输出:
 * [
 *   "cats and dog",
 *   "cat sand dog"
 * ]
 * 例2：
 * 输入:
 * s = "pineapplepenapple"
 * wordDict = ["apple", "pen", "applepen", "pine", "pineapple"]
 * 输出:
 * [
 *   "pine apple pen apple",
 *   "pineapple pen apple",
 *   "pine applepen apple"
 * ]
 * 解释: 注意你可以重复使用字典中的单词。
 * 例3：
 * 输入:
 * s = "catsandog"
 * wordDict = ["cats", "dog", "sand", "and", "cat"]
 * 输出:
 * []
 */
public class WordBreak2 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        String []str=sc.nextLine().split(" ");
        List<String> list=new ArrayList<>();
        for (int i=0;i<str.length;i++){
            list.add(str[i]);
        }
        System.out.println(new WordBreak2().find(s, list));
    }
    List<String> result;
    private List<String> find(String s,List<String> wordDict){
        result=new ArrayList<>();
        int n=s.length();
        List<Integer> []pointer=new List[n];
        for (int i=0;i<n;i++){
            pointer[i]=new ArrayList<>();
        }
        for (int i=0;i<n;i++){
            for (int j=0;j<=i;j++){
                if (wordDict.contains(s.substring(j,i+1))&&(j==0||pointer[j-1].size()>0))
                    pointer[i].add(j);
            }
        }
        helper(pointer,s,n-1,"");
        return result;
    }
    private void helper(List<Integer> []pointer,String s,int i,String pattern){
        if (i<0){
            result.add(pattern);
            return;
        }
        for (Integer temp:pointer[i]){
            String nextPattern=pattern.length()==0?s.substring(temp,i+1):s.substring(temp,i+1)+" "+pattern;
            helper(pointer,s,temp-1,nextPattern);
        }
    }
}