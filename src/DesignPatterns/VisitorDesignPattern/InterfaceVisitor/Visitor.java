package DesignPatterns.VisitorDesignPattern.InterfaceVisitor;

import DesignPatterns.VisitorDesignPattern.InterfaceElement.DoubleRoom;
import DesignPatterns.VisitorDesignPattern.InterfaceElement.Room;
import DesignPatterns.VisitorDesignPattern.InterfaceElement.SingleRoom;

public interface Visitor {

    void visit(SingleRoom singleRoom);

    void visit(DoubleRoom doubleRoom);
}
