package com.jack.designMode.action.Mediator2018;

public class PersonB extends Person{
    private String name;
    public String getName(){
        return "B";
    }

    @Override
    public void receiveMessage(Person personFrom, String message) {
        System.out.println(personFrom.getName() + "向" +
                getName() + "发送来了消息，消息的内容是：" + message
        );
    }
}