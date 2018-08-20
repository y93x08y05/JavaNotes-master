package com.jack.designMode.structure.Flyweight2018;

import java.util.ArrayList;
import java.util.List;

public class FlyweightFactory {
    private List list = new ArrayList();
    public Flyweight getFlyweight(String name){
        Flyweight flyweight = null;
        for (int i=0;i<list.size();i++){
            flyweight = (Flyweight) list.get(i);
            if (name.equals(flyweight.getName())){
                System.out.println(name+"被直接获取");
                break;
            } else {
                flyweight = null;
            }
        }
        if (flyweight == null){
            if ("好".equals(name)){
                flyweight = new HaoFlyweight(name);
            } else if ("学".equals(name)){
                flyweight = new XueFlyweight(name);
            } else if ("习".equals(name)){
                flyweight = new XiFlyweight(name);
            } else if ("天".equals(name)){
                flyweight = new TianFlyweight(name);
            } else if ("向".equals(name)){
                flyweight = new XiangFlyweight(name);
            } else if ("上".equals(name)){
                flyweight = new ShangFlyweight(name);
            } else if ("，".equals(name)){
                flyweight = new InterFlyweight(name);
            }
            System.out.println(name+"被创建");
            list.add(flyweight);
        }
        return flyweight;
    }
}