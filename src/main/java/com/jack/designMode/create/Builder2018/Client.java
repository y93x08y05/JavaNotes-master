package com.jack.designMode.create.Builder2018;

public class Client {
    public static void main(String [] args){
        Director director = new Director(new MotorcycleBuilder());
        director.assembleMotorcycle();
    }
}