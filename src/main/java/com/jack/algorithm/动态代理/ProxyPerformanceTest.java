package com.jack.algorithm.动态代理;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Author: Jack
 * @Date: 2018/10/3 21:25
 */
public class ProxyPerformanceTest {
    public static void main(String[] args) {
        Target nativeTest=new TargetImpl();
        Target dynamicProxy=DynamicProxyTest.newProxyInstance(nativeTest);
        Target cglibProxy=CglibProxyTest.newProxyInstance(TargetImpl.class);

        int preRunCount=10000;
        runWithoutMonitor(nativeTest,preRunCount);
        runWithoutMonitor(cglibProxy,preRunCount);
        runWithoutMonitor(dynamicProxy,preRunCount);

        Map<String,Target> tests=new LinkedHashMap<>();
        tests.put("Native    ",nativeTest);
        tests.put("Dynamic ",dynamicProxy);
        tests.put("Cglib     ",cglibProxy);
        int repeatCount=3;
        int runCount=1000000;
        runTest(repeatCount,runCount,tests);
        runCount=50000000;
        runTest(repeatCount,runCount,tests);
    }
    private static void runTest(int repeatCount, int runCount, Map<String,Target> tests) {
        System.out.println(String.format("\n===== run test : [repeatCount=%s] [runCount=%s] [java.version=%s]=====",
                repeatCount,runCount,System.getProperty("java.version")));
        for (int i=0;i<repeatCount;i++) {
            System.out.println(String.format("\n------test : [%s] ------",(i+1)));
            for (String key:tests.keySet()) {
                runWithMonitor(tests.get(key),runCount,key);
            }
        }
    }
    private static void runWithoutMonitor(Target target,int runCount) {
        for (int i=0;i<runCount;i++) {
            target.test(i);
        }
    }
    private static void runWithMonitor(Target target,int runCount,String tag) {
        long start=System.currentTimeMillis();
        for (int i=0;i<runCount;i++) {
            target.test(i);
        }
        long end=System.currentTimeMillis();
        System.out.println("["+tag+"] Total Time:"+(end-start)+"ms");
    }
}