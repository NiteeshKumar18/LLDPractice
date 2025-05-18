package DesignPatterns.DecoratorDesignPattern;

public class Item2 extends AbstractProductClass {

    private String name;
    private int originalPrice;

    private int discountedPrice;

    public Item2(String name, int price) {
        this.name = name;
        this.originalPrice = price;
        this.discountedPrice = price;

    }

    @Override
    public int getPrice() {
        return this.originalPrice;
    }
}
