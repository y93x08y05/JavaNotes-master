package com.jack.nowcoder.spring.A163.A2017;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 小易有一个长度为n序列，小易想移除掉里面的重复元素，
 * 但是小易想是对于每种元素保留最后出现的那个。小易遇到了困难,
 * 希望你来帮助他
 * 输入描述
 * 输入包括两行： 第一行为序列长度n(1 ≤ n ≤ 50)
 * 第二行为n个数sequence[i](1 ≤ sequence[i] ≤ 1000)，以空格分隔
 * 输出描述
 * 输出消除重复元素之后的序列，以空格分隔，行末无空格
 * 输入例子
 * 9 100 100 100 99 99 99 100 100 100
 * 输出例子
 * 99 100
 */
public class A163_2017_3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()) {
            int n = in.nextInt();
            int[] arr = new int[n];
            List<Integer> lists = new ArrayList<>();
            for(int i = 0; i < n; i++) {
                arr[i] = in.nextInt();
            }
            for(int i = n - 1; i >= 0; --i) {
                if(!lists.contains(arr[i])) {
                    lists.add(arr[i]);
                }
            }
            for(int i = lists.size() - 1; i >= 0; --i) {
                System.out.print(lists.get(i));
                if(i != 0) {
                    System.out.print(" ");
                }
            }
        }
        in.close();
    }
}