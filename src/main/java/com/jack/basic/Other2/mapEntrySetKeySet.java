package com.jack.basic.Other2;

import java.util.*;

/**
 * Created by zhangta on 2/2/2018.
 */
public class mapEntrySetKeySet {
    public static void main(String[] args) {
        Map<Integer,String> map=new HashMap<Integer,String>();
        map.put(20134316, "尚振伟");
        map.put(20134314, "牛建伟");
        map.put(20134313, "刘中林");
        map.put(20134311, "刘长江");
        map.put(20134309, "李新鹏");
        map.put(20134318, "田成琳");
        //先获取map集合的所有键的Set集合,keySet方法
        Set<Integer> keySet=map.keySet();
        //有了Set集合就可以获取迭代器。
        Iterator<Integer> it=keySet.iterator();
        while(it.hasNext()){
            int key=it.next();
            String value=map.get(key);
            System.out.println(key+"---"+value);
        }
        //将Map集合中的映射关系取出，存入到Set集合中。
        Set<Map.Entry<Integer,String>> entrySet=map.entrySet();
        Iterator<Map.Entry<Integer, String>> it1=entrySet.iterator();
        while(it1.hasNext())
        {
            Map.Entry<Integer, String> me=it1.next();
            Integer key=me.getKey();
            String value=me.getValue();
            System.out.println(key+"==="+value);
        }
        List<Map<Integer,String>> list = new ArrayList<Map<Integer,String>>();
        for(int i=0;i<6;i++){
            list.add(map);
        }
        System.out.println(list);
    }
}
