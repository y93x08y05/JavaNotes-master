package com.jack.algorithm.设计模式.create.原型模式;

/**
 * 原型模式可以动态的添加产品类，并且对整体结构没有影响
 * 原型模式需要给每个类都准备一个克隆方法，在设计类时需考虑
 * 在已有类基础上添加clone操作比较困难
 * 原型模式在实现深层次的复制时需要编写一定的代码
 */
public abstract class KeyPrototype implements Cloneable{
    private float length;//钥匙长度
    private float thick;//钥匙厚度
    private String color;//钥匙颜色
    public Object clone(){
        Object obj = null;
        try {
            obj = super.clone();
        } catch (CloneNotSupportedException e) {
            System.out.println(e);
        }
        return obj;
    }
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public float getThick() {
        return thick;
    }
    public void setThick(float thick) {
        this.thick = thick;
    }
    public float getLength() {
        return length;
    }
    public void setLength(float length) {
        this.length = length;
    }
}