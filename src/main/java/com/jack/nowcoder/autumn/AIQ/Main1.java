package com.jack.nowcoder.autumn.AIQ;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author: Jack
 * @Date: 2018/9/15 10:40
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        if (s.length()<6||s==null||s.length()>6)
            System.out.println(0);
        else
            System.out.println(findMinSwap(s.substring(0, 3), s.substring(3, s.length())));
    }
    private static int findMinSwap(String s1,String s2) {
        int sum1;
        int sum2;
        int count=0;
        int []arr1=new int[3];
        int []arr2=new int[3];
        int m=0;
        int n=0;
        for (int i=0;i<s1.length();i++) {
            if (s1.charAt(i)<'0'||s1.charAt(i)>'9')
                return 0;
            arr1[m++]=s1.charAt(i)-'0';
        }
        for (int i=0;i<s2.length();i++) {
            if (s2.charAt(i)<'0'||s2.charAt(i)>'9')
                return 0;
            arr2[n++]=s2.charAt(i)-'0';
        }
        sum1=Arrays.stream(arr1).sum();
        sum2=Arrays.stream(arr2).sum();
        if (sum1>sum2) {
            count++;
            Arrays.sort(arr2);
            for (int i=0;i<arr2.length;i++) {
                if (sum2+9-arr2[i]>=sum1) {
                    return count;
                } else {
                    sum2=sum2+9-arr2[i];
                    count++;
                }
            }
            if (count==3)
                return 0;
        } else if (sum1<sum2){
            count++;
            Arrays.sort(arr1);
            for (int i=0;i<arr1.length;i++) {
                if (sum1+9-arr1[i]>=sum2) {
                    return count;
                } else {
                    sum1=sum1+9-arr1[i];
                    count++;
                }
            }
            if (count==3)
                return 0;
        }
        return 0;
    }
}