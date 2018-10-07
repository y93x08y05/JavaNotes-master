package com.jack.leetcode;

import java.util.Scanner;

/**
 * @Author: Jack
 * @Date: 2018/10/7 11:00
 * LeetCode 914
 * 卡牌分组
 * 给定一副牌，每张牌上都写着一个整数。
 * 此时，你需要选定一个数字 X，使我们可以将整副牌按下述规则分成 1 组或更多组：
 * 每组都有 X 张牌。
 * 组内所有的牌上都写着相同的整数。
 * 仅当你可选的 X >= 2 时返回 true。
 * 例1：
 * 输入：[1,2,3,4,4,3,2,1]
 * 输出：true
 * 解释：可行的分组是 [1,1]，[2,2]，[3,3]，[4,4]
 * 例2：
 * 输入：[1,1,1,2,2,2,3,3]
 * 输出：false
 * 解释：没有满足要求的分组。
 * 例3：
 * 输入：[1]
 * 输出：false
 * 解释：没有满足要求的分组。
 * 例4：
 * 输入：[1,1]
 * 输出：true
 * 解释：可行的分组是 [1,1]
 * 例5：
 * 输入：[1,1,2,2,2,2]
 * 输出：true
 * 解释：可行的分组是 [1,1]，[2,2]，[2,2]
 */
public class HasGroupsSizeX {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int []arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(new HasGroupsSizeX().find(arr));
    }
    public boolean find(int []arr) {
        int []deck = new int[10002];
        for (int i = 0; i < arr.length; i++) {
            deck[arr[i]]++;
        }
        boolean result=false;
        for (int i = 2; i <= 10000; i++) {
            int j;
            for (j = 0; j < 10000; j++) {
                if (deck[j] % i != 0)
                    break;
            }
            if (j == 10000) {
                result = true;
                break;
            }
        }
        return result;
    }
}