package com.jack.nowcoder.autumn.WeiLai;

/**
 * @Author: Jack
 * @Date: 2018/9/11 21:12
 */
abstract class Vehicle {
    public int speed(){
        return 0;
    }
    static class Car extends Vehicle {
        @Override
        public int speed() {
            return 60;
        }
    }
    static class RaceCar extends Car {
        @Override
        public int speed() {
            return 150;
        }
    }

    public static void main(String[] args) {
        RaceCar raceCar=new RaceCar();
        Car car=new RaceCar();
        Vehicle vehicle=new RaceCar();
        System.out.println(raceCar.speed()+" "+car.speed()+" "+vehicle.speed());
    }
}