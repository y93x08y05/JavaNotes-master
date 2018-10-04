package com.jack.algorithm.设计模式.structure.Composite2018;

import java.util.ArrayList;
import java.util.List;

public class CompositeDepartment implements Organ{
    private List list =  new ArrayList();
    @Override
    public int personCount() {
        int count = 0;
        for (int i=0;i<list.size();i++){
            Organ organ = (Organ) list.get(i);
            count += organ.personCount();
        }
        return count;
    }
    public void add(Organ organ){
        list.add(organ);
    }
    public void remove(Organ organ){
        list.remove(organ);
    }
    public Organ getChild(int i){
        return (Organ) list.get(i);
    }
}