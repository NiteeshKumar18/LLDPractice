package DesignPatterns.VisitorDesignPattern.InterfaceElement;

import DesignPatterns.VisitorDesignPattern.InterfaceVisitor.Visitor;

public class DoubleRoom implements Room {
    public int price;


    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
