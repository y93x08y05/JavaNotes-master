package com.jack.train;

/**
 * @Author: Jack
 * @Date: 2018/9/24 15:34
 */
public class Main3 {
    public static void main(String[] args) {
         int a=2,b=0;
        System.out.println(find(a, b));
    }
    private static int find(int a,int b) {
        try {
            int c=a/b;
            System.out.println(110);
            return c;
        }catch (Exception e) {
            System.out.println(120);
            return 11;
        } finally {
            System.out.println(130);
            return 12;
        }
    }
}