package DesignPatterns.DecoratorDesignPattern;

public class PercentageCouponDecorator extends CouponDecorator {


    public PercentageCouponDecorator(AbstractProductClass productClass, int percentage) {
        super(productClass, percentage);
    }

    @Override
    public int getPrice() {
        int price = this.productClass.getPrice();
        return price - (price * this.discountPercentage) / 100;
    }
}
