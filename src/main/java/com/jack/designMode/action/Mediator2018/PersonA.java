package com.jack.designMode.action.Mediator2018;

public class PersonA extends Person{
    private String name;

    @Override
    public String getName() {
        return "A";
    }

    @Override
    public void receiveMessage(Person personFrom, String message) {
        System.out.println(personFrom.getName() + "向" + getName() +
                "发送来的消息，消息的内容是：" + message
        );
    }
}