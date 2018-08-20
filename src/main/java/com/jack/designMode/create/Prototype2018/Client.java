package com.jack.designMode.create.Prototype2018;

public class Client {
    public static void main(String [] args){
        KeyPrototype copperKey = new CopperKey();
        copperKey.setLength(3.1f);
        copperKey.setThick(0.5f);
        KeyPrototype aluminiumKey = (KeyPrototype) copperKey.clone();
        aluminiumKey.setColor("银色");
        System.out.println("铜钥匙的颜色: " + copperKey.getColor());
        System.out.println("铝钥匙的颜色: " + aluminiumKey.getColor());
        KeyPrototype aluminiumKey1 = new AluminiumKey();
        aluminiumKey1.setLength(3.1f);
        aluminiumKey1.setThick(0.5f);
        KeyPrototype copperKey1 = (KeyPrototype)aluminiumKey1.clone();
        copperKey1.setColor("黄色");
        System.out.println("铜钥匙的颜色: " + copperKey1.getColor());
        System.out.println("铝钥匙的颜色: " + aluminiumKey1.getColor());
    }
}