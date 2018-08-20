package com.jack.designMode.action.State2018.example1;

public class Document {
    public Document(){
        state = new CreatingState();
    }
    private State state;

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public void handle(){
        state.handle(this);
    }
}