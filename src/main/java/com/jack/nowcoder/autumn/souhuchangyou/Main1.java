package com.jack.nowcoder.autumn.souhuchangyou;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @Author: Jack
 * @Date: 2018/9/15 20:47
 * 从0到n一组无序的数，其中有一个数是重复的
 * 找出其中重复的那个数
 * 输入
 * 9 6 4 2 1 3 5 7 0 1 8
 * 输出
 * 1
 * 输入
 * 3 0 2 2 1
 * 输出
 * 2
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Set<Integer> set=new HashSet<>();
        while (sc.hasNext()) {
            int n=sc.nextInt();
            if (set.contains(n)) {
                System.out.println(n);
                break;
            } else {
                set.add(n);
            }
        }
    }
}