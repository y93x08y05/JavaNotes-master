package com.jack.nowcoder.autumn.weimeng;

import java.util.Scanner;

/**
 * @Author: Jack
 * @Date: 2018/10/9 19:02
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String [] strings = sc.nextLine().split(":");
        String str1 = strings[0];
        String str2 = strings[1];
        String num1=new StringBuilder(str1).reverse().toString();
        String num2=new StringBuilder(str2).reverse().toString();
        System.out.println(find(num1, num2));
    }
    public static String find(String s1, String s2) {
        String result="";
        int len1=s1.length();
        int len2=s2.length();
        int maxLen=len1>len2?len1:len2;
        int arr []=new int[maxLen+1];
        boolean flag = false;
        if (len1<len2) {
            for (int i=len1;i<len2;i++) {
                s1+="0";
            }
        } else if (len1>len2) {
            for (int i=len2;i<len1;i++) {
                s2+="0";
            }
        }
        for (int i=0;i<maxLen;i++) {
            if (flag) {
                arr[i]=Integer.parseInt(s1.charAt(i)+"")+Integer.parseInt(s2.charAt(i)+"")+1;
            } else {
                arr[i]=Integer.parseInt(s1.charAt(i)+"")+Integer.parseInt(s2.charAt(i)+"");
            }
            flag= find(arr,i);
        }
        if (flag) {
            arr[maxLen]=1;
        } else {
            arr[maxLen]=0;
        }
        for (int i=0;i<arr.length;i++) {
            result+=String.valueOf(arr[i]);
        }
        String result1=new StringBuilder(result).reverse().toString();
        return result1;
    }
    public static boolean find(int []arr, int i) {
        boolean flag;
        if (arr[i]>=10) {
            arr[i]=arr[i]-10;
            flag=true;
        } else {
            flag = false;
        }
        return flag;
    }
}