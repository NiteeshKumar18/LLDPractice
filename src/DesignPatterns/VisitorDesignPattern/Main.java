package DesignPatterns.VisitorDesignPattern;

import DesignPatterns.VisitorDesignPattern.InterfaceElement.DoubleRoom;
import DesignPatterns.VisitorDesignPattern.InterfaceElement.SingleRoom;
import DesignPatterns.VisitorDesignPattern.InterfaceVisitor.HouseKeepingVisitor;
import DesignPatterns.VisitorDesignPattern.InterfaceVisitor.RoomPricingVisitor;

public class Main {
    public static void main(String[] args) {
        SingleRoom singleRoom = new SingleRoom();
        DoubleRoom doubleRoom = new DoubleRoom();
        RoomPricingVisitor pricingVisitor = new RoomPricingVisitor();
        HouseKeepingVisitor houseKeepingVisitor = new HouseKeepingVisitor();
        singleRoom.accept(pricingVisitor);
        singleRoom.accept(houseKeepingVisitor);
        doubleRoom.accept(pricingVisitor);
        doubleRoom.accept(houseKeepingVisitor);
    }
}
