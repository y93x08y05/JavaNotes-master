package com.jack.train;

/**
 * @Author: Jack
 * @Date: 2018/9/30 14:04
 */
public class Main6 {
    static {
        System.out.println(1);
    }
    {
        System.out.println(2);
    }
    Main6() {
        System.out.println(3);
    }
    static class Temp extends Main6 {
        static {
            System.out.println(4);
        }
        {
            System.out.println(5);
        }
        Temp() {
            System.out.println(6);
        }
    }

    public static void main(String[] args) {
        new Temp();
    }
}