package com.jack.leetcode;

import java.util.*;

/**
 * Created by Jack on 8/12/2018 2:47 PM
 * LeetCode 56
 * 给出一个区间的集合，请合并所有重叠的区间。
 * 例1:
 * 输入: [[1,3],[2,6],[8,10],[15,18]]
 * 输出: [[1,6],[8,10],[15,18]]
 * 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * 例2:
 * 输入: [[1,4],[4,5]]
 * 输出: [[1,5]]
 * 解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
 */
public class MergeInterval {
    private static class Interval {
        int start;
        int end;
        Interval() {
            start = 0;
            end = 0;
        }
        Interval(int start,int end) {
            this.start = start;
            this.end = end;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Interval> intervalList = new ArrayList<>();
        int n = sc.nextInt();
        sc.nextLine();
        for (int i=0;i<n;i++) {
            intervalList.add(new Interval(sc.nextInt(),sc.nextInt()));
        }
        List<Interval> list = mergeInterval(intervalList);
        StringBuilder sb = new StringBuilder();
        for (int i=0;i<list.size();i++) {
            sb.append(list.get(i).start).append(",").append(list.get(i).end);
            if (i!=list.size()-1)
                sb.append(";");
        }
        System.out.println(sb.toString());
    }
    private static List<Interval> mergeInterval(List<Interval> intervals) {
        int len = intervals.size();
        if (len<=1)
            return intervals;
        Collections.sort(intervals,new IntervalComparator());
        Interval newInterval = intervals.get(0);
        List<Interval> res = new ArrayList<>();
        for (int i=1;i<len;i++) {
            Interval interval = intervals.get(i);
            if (newInterval.end<interval.start) {
                res.add(newInterval);
                newInterval = interval;
            } else {
                newInterval = new Interval(newInterval.start,Math.max(newInterval.end,interval.end));
            }
        }
        res.add(newInterval);
        return res;
    }
    static class IntervalComparator implements Comparator<Interval> {

        @Override
        public int compare(Interval o1, Interval o2) {
            return o1.start-o2.start;
        }
    }
}
