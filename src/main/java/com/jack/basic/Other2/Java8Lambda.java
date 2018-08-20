package com.jack.basic.Other2;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * Created by zhangta on 1/24/2018.
 * Java8四大函数接口：Supplier；Consumer；Function；Predicate
 * 函数接口对匿名内部类的优化
 * 类型限制接口；数量限制接口；Operator接口
 * Java中lambda表达式非完全闭包，对值封闭却不对变量封闭
 * 局部变量在lambda表达式中使用需为final或隐式final
 * 局部变量保存在栈上，其变量仅仅限于其所在线程
 * 静态变量与实例变量保存在静态区和堆中，两块区域线程共享
 */
public class Java8Lambda {
    public  static  final int addOne(int a ){
        return  a+1;
    }
    public  static  int oper(int a , Function<Integer,Integer> action){
        return action.apply(a);
    }
    public  static  void main(String [] args){
        int x = 1;
        int y = oper(x,Java8Lambda :: addOne);
        System.out.println(x+y);

        Consumer<String> printString = s -> System.out.println(s);
        printString.accept("hello world");

        Supplier<String> getInstance = () ->"hello world!";
        System.out.println(getInstance.get());

        Predicate<Integer> printOdd = integer -> integer % 2 == 1;
        System.out.println(printOdd.test(5));
    }
}
