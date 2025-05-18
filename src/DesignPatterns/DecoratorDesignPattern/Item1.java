package DesignPatterns.DecoratorDesignPattern;

import DesignPatterns.DecoratorDesignPattern.AbstractProductClass;

public class Item1 extends AbstractProductClass {
    private String name;
    private int originalPrice;

    private int discountedPrice;

    public Item1(String name, int price) {
        this.name = name;
        this.originalPrice = price;
        this.discountedPrice = price;

    }

    @Override
    public int getPrice() {
        return this.originalPrice;
    }
}
