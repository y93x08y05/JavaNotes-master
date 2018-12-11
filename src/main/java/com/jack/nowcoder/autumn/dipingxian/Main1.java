package com.jack.nowcoder.autumn.dipingxian;

import java.util.Scanner;

/**
 * @Author: Jack
 * @Date: 2018/11/18 10:09
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        float[] res = new float[n];
        for (int i = 0; i < n; i++) {
            res[i] = sc.nextFloat();
        }
        find(res);
    }
    public static void find(float[] res) {
        if (res == null || res.length <= 1) {
            System.out.println(0 + " " + 0 + " " + 0);
        } else {
            float temp1 = Float.MAX_VALUE;
            float temp2 = Float.MAX_VALUE;
            int x = 0;
            int y = 0;
            for (int i = 0; i < res.length-1; i++) {
                float tmp = res[i];
                for (int j = i + 1; j < res.length; j++) {
                    tmp += res[j];
                    if (temp1 > Math.abs(tmp)) {
                        temp1 = Math.abs(tmp);
                        temp2 = tmp;
                        x = i;
                        y = j;
                    }
                }
            }
            System.out.print(x + " " + y + " ");
            System.out.printf("%.1f\n", temp2);
        }
    }
}