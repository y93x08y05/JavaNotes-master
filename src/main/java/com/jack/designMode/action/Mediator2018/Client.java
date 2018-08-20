package com.jack.designMode.action.Mediator2018;

/**
 * 调停者模式就是用一个中介者对象来封装一系列的对象交互
 * 中介者使各对象不需要显式地相互引用，从而使得耦合松散
 * 而且可以独立地改变他们之间的交互
 * 当一组对象以定义良好但是复杂的方式进行通信，而且这些
 * 对象产生的相互依赖关系结构混乱且难以理解，或一个对象
 * 引用其他许多对象并且直接与这些对象通信，导致难以复用
 * 该对象时，就可以考虑使用调停者模式。
 * 当使用调停者模式时，它将各个通信的对象进行解耦，使得原本分布
 * 于多个对象之间的行为集中在一起，改变这些行为只需要生成的协调
 * 类即可，使得程序更容易李军和维护。
 */
public class Client {
    public static void main(String [] args) {
        Chat chat = new ChatImpl();
        Person a = new PersonA();
        Person b = new PersonB();
        chat.add(a);
        chat.add(b);
        a.sendMessage("A","B","hello");
    }
}