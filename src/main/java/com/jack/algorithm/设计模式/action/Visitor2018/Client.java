package com.jack.algorithm.设计模式.action.Visitor2018;

/**
 *  访问者模式表示一个作用于某对象结构中的各元素的操作
 *  它使开发者可以在不改变各元素的类的前提下定义作用于
 *  这些元素的新操作。
 *  使用了访问者模式以后，对于原来的类层次增加新的操作
 *  仅仅需要实现一个具体访问者角色，不必修改整个类层次。
 *  而且每个具体的访问者角色都对应于一个相关操作，
 *  因此，如果一个操作的需求有变，就不用改动整个类层次，
 *  只需要修改一个具体访问者角色即可。
 *  访问者模式不适合具体元素角色经常发生变化的情况
 */

public class Client {
    public static void main(String [] args) {
        Wine wine = new Wine();
        wine.setCount(10);
        wine.setPrice(20f);
        Pig pig = new Pig();
        pig.setCount(10);
        pig.setPrice(15f);
        Television television = new Television();
        television.setCount(1);
        television.setPrice(2000f);
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.add(wine);
        shoppingCart.add(pig);
        shoppingCart.add(television);
        AccountMachine accountMachine = new AccountMachine();
        accountMachine.account(shoppingCart.getList());
        System.out.println("本次购物车内所有物品的总价为：" +
            accountMachine.getAmt());
    }
}