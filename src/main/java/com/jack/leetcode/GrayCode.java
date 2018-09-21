package com.jack.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Author: Jack
 * @Date: 2018/9/21 22:11
 * LeetCode 89
 * 格雷编码是一个二进制数字系统，在该系统中，两个连续的数值仅有一个位数的差异。
 * 给定一个代表编码总位数的非负整数n，打印其格雷编码序列。格雷编码序列必须以0开头。
 * 例1:
 * 输入: 2
 * 输出: [0,1,3,2]
 * 解释:
 * 00 - 0
 * 01 - 1
 * 11 - 3
 * 10 - 2
 * 对于给定的 n，其格雷编码序列并不唯一。
 * 例如，[0,2,3,1] 也是一个有效的格雷编码序列。
 * 00 - 0
 * 10 - 2
 * 11 - 3
 * 01 - 1
 * 例2:
 * 输入: 0
 * 输出: [0]
 * 解释: 我们定义格雷编码序列必须以 0 开头。
 *      给定编码总位数为 n 的格雷编码序列，其长度为 2n。
 *      当 n = 0 时，长度为 20 = 1。
 *      因此，当 n = 0 时，其格雷编码序列为 [0]。
 */
public class GrayCode {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        System.out.println(find(n));
    }
    private static List<Integer> find(int n) {
        if (n==0) {
            List<Integer> list=new ArrayList<>();
            list.add(0);
            return list;
        }
        if (n==1) {
            List<Integer> list=new ArrayList<>();
            list.add(0);
            list.add(1);
            return list;
        }
        List<Integer> gray=find(n-1);
        List<Integer> list=new ArrayList<>();
        for (int i=0;i<Math.pow(2,n);i++) {
            if (i<Math.pow(2,n-1))
                list.add(gray.get(i));
            else {
                int res=gray.get((int)Math.pow(2,n)-i-1)+(int)Math.pow(2,n-1);
                list.add(res);
            }
        }
        return list;
    }
}