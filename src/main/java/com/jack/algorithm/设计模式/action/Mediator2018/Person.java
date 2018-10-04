package com.jack.algorithm.设计模式.action.Mediator2018;

public abstract class Person {
    private Chat chat;

    public void sendMessage(String personFrom,String personTo,String message) {
        chat.send(personFrom,personTo,message);
    }
    public abstract void receiveMessage(Person personFrom,String message);

    public abstract String getName();

    public Chat getChat() {
        return chat;
    }

    public void setChat(Chat chat) {
        this.chat = chat;
    }
}