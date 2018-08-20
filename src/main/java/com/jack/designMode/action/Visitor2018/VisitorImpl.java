package com.jack.designMode.action.Visitor2018;

public class VisitorImpl implements Visitor{
    @Override
    public double visit(Wine wine) {
        return wine.acceptByBottle();
    }

    @Override
    public double visit(Pig pig) {
        return pig.accountByUnit();
    }

    @Override
    public double visit(Television television) {
        return television.acceptByPiece();
    }
}