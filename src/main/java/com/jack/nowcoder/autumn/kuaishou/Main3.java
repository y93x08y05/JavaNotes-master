package com.jack.nowcoder.autumn.kuaishou;

import java.util.Scanner;

/**
 * @Author: Jack
 * @Date: 2018/9/10 20:17
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        int M=sc.nextInt();
        int []arr=new int[N];
        for (int i=0;i<N;i++) {
            arr[i]=sc.nextInt();
        }
        System.out.println(findHaoChiChengDu(arr));
    }
    private static int findHaoChiChengDu(int []arr) {
        if (arr.length==0||arr==null)
            return 0;
        return 0;
    }
}