package com.jack.algorithm.设计模式.action.Interpreter2018;

public class AiInterpreter implements Interpreter{
    @Override
    public void parse(Context context) {
        if (context.getStr().indexOf("爱") != -1) {
            System.out.print("Love");
        }
    }
}