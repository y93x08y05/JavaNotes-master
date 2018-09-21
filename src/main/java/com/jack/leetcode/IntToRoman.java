package com.jack.leetcode;

import java.util.Scanner;

/**
 * @Author: Jack
 * @Date: 2018/9/21 22:44
 * LeetCode 12
 * 整数转罗马数字
 * 罗马数字包含以下七种字符： I， V， X， L，C，D 和 M。
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 */
public class IntToRoman {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        System.out.println(find(n));
    }
    private static String find(int n) {
        String ans="";
        int []arr={1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String []str={"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        for (int i=0;i<arr.length;i++) {
            while (n>=arr[i]) {
                ans+=str[i];
                n-=arr[i];
            }
        }
        return ans;
    }
}