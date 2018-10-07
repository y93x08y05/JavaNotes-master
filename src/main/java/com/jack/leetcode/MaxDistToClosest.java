package com.jack.leetcode;

import java.util.Scanner;

/**
 * @Author: Jack
 * @Date: 2018/10/7 10:32
 * LeetCode 849
 * 到最近的人的最大距离
 * 在一排座位（ seats）中，1 代表有人坐在座位上，0 代表座位上是空的。
 * 至少有一个空座位，且至少有一人坐在座位上。
 * 亚历克斯希望坐在一个能够使他与离他最近的人之间的距离达到最大化的座位上。
 * 返回他到离他最近的人的最大距离。
 * 例1：
 * 输入：[1,0,0,0,1,0,1]
 * 输出：2
 * 解释：
 * 如果亚历克斯坐在第二个空位（seats[2]）上，他到离他最近的人的距离为 2 。
 * 如果亚历克斯坐在其它任何一个空位上，他到离他最近的人的距离为 1 。
 * 因此，他到离他最近的人的最大距离是 2 。
 * 例2：
 * 输入：[1,0,0,0]
 * 输出：3
 * 解释：
 * 如果亚历克斯坐在最后一个座位上，他离最近的人有 3 个座位远。
 * 这是可能的最大距离，所以答案是 3 。
 */
public class MaxDistToClosest {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int []arr=new int[n];
        for (int i=0;i<n;i++) {
            arr[i]=sc.nextInt();
        }
        System.out.println(new MaxDistToClosest().find(arr));
    }
    public int find(int []arr) {
        int len = arr.length;
        if (len == 1)
            return 0;
        int count = 0;
        int i = 0;
        int res = 0;
        for (; i < len && arr[i] == 0; i++)
            count++;
        res = Math.max(count,res);
        count = 0;
        int j = len - 1;
        for (; j >= 0 && arr[j] == 0; j--)
            count++;
        res = Math.max(count,res);
        while (i < j) {
            for (; i < j && arr[i] == 1; i++);
            count = 0;
            for (; i < j && arr[i] == 0; i++)
                count++;
            if (count % 2 == 0)
                res = Math.max(count / 2, res);
            else
                res = Math.max(count / 2 + 1, res);
            i++;
        }
        return res;
    }
}