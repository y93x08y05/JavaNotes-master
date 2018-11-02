package com.jack.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jack on 8/6/2018 1:02 PM
 * LeetCode 119
 * 给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 * 输入: 3
 * 输出: [1,3,3,1]
 */
public class TriangleYangHui2 {
    public static void main(String[] args) {
        int rowIndex = 3;
        List<Integer> list = getRow(rowIndex);
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
    }
    private static List<Integer> getRow(int rowIndex) {
        if (rowIndex < 0)
            return null;
        List<List<Integer>> lists = new ArrayList<>();
        for (int i = 0; i < rowIndex + 1; i++) {
            List<Integer> list = new ArrayList<>();
            list.add(0, 1);
            for (int j = 1; j < i; j++) {
                List<Integer> last = lists.get(i - 1);
                int num = last.get(j - 1) + last.get(j);
                list.add(j, num);
            }
            if (i > 0)
            list.add(i, 1);
            lists.add(list);
        }
        return lists.get(lists.size() - 1);
    }
}
