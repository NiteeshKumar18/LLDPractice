package DesignPatterns.VisitorDesignPattern.InterfaceVisitor;

import DesignPatterns.VisitorDesignPattern.InterfaceElement.DoubleRoom;
import DesignPatterns.VisitorDesignPattern.InterfaceElement.SingleRoom;
import DesignPatterns.VisitorDesignPattern.InterfaceVisitor.Visitor;

public class RoomPricingVisitor implements Visitor {
    @Override
    public void visit(SingleRoom singleRoom) {
        System.out.println("setting price for single room");
        singleRoom.price = 1000;
    }

    @Override
    public void visit(DoubleRoom doubleRoom) {
        System.out.println("setting price for double room");
        doubleRoom.price = 10000;
    }
}
