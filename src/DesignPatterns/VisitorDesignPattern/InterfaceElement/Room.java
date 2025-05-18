package DesignPatterns.VisitorDesignPattern.InterfaceElement;

import DesignPatterns.VisitorDesignPattern.InterfaceVisitor.Visitor;

public interface Room {

    void accept(Visitor visitor);
}
