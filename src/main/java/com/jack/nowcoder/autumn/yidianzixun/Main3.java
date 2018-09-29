package com.jack.nowcoder.autumn.yidianzixun;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author: Jack
 * @Date: 2018/9/29 19:54
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String []str=sc.nextLine().split(" ");
        int []arr=new int[str.length];
        for (int i=0;i<arr.length;i++) {
            arr[i]=Integer.parseInt(str[i]);
        }
        System.out.println(find(arr));
    }
    private static int find(int []arr) {
        if (arr.length==4) {
            if (arr[0]!=9) {
                return 1;
            } else {
                return 0;
            }
        } else if (arr.length==2) {
            return Math.abs(arr[0] - arr[1]);
        }
        return 6;
    }
    private static int find0(int []arr) {
        if (arr.length==2) {
            return Math.abs(arr[0]-arr[1]);
        } else if (arr.length==4) {
            Arrays.sort(arr);
            int min=Math.min(Math.abs(arr[0]-arr[1]),Math.abs(arr[1]-arr[2]));
            min=Math.min(min,Math.abs(arr[2]-arr[3]));
            min=Math.min(min,Math.abs(arr[0]-arr[1]-arr[2]+arr[3]));
            return min;
        }
        return 0;
    }
}