package com.jack.designMode.action.Memento2018;

/**
 * 备忘录模式就是一个保存另外一个对象内部状态复制的对象
 * 可将对象恢复到原先保存的对象
 */
public class Client {
    public static void main(String [] args) {
        MeetingSummary meetingSummary = new MeetingSummary();
        meetingSummary.setName("公司销售会议");
        meetingSummary.setContent("有关销售价格的会议内容");
        meetingSummary.setPerson("总经理，销售处长");
        System.out.println("原来的内容" + meetingSummary.getName() +
                ":" + meetingSummary.getContent() +
                ":" + meetingSummary.getPerson()
        );
        Memento memento = meetingSummary.getMemento();
        meetingSummary.setName("公司办公会议");
        meetingSummary.setContent("有关员工稳定的会议内容");
        meetingSummary.setPerson("总经理、董事长");
        System.out.println("修改后的内容" + meetingSummary.getName() +
                ":" + meetingSummary.getContent() +
                ":" + meetingSummary.getPerson()
        );
        meetingSummary.setMemento(memento);
        System.out.println("恢复到原来的内容" + meetingSummary.getName() +
                ":" + meetingSummary.getContent() +
                ":" + meetingSummary.getPerson()
        );
    }
}