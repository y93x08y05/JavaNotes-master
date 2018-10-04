package com.jack.algorithm.设计模式.action.Memento2018;

public class Memento {
    private String name;
    private String content;
    private String person;
    public Memento (MeetingSummary meetingSummary) {
        this.name = meetingSummary.getName();
        this.content = meetingSummary.getContent();
        this.person = meetingSummary.getPerson();
    }
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
}