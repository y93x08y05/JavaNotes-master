package com.jack.algorithm.设计模式.structure.Decorator2018;

/**
 * 虚拟的手机通话装饰类
 */
public abstract class PhoneDecorator implements Phone{
    private Phone phone;
    public PhoneDecorator(Phone phone){
        this.phone = phone;
    }

    @Override
    public void call(String name) {
        this.phone.call(name);
    }
}