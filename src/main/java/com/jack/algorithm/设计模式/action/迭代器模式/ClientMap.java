package com.jack.algorithm.设计模式.action.迭代器模式;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class ClientMap {
    public static void main(String [] args) {
        Map map = new HashMap();
        map.put("1","张三");
        map.put("2","李四");
        map.put("3","王五");
        Set set = map.entrySet();
        Iterator iterable = set.iterator();
        while (iterable.hasNext()) {
            Map.Entry m = (Map.Entry)iterable.next();
            String key = (String)m.getKey();
            String value = (String)m.getValue();
            System.out.println("key = " + key + "， value = " + value);
        }

    }
}