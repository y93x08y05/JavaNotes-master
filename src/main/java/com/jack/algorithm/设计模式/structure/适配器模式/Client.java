package com.jack.algorithm.设计模式.structure.适配器模式;

/**
 * 适配器模式就是将一个系统的接口转换成另外一个系统的接口
 * 从而使原来不能直接调用的接口变得可以调用
 * 适配器模式主要由源、目的、适配器组成
 * 当系统需要一个外部接口而这个外部接口不符合系统需要时使用适配器模式
 */
public class Client {
    public static void main(String [] args){
        Facade facade = new Facade();
        ListAdapter listAdapter = new ListAdapter(facade.getEmpBy("1"));
        Application.execute(listAdapter);
    }
}