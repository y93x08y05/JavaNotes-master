package com.jack.algorithm.设计模式.action.Interpreter2018;

/**
 * 解释器模式提供一个简单的方式来执行语法，而且容易修改或者扩展
 * 但解释器模式比较使用于文法简单并且对处理的效率要求低情况。
 *  解释器模式给定一个语言，定义它的文法的一种表示，并定义一个解释器
 *  使用该表示来解释语言中的句子
 */

import java.util.ArrayList;
import java.util.List;

public class Client {
    public static void main(String [] args) {
        Context context = new Context("我爱你");
        List list = new ArrayList();
        list.add(new WoInterpreter());
        list.add(new FuHaoInterpreter());
        list.add(new AiInterpreter());
        list.add(new FuHaoInterpreter());
        list.add(new NiInterpreter());
        for (int i=0;i<list.size();i++) {
            Interpreter interpreter = (Interpreter)list.get(i);
            interpreter.parse(context);
        }

    }
}