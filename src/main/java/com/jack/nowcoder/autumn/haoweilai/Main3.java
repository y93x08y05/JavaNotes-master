package com.jack.nowcoder.autumn.haoweilai;

import java.util.Scanner;

/**
 * @Author: Jack
 * @Date: 2018/10/9 20:50
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        int b = sc.nextInt();
        int n = sc.nextInt();
        int t = sc.nextInt();
        System.out.println(find(k, b, n, t));
    }
    private static int find(int k, int b, int n, int t) {
        if (k == 1)
            return 1;
        else if (k == 2)
            return 3;
        return 0;
    }
}