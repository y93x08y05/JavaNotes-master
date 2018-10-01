package com.jack.nowcoder.autumn.VMware.VM20180930;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author: Jack
 * @Date: 2018/9/30 8:52
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        sc.nextLine();
        String []str=sc.nextLine().split(" ");
        System.out.println(find(str));
    }
    private static String find(String []str) {
        Arrays.sort(str, (o1, o2) -> {
            String s1 = o1+o2;
            String s2 = o2+o1;
            return s1.compareTo(s2);
        });
        StringBuffer sb = new StringBuffer();
        for(int i= str.length-1; i>=0; i--){
            sb.append(str[i]);
        }
        return sb.toString();
    }
}