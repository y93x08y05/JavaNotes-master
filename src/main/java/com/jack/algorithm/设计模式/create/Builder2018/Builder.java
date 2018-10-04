package com.jack.algorithm.设计模式.create.Builder2018;
/**
 * 创建者模式将复杂对象的创建与其表示相分离，
 * 使得同样的构建过程可以创建不同的表示，而不用知道对象的构建细节
 */
public interface Builder {
    Carcase createCarcase();
    Wheel createWheel();
    Tyre createTyre();
    Engine createEngine();
}