package com.jack.leetcode;

import java.util.*;

/**
 * @Author: Jack
 * @Date: 2018/9/7 9:57
 * LeetCode 632
 * 你有 k 个升序排列的整数数组。
 * 找到一个最小区间，使得 k 个列表中的每个列表至少有一个数包含在其中。
 * 定义如果 b-a < d-c 或者在 b-a == d-c 时 a < c，则区间 [a,b] 比 [c,d] 小。
 * 例：
 * 输入:[[4,10,15,24,26], [0,9,12,20], [5,18,22,30]]
 * 输出: [20,24]
 * 解释:
 * 列表 1：[4, 10, 15, 24, 26]，24 在区间 [20,24] 中。
 * 列表 2：[0, 9, 12, 20]，20 在区间 [20,24] 中。
 * 列表 3：[5, 18, 22, 30]，22 在区间 [20,24] 中。
 * 给定的列表可能包含重复元素，所以在这里升序表示 >= 。
 * 1 <= k <= 3500
 * -105 <= 元素的值 <= 105
 */
public class SmallestRange {
    public static void main(String[] args) {
        List<List<Integer>> lists=new ArrayList<>();
        Scanner sc=new Scanner(System.in);
        int k=sc.nextInt();
        while (k>0) {
            List<Integer> list=new ArrayList<>();
            for (int i=0,len=sc.nextInt();i<len;i++) {
                list.add(sc.nextInt());
            }
            lists.add(list);
            k--;
        }
        int []arr=smallestRange(lists);
        System.out.println("区间范围是："+arr[0]+"--->"+arr[1]);
    }
    private static int[] smallestRange(List<List<Integer>> lists) {
        int curMin=0;
        int curMax=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;
        int []pointerIndex=new int[lists.size()];
        boolean flag=true;
        PriorityQueue<Integer> queue=new PriorityQueue<>(Comparator.comparingInt(i -> lists.get(i).get(pointerIndex[i])));
        for (int i=0;i<lists.size();i++) {
            queue.add(i);
            max=Math.max(max,lists.get(i).get(0));
        }
        for (int i=0;i<lists.size()&&flag;i++) {
            for (int j=0;j<lists.get(i).size()&&flag;j++) {
                int minValueLevel=queue.poll();
                if (max-lists.get(minValueLevel).get(pointerIndex[minValueLevel])<curMax-curMin) {
                    curMin=lists.get(minValueLevel).get(pointerIndex[minValueLevel]);
                    curMax=max;
                }
                pointerIndex[minValueLevel]++;
                if (pointerIndex[minValueLevel]==lists.get(minValueLevel).size()) {
                    flag=false;
                    break;
                }
                queue.offer(minValueLevel);
                max=Math.max(max,lists.get(minValueLevel).get(pointerIndex[minValueLevel]));
            }
        }
        return new int[]{curMin,curMax};
    }
}