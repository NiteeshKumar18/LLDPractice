package ATM;

public class ATMCard {

    private final int atmCardNo;
    private int PIN;

    private final BankAccount account;

    private final String name;

    private final int CVV;

    public ATMCard(int atmCardNo, int pin, BankAccount account, String name, int cvv) {
        this.atmCardNo = atmCardNo;
        this.PIN = pin;
        this.account = account;
        this.name = name;
        this.CVV = cvv;
    }

    public BankAccount getBankAccount() {
        return this.account;
    }

    public int getPIN() {
        return this.PIN;
    }

    public int getCVV() {
        return this.CVV;
    }

    public int getAtmCardNo() {
        return this.atmCardNo;
    }

    public boolean isCorrectPinEntered(int pin) {
       return this.PIN == pin;
    }


}
