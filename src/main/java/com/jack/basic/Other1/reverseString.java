package com.jack.basic.Other1;

import java.util.*;

/**
 * Created by zhangta on 1/19/2018.
 */
public class reverseString {
    public void swap(char[] arr, int begin, int end) {
        while(begin < end) {
            char temp = arr[begin];
            arr[begin] = arr[end];
            arr[end] = temp;
            begin++;
            end--;
        }
    }
    public String swapWords(String str) {
        char[] arr = str.toCharArray();
        swap(arr, 0, arr.length - 1);
//        int begin = 0;
//        for (int i = 1; i < arr.length; i++) {
//            if (arr[i] == ' ') {
//                swap(arr, begin, i - 1);
//                begin = i + 1;
//            }
//        }
        return new String(arr);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(new reverseString().swapWords(str));
    }
}
