package ATM;

import ATM.State.IdleState;
import TicTacToe.TicTacToe;

public class ATMRoom {
    public static void main(String[] args) throws Exception {
        BankAccount account = getNewBankACcount();
        ATMCard card = getNewAtmCard(account);
        User user = getNewUser(card, account);
        ATM atm = new ATM();
        atm.SetAtmState(new IdleState(atm));
        atm.getState().insertCard(card, atm);
        atm.getState().AuthenticateCard(card, 1234, atm);
        atm.getState().selectOption(1, atm);
        atm.getState().cashWithDrawl(2000,atm,account);

    }

    public static BankAccount getNewBankACcount() {
        return new BankAccount();
    }

    public static ATMCard getNewAtmCard(BankAccount account) {
        return new ATMCard(1234, 1234, account, "Niteesh", 252);
    }

    public static User getNewUser(ATMCard card, BankAccount account) {
        return new User(4567, card, account);
    }
}
