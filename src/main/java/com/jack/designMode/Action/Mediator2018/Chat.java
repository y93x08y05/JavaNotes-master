package com.jack.designMode.action.Mediator2018;

public interface Chat {
    void send(String personFrom, String personTo, String message);
    void add(Person person);
}