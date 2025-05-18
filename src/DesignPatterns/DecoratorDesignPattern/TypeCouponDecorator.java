package DesignPatterns.DecoratorDesignPattern;

import java.util.List;

public class TypeCouponDecorator extends CouponDecorator {


    private String type;

    private List<String> eligibleTypes = List.of("FURNITURE", "ELECTRONIC");

    public TypeCouponDecorator(AbstractProductClass productClass, int percentage, String type) {
        super(productClass, percentage);
        this.type = type;

    }

    @Override
    public int getPrice() {
        int price = this.productClass.getPrice();
        if (eligibleTypes.contains(type)) {
            return price - (price * this.discountPercentage) / 100;
        }
        return price;
    }
}
