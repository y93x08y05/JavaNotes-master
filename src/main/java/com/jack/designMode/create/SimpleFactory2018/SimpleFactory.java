package com.jack.designMode.create.SimpleFactory2018;

/**
 * 简单工厂模式又叫工厂方法模式
 * 将创建对象与对象的使用分离，在具体的工厂类中创建对象
 * 使用静态方法创建对象，导致静态方法无法继承
 * 工厂类负责所有对象的创建，有可能导致随着具体逻辑
 * 增多，需要多次修改工厂类，增加相应的判断逻辑，
 * 不利于后期的维护
 * 简单工厂模式只适用于创建的对象比较少或者简单等情况
 */
public class SimpleFactory {
    public static Salary createSalary(String name){
        if ("HeBei".equals(name)){
            return new Salary_HeBei();
        } else if ("JiLin".equals(name)){
            return new SalaryJiLin();
        }
        return null;
    }
}