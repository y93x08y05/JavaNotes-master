package com.jack.designMode.structure.Decorator2018;

public class PhoneImpl implements Phone{
    @Override
    public void call(String name) {
        System.out.println(name+" 正在通话中");
    }
}