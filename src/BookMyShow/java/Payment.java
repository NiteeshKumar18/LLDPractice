package BookMyShow.java;

public class Payment {

    private final String paymentGatewayConfirmationId;
    private final String paymentMethod;

    private final int totalMoneyPaid;

    public Payment(String paymentGatewayConfirmationId, String paymentMethod, int totalMoneyPaid) {
        this.paymentMethod = paymentMethod;
        this.paymentGatewayConfirmationId = paymentGatewayConfirmationId;
        this.totalMoneyPaid = totalMoneyPaid;
    }
}
