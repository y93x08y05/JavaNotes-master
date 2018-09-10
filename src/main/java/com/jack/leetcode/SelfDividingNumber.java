package com.jack.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Author: Jack
 * @Date: 2018/9/9 23:48
 * LeetCode 728
 * 自除数
 * 自除数是指可以被它包含的每一位数除尽的数。
 * 例如，128 是一个自除数，因为 128 % 1 == 0，128 % 2 == 0，128 % 8 == 0。
 * 还有，自除数不允许包含 0 。
 * 给定上边界和下边界数字，输出一个列表，列表的元素是边界（含边界）内所有的自除数。
 * 例：
 * 输入：
 * 上边界left = 1, 下边界right = 22
 * 输出： [1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 15, 22]
 */
public class SelfDividingNumber {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int left=sc.nextInt();
        int right=sc.nextInt();
        System.out.println(selfDividingNumber(left, right));
    }
    private static List<Integer> selfDividingNumber(int left,int right) {
        List<Integer> list=new ArrayList<>();
        for (int i=left;i<=right;i++) {
            int j=i;
            for (;j>0;j=j/10) {
                if ((j%10==0)||(i%(j%10))!=0)
                    break;
            }
            if (j==0)
                list.add(i);
        }
        return list;
    }
}