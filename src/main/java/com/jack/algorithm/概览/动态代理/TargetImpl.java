package com.jack.algorithm.概览.动态代理;

/**
 * Created by jack on 7/24/2018 9:53 PM
 * Enhancer could proxy class and interface but JDK only could proxy interface
 * Enhancer could not interceptor final method and not proxy final class
 * because it achieve dynamics proxy through extends method
 */
public class TargetImpl implements Target{

    @Override
    public int test(int i) {
        return i+1;
    }
}
