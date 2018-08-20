package com.jack.designMode.structure.Decorator2018;

/**
 * 给手机通话装饰类增加彩铃功能
 */
public class AdPhoneDecorator extends PhoneDecorator{
    public AdPhoneDecorator(Phone phone){
        super(phone);
    }

    @Override
    public void call(String name) {
        super.call(name);
        System.out.println("播放广告");
    }
}