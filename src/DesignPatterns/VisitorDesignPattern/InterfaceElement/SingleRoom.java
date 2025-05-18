package DesignPatterns.VisitorDesignPattern.InterfaceElement;

import DesignPatterns.VisitorDesignPattern.InterfaceVisitor.Visitor;

public class SingleRoom implements Room {


    public int price;

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
