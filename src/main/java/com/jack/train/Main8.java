package com.jack.train;


/**
 * @Author: Jack
 * @Date: 2018/12/11 18:09
 */
public class Main8 {
    public static void main(final String[] args) {
        System.out.println((int) 1.2);
        System.out.println((int) 1.5);
        System.out.println((int) 1.7);
        System.out.println(Math.ceil(1.2));
        System.out.println(Math.ceil(1.5));
        System.out.println(Math.ceil(1.7));
        System.out.println(Math.floor(1.2));
        System.out.println(Math.floor(1.5));
        System.out.println(Math.floor(1.7));
        Integer i01 = 59;
        int i02 = 59;
        Integer i03 = Integer.valueOf(59);
        Integer i04 = new Integer(59);
        Long i05 = 59L;
        long i06 = 59;
        Long i07 = Long.valueOf(59);
        Long i08 = new Long(59);
        System.out.println(i01 == i02);//false
        System.out.println(i01 == i03);//false
        System.out.println(i01 == i04);//true
        System.out.println(i02 == i03);//false
        System.out.println(i02 == i04);//false
        System.out.println(i03 == i04);//false
        System.out.println(i01.equals(i04));//true
        System.out.println(i01.equals(i03));//true
        System.out.println(i03.equals(i04));//true
    }
}
