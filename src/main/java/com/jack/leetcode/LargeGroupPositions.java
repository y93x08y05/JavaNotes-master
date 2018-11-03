package com.jack.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Author: Jack
 * @Date: 2018/10/7 9:53
 * LeetCode 830
 * 较大分组的位置
 * 在一个由小写字母构成的字符串S中，包含由一些连续的相同字符所构成的分组。
 * 我们称所有包含大于或等于三个连续字符的分组为较大分组。
 * 找到每一个较大分组的起始和终止位置。
 * 最终结果按照字典顺序输出。
 * 例1:
 * 输入: "abbxxxxzzy"
 * 输出: [[3,6]]
 * 解释: "xxxx" 是一个起始于 3 且终止于 6 的较大分组。
 * 例2:
 * 输入: "abc"
 * 输出: []
 * 解释: "a","b" 和 "c" 均不是符合要求的较大分组。
 * 例3:
 * 输入: "abcdddeeeeaabbbcd"
 * 输出: [[3,5],[6,9],[12,14]]
 */
public class LargeGroupPositions {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(new LargeGroupPositions().find(s));
    }
    public List<List<Integer>> find(String s) {
        List<List<Integer>> lists = new ArrayList<>();
        if (s == null || s.length() < 3)
            return lists;
        int i, j;
        for (i = 0; i < s.length() - 2; i = j) {
            for (j = i + 1; j < s.length(); j++) {
                if (s.charAt(j) != s.charAt(i)) {
                    if (j - i >= 3) {
                        List<Integer> list = new ArrayList<>();
                        list.add(i);
                        list.add(j - 1);
                        lists.add(list);
                    }
                    break;
                }
                if (j == s.length() - 1) {
                    if (j - i >= 2) {
                        List<Integer> list = new ArrayList<>();
                        list.add(i);
                        list.add(j);
                        lists.add(list);
                    }
                    break;
                }
            }
        }
        return lists;
    }
}