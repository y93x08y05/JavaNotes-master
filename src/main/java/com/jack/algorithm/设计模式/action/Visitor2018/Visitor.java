package com.jack.algorithm.设计模式.action.Visitor2018;

public interface Visitor {
    double visit(Wine wine);
    double visit(Pig pig);
    double visit(Television television);
}