package com.jack.demo;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.TreeSet;

/**
 * Created by Jack on 8/8/2018 9:42 AM
 *  LinkedHashSet mergeSort element as insert sequence
 *  TreeSet mergeSort element as upper sequence
 *  HashSet storage element ad hash method, not special sequence
 */
public class SetDemo {
    public static void main(String[] args) {
        HashSet<String> hashSet = new HashSet<>();
        hashSet.add("B");
        hashSet.add("A");
        hashSet.add("D");
        hashSet.add("E");
        hashSet.add("C");
        hashSet.add("F");
        System.out.println("HashSet顺序：" + hashSet);
        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>();
        linkedHashSet.add("B");
        linkedHashSet.add("A");
        linkedHashSet.add("D");
        linkedHashSet.add("E");
        linkedHashSet.add("C");
        linkedHashSet.add("F");
        System.out.println("LinkedHashSet顺序：" + linkedHashSet);
        TreeSet<String> treeSet = new TreeSet<>();
        treeSet.add("B");
        treeSet.add("A");
        treeSet.add("D");
        treeSet.add("E");
        treeSet.add("C");
        treeSet.add("F");
        System.out.println("TreeSet顺序：" + treeSet);
        TreeSet<Integer> integerTreeSet = new TreeSet<>();
        integerTreeSet.add(1);
        integerTreeSet.add(2);
        integerTreeSet.add(1);
        integerTreeSet.add(3);
        for (Integer i : integerTreeSet)
            System.out.print(i + " ");
        HashSet<Integer> integerHashSet = new HashSet<>();
        integerHashSet.add(1);
        integerHashSet.add(2);
        integerHashSet.add(1);
        integerHashSet.add(3);
        System.out.println();
        for (Integer i : integerHashSet)
            System.out.print(i + " ");
        LinkedHashSet<Integer> integerLinkedHashSet = new LinkedHashSet<>();
        integerLinkedHashSet.add(1);
        integerLinkedHashSet.add(3);
        integerLinkedHashSet.add(1);
        integerLinkedHashSet.add(2);
        System.out.println();
        for (Integer i : integerLinkedHashSet)
            System.out.print(i + " ");
    }
}
