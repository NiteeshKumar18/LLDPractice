package DesignPatterns.DecoratorDesignPattern;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {

    private List<AbstractProductClass> abstractProductClasses = new ArrayList<>();


    public void addToCart(AbstractProductClass productClass, String type) {
        AbstractProductClass productClassLocal = new TypeCouponDecorator(new PercentageCouponDecorator(productClass, 10), 10, type);
        this.abstractProductClasses.add(productClassLocal);
    }

    public int getCartPrice() {
        int totalAmountToBePaid = 0;

        for (AbstractProductClass productClass : abstractProductClasses) {
            totalAmountToBePaid += productClass.getPrice();
        }
        return totalAmountToBePaid;
    }

}
