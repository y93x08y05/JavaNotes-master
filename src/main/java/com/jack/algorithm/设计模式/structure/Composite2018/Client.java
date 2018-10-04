package com.jack.algorithm.设计模式.structure.Composite2018;

/**
 * 组合模式就是把部分和整体的关系用树形结构来表示，从而使得客户端能够
 * 把一个个部分对象和由它们组合起来的整体对象采用同样的方法 ，替代继承。
 * 组合模式主要由抽象类，叶子类，父类三部分组成。
 */
public class Client {
    public static void main(String [] args){
        CompositeDepartment organ = new CompositeDepartment();
        organ.add(new LeafDepartment1());
        organ.add(new LeafDepartment2());
        System.out.println("该机构人数为："+organ.personCount());
    }
}