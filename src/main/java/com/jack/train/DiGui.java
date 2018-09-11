package com.jack.train;

/**
 * Created by Jack on 8/9/2018 9:34 AM
 */
public class DiGui {
    public static void main(String[] args) {
        int depth = 2;
        System.out.print("吓得我抱起了");
        recursion(depth);
    }
    private static void recursion(int depth) {
        System.out.print("抱着");
        if (depth <= 0) {
            System.out.print("我的小鲤鱼");
        } else {
            recursion(--depth);
            System.out.print("一个");
        }
        System.out.print("的我");
    }
}
