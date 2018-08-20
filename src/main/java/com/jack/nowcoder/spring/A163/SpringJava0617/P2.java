package com.jack.nowcoder.spring.A163.SpringJava0617;

/**
 * null相当于什么都没有，没有主体也就没办法执行任何方法
 */
public class P2 {
    public static void main(String[] args) {
        String str=null;
        str.concat("abc");
        str.concat("123");
        System.out.println(str);
    }
}