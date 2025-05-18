package DesignPatterns.VisitorDesignPattern.InterfaceVisitor;

import DesignPatterns.VisitorDesignPattern.InterfaceElement.DoubleRoom;
import DesignPatterns.VisitorDesignPattern.InterfaceElement.SingleRoom;

public class HouseKeepingVisitor implements Visitor {
    @Override
    public void visit(SingleRoom singleRoom) {
        System.out.println("Finished house keeping for single room");
    }

    @Override
    public void visit(DoubleRoom doubleRoom) {
        System.out.println("Finished house keeping for double room");
    }
}
