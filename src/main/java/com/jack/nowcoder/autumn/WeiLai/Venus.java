package com.jack.nowcoder.autumn.WeiLai;

/**
 * @Author: Jack
 * @Date: 2018/9/11 21:25
 */
public class Venus {
    public static void main(String[] args) {
        int n=13*27%24;
        System.out.println(n);
        String test="a1b2c3";
        String []tokens=test.split("\\d");
        for (String s:tokens)
            System.out.printf(s+" ");
        int []x={1,2,3};
        int []y={4,5,6};
        new Venus().go(x,y);
    }
    void go(int []...z) {
        for (int []a:z)
            System.out.print(a[0]);
    }
}