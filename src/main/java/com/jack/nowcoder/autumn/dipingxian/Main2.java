package com.jack.nowcoder.autumn.dipingxian;

import java.util.Scanner;

/**
 * @Author: Jack
 * @Date: 2018/11/18 10:09
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Integer n = sc.nextInt();
        boolean flag = false;
        int index = 0;
        while (sc.hasNext()) {
            Integer temp = sc.nextInt();
            if (temp.equals(n)) {
                System.out.println(index);
                flag  = true;
                break;
            }
            index++;
        }
        if (!flag) {
            System.out.println(-1);
        }
    }
}