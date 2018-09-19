package com.jack.nowcoder.autumn.qunaer;

import java.util.Scanner;

/**
 * @Author: Jack
 * @Date: 2018/9/17 9:56
 * -100到100之间连续整数组成的最大值
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String []str=sc.nextLine().split(" ");
        int []arr=new int[str.length];
        for(int i=0;i<str.length;i++) {
            arr[i]=Integer.parseInt(str[i]);
        }
        System.out.println(findMaxSubArray(arr));
    }
    private static int findMaxSubArray(int []arr) {
        if (arr.length<=0)
            return 0;
        int max=Integer.MIN_VALUE;
        int current=0;
        for (int i=0;i<arr.length;i++) {
            if (current<0)
                current=arr[i];
            else
                current+=arr[i];
            if (current>max)
                max=current;
        }
        return max;
    }
}