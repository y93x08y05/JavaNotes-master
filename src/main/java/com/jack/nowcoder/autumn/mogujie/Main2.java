package com.jack.nowcoder.autumn.mogujie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

/**
 * @Author: Jack
 * @Date: 2018/9/27 19:31
 * 给定一个字符串s和包含多个单词的字典
 * 在字符串s中加多个空格构成一个句子，每一个单词都是一个有效的
 * 字典单词，返回所有的句子。
 * 输入描述：
 * s="catsanddog"
 * dict="cat","cats","and","sand","dog";
 * 输出描述：
 * cats and dog,cat sand dog
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        String []str=sc.nextLine().split(" ");
        List<String> res=new ArrayList<>();
        for (int i=0;i<str.length;i++){
            res.add(str[i]);
        }
        System.out.println(find(s, res));
    }
    public static List<String> find(String s,List<String> dict){
        if (s==null||s.length()==0||dict==null||dict.size()==0)
            return new ArrayList<>();
        return dfs(s,dict,new HashMap<>());
    }
    private static List<String> dfs(String s, List<String> dict, HashMap<String,List<String>> map){
        if (map.containsKey(s)){
            return map.get(s);
        }
        List<String> res=new ArrayList<>();
        if (s.length()==0) {
            res.add("");
            return res;
        }
        for (String tmp:dict){
            if (s.startsWith(tmp)){
                for (String str:dfs(s.substring(tmp.length()),dict,map)){
                    res.add(tmp+(str==""?"":" ")+str);
                }
            }
        }
        map.put(s,res);
        return res;
    }
}