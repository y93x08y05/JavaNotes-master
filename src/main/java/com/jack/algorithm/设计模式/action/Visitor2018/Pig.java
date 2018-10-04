package com.jack.algorithm.设计模式.action.Visitor2018;

public class Pig implements Goods{
    private int count;
    private float  price;
    public double accountByUnit(){
        System.out.println("猪肉按斤计价购买的数量为：" +
                getCount() + "斤，购买的单价为：" +
                getPrice() + "，总价为：" +
                getCount() * getPrice()
        );
        return getCount() * getPrice();
    }
    @Override
    public double accept(Visitor visitor) {
        return visitor.visit(this);
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}