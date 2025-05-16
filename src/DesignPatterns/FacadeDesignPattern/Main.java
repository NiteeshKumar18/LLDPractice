package DesignPatterns.FacadeDesignPattern;

public class Main {
    public static void main(String[] args) {
        OrderService orderService = new OrderService();
        orderService.processOrder();
    }

}


/*
Take away is we dont have to expose the internal system complexity to client.Like client can call all three services seperately too, but now client will only call one of the facade

we created.This also minimalises risk as any changes on these services client will not get effected


 */
