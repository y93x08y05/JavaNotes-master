package com.jack.designMode.action.State2018.example1;

public class CreatingState implements State{
    @Override
    public void handle(Document document) {
        document.setState(new CreatedState());
        System.out.println("公文已创建完成");
    }
}