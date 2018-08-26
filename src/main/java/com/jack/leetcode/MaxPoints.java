package com.jack.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Jack on 8/24/2018 10:08 PM
 * LeetCode 149
 * let more point in one line and return max value
 */
public class MaxPoints {
    static class Point {
        int x;
        int y;
        Point() {
            x=0;
            y=0;
        }
        Point(int x,int y) {
            this.x=x;
            this.y=y;
        }
    }
    public static void main(String[] args) {
        Point [] points=new Point[3];
        int [][] temp={{0,0},{94911151,94911150},{94911152,94911151}};
        for (int i=0;i<points.length;i++) {
            points[i]=new Point(temp[i][0],temp[i][1]);
        }
        MaxPoints maxPoints=new MaxPoints();
        System.out.println(maxPoints.findMaxPoints0(points));
        System.out.println(maxPoints.findMaxPoints1(points));
    }
    //could return right answer based on LeetCode
    private int findMaxPoints0(Point [] points) {
        if (points.length<3)
            return points.length;
        int max=0;
        for (int i=0;i<points.length;i++) {
            for (int j=0;j<points.length;j++) {
                if (i==j)
                    continue;
                int cnt1=2;
                int cnt2=2;
                if (points[i].y==points[j].y) {
                    for (int k=0;k<points.length;k++) {
                        if (k==i||k==j)
                            continue;
                        if (points[k].y==points[i].y)
                            cnt2++;
                    }
                } else {
                    double k1=(double)(points[j].x-points[i].x)/(points[j].y-points[i].y);
                    for (int k=0;k<points.length;k++) {
                        if (k==i||k==j)
                            continue;
                        double k2=(double)(points[k].x-points[i].x)/(points[k].y-points[i].y);
                        double k3=(double)(points[k].x-points[j].x)/(points[k].y-points[j].y);
                        if (k1==k2||k1==k3)
                            cnt1++;
                    }
                }
                if (cnt1>max)
                    max=cnt1;
                if (cnt2>max)
                    max=cnt2;
            }
        }
        return max;
    }
    //time complexity is O(n^2) and space complexity is O(n)
    private int findMaxPoints1(Point [] points) {
        if (points.length<3)
            return points.length;
        int max=0;
        Map<Double,Integer> map=new HashMap<>();
        for (int i=0;i<points.length;i++) {
            map.clear();
            int duplicate=1;
            for (int j=0;j<points.length;j++) {
                if (i==j)
                    continue;
                double slope;
                if (points[i].x==points[j].x&&points[i].y==points[j].y) {
                    duplicate++;
                    continue;
                } else if (points[i].x==points[j].x) {
                    slope=Integer.MAX_VALUE;
                } else {
                    slope=1.0*(points[i].y-points[j].y)/(points[i].x-points[j].x);
                }
                map.put(slope,map.containsKey(slope)?map.get(slope)+1:1);
            }
            if (map.keySet().size()==0) {
                max=duplicate>max?duplicate:max;
            } else {
                for (double key:map.keySet()) {
                    max=Math.max((duplicate+map.get(key)),max);
                }
            }
        }
        return max;
    }
}
