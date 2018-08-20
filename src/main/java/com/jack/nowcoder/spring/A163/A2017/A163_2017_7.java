package com.jack.nowcoder.spring.A163.A2017;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * 小易最近在数学课上学习到了集合的概念,集合有三个特征：1.确定性 2.互异性 3.无序性.
 * 小易的老师给了小易这样一个集合：S = { p/q | w ≤ p ≤ x, y ≤ q ≤ z }
 * 需要根据给定的w，x，y，z,求出集合中一共有多少个元素。
 * 输入描述
 * 输入包括一行： 一共4个整数分别是
 * w(1 ≤ w ≤ x)，x(1 ≤ x ≤ 100)，y(1 ≤ y ≤ z)，z(1 ≤ z ≤ 100).以空格分隔
 * 输出描述
 * 输出集合中元素的个数
 * 输入例子
 * 1 10 1 1
 * 输出例子
 * 10
 */
public class A163_2017_7 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        double w=sc.nextInt(),x=sc.nextInt(),y=sc.nextInt(),z=sc.nextInt();
        Set<Double> set=new HashSet<Double>();
        for(double i=w;i<=x;i++){
            for(double j=y;j<=z;j++){
                if(!set.contains(i/j))
                    set.add(i/j);
            }
        }
        System.out.println(set.size());
        sc.close();
    }
}