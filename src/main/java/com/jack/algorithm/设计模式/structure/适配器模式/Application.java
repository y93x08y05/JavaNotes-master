package com.jack.algorithm.设计模式.structure.适配器模式;

import java.util.HashMap;

public class Application {
    public static void execute(HashMap map){
        for (int i=0;i<map.size();i++){
            System.out.println(map.get(i + ""));
        }
    }
}