package com.jack.algorithm.设计模式.structure.Decorator2018;

/**
 * 给手机通话装饰类增加彩铃功能
 */
public class ColorPhoneDecorator extends PhoneDecorator{
    public ColorPhoneDecorator(Phone phone){
        super(phone);
    }
    @Override
    public void call(String name) {
        System.out.println("播放彩铃");
        super.call(name);
    }
}