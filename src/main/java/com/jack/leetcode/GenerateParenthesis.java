package com.jack.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Jack on 8/7/2018 3:52 PM
 * LeetCode 22
 * use '(' and ')' and to generate valid
 */
public class GenerateParenthesis {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<String> list = generateParenthesis(n);
        for (String str : list)
            System.out.println(str);
    }
    private static List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        addParenthesis(n,n,list,"");
        return list;
    }
    private static void addParenthesis(int left,int right,List<String> list,String path) {
        if (left == 0 && right == 0) {
            list.add(path);
            return;
        }
        if (left != 0)
            addParenthesis(left-1,right,list,path+"(");
        if (right != 0 && right > left)
            addParenthesis(left,right-1,list,path+")");
    }
}
