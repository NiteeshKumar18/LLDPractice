package ATM.State;

import ATM.ATM;
import ATM.BankAccount;
import ATM.ATMCard;

public abstract class ATMState {

    public void insertCard(ATMCard card, ATM atm) {
        System.out.println("oops");
    }

    public void AuthenticateCard(ATMCard card, int pin, ATM atm) throws Exception {

    }

    public void selectOption(int val, ATM atm) throws Exception {
    }

    public void cashWithDrawl(int amount,ATM atm, BankAccount bankAccount) throws Exception {
    }

    public void checkBalance(ATMCard card) {
    }

    public void cancelTransaction() {
    }


}
