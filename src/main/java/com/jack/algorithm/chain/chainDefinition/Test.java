package com.jack.algorithm.chain.chainDefinition;

public class Test {
    public static void main(String[] args) throws Exception{
        LinkList list = new LinkList();
        for (int i=0;i<10;i++) {
            int temp = i+1;
            list.insert(i,temp);
            System.out.println(temp + " ");
        }
        list.delete(4);
        System.out.println("\n-----删除第五个元素之后------");
        for (int i=0;i<list.size;i++) {
            System.out.println(list.get(i) + " ");
        }
    }
}