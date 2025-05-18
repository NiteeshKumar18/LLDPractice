package DesignPatterns.DecoratorDesignPattern;

public class Main {
    public static void main(String[] args) {
        Item1 item1 = new Item1("Chair", 1000);
        Item2 item2 = new Item2("Phone", 25000);

        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.addToCart(item1, "FURNITURE");
        shoppingCart.addToCart(item2, "ELECTRONIC");
        int amount = shoppingCart.getCartPrice();
    }
}
