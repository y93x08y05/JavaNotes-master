package com.jack.algorithm.设计模式.action.Mediator2018;

import java.util.HashMap;
import java.util.Map;

public class ChatImpl implements Chat{
    private Map map = new HashMap<>();
    @Override
    public void send(String personFrom, String personTo, String message) {
        Person personF = (Person)map.get(personFrom);
        Person personT = (Person)map.get(personTo);
        personT.receiveMessage(personF,message);
    }

    @Override
    public void add(Person person) {
        person.setChat(this);
        map.put(person.getName(),person);
    }
}