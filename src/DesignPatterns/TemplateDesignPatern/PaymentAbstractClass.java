package DesignPatterns.TemplateDesignPatern;

public abstract class PaymentAbstractClass {

    public abstract void validate();

    public abstract void debit();

    public abstract void chargeFee();

    public abstract void pay();


    public final void startPaymentFlow() {
        validate();
        debit();
        chargeFee();
        pay();
    }

    /*
    Here all the child has to implement the above 4 methods and startPaymentFlow is final method, so child cant override.
    hence 2 points have been achieved.
    1.Process each task in same flow, but child class can have their own logic in each sub function
     */
}
