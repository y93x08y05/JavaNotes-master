package com.jack.designMode.action.Iterator2018;

/**
 *  迭代器模式提供一种顺序访问一个聚合对象中各个元素，而不需要
 *  暴露该对象内部表示的方法
 *  迭代器模式分离了集合对象的遍历行为，抽象出一个迭代器类来负责
 *  既可以不暴露集合内部结构，又可让外部代码访问内部集合的数据
 *  迭代器模式只适用于集合容器的访问。
 */

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ClientList {
    public static void main(String [] args) {
        List list = new ArrayList();
        list.add("张三");
        list.add("李四");
        list.add("王五");
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}