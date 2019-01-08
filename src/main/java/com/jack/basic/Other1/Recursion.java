package com.jack.basic.Other1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author: Jack
 * @Date: 2019/1/5 10:02
 */
public class Recursion {
    private List<List<String>> lists;
    private int flag1 = 0;
    private int flag2 = 0;
    public static void main(String[] args) {
        String s = "A1|A2+B1|B2";
        Recursion recursion = new Recursion();
        recursion.start(s);
    }
    public void start(String s) {
        String[] str1 = s.split("\\+");
        lists = new ArrayList<>();
        for (String aStr1 : str1) {
            List<String> list = new ArrayList<>();
            String[] tmp = aStr1.split("\\|");
            Collections.addAll(list, tmp);
            lists.add(list);
        }
        begin(lists);
    }
    public void begin(List<List<String>> lists) {
        for (List<String> list : lists) {
            find(list);
        }
    }
    List<String> res = new ArrayList<>();
    public void find(List<String> list) {
        if (flag1 < lists.size()) {
            flag1++;
            find(lists.get(flag1));
            if (flag2 < lists.get(flag1).size()) {
                flag2++;
                List<String> res = new ArrayList<>();
            }
        }
        for (String aList : list) {
            go(aList);
        }
    }
    public void go(String s) {

    }
}