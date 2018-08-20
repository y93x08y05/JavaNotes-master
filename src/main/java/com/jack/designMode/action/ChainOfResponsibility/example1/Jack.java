package com.jack.designMode.action.ChainOfResponsibility.example1;

public class Jack {
    private Boolean sleep;
    private Boolean head;
    private Boolean stomach;

    public Boolean getStomach() {
        return stomach;
    }

    public void setStomach(Boolean stomach) {
        this.stomach = stomach;
    }

    public Boolean getHead() {
        return head;
    }

    public void setHead(Boolean head) {
        this.head = head;
    }

    public Boolean getSleep() {
        return sleep;
    }

    public void setSleep(Boolean sleep) {
        this.sleep = sleep;
    }
}