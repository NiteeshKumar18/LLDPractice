package DesignPatterns.DecoratorDesignPattern;

public abstract class CouponDecorator extends AbstractProductClass {
   public AbstractProductClass productClass;
   public int discountPercentage;

   public CouponDecorator(AbstractProductClass productClass, int percentage){
       this.discountPercentage = percentage;
       this.productClass = productClass;
   }

}
