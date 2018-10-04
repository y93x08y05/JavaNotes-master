package com.jack.algorithm.设计模式.action.Memento2018;

public class MeetingSummary {
    private String name;
    private String content;
    private String person;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPerson() {
        return person;
    }

    public void setPerson(String person) {
        this.person = person;
    }
    public Memento getMemento() {
        return new Memento(this);
    }

    public void setMemento(Memento memento) {
        this.name = memento.getName();
        this.content = memento.getContent();
        this.person = memento.getPerson();
    }
}