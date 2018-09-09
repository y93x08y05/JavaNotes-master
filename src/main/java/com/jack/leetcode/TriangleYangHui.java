package com.jack.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jack on 8/6/2018 12:08 PM
 * LeetCode 118
 * 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
 * 输入: 5
 * 输出:
 * [
 *      [1],
 *     [1,1],
 *    [1,2,1],
 *   [1,3,3,1],
 *  [1,4,6,4,1]
 * ]
 */
public class TriangleYangHui {
    public static void main(String[] args) {
        int numRows = 5;
        List<List<Integer>> lists = generate(numRows);
        for (int i=0;i<lists.size();i++) {
            for (int j=0;j<lists.get(i).size();j++) {
                System.out.print(lists.get(i).get(j) +" ");
            }
            System.out.println();
        }
    }
    private static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> lists = new ArrayList<>();
        if (numRows < 0)
            return null;
        for (int i=0;i<numRows;i++) {
            List<Integer> list = new ArrayList<>();
            list.add(0,1);
            for (int j=1;j<i;j++) {
                if (i-1 >= 0) {
                    List<Integer> last = lists.get(i-1);
                    int num = last.get(j-1) + last.get(j);
                    list.add(j,num);
                }
            }
            if (i > 0)
                list.add(i,1);
            lists.add(i,list);
        }
        return lists;
    }
}
