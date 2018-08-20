package com.jack.designMode.action.Interpreter2018;

public class AiInterpreter implements Interpreter{
    @Override
    public void parse(Context context) {
        if (context.getStr().indexOf("爱") != -1) {
            System.out.print("Love");
        }
    }
}