package ATM.State;

import ATM.ATM;
import ATM.BankAccount;
import ATM.WithDrawlProcessor.java.CashWithDrawProcessor;
import ATM.WithDrawlProcessor.java.FiveHundredProcessor;
import ATM.WithDrawlProcessor.java.OneHundredProcessor;
import ATM.WithDrawlProcessor.java.TwoThousandProcessor;

public class CashWithDrawlState extends ATMState {

    public CashWithDrawlState(ATM atm) {
        System.out.println("System is in withdrawl state");
    }


    public void cashWithDrawl(int amount, ATM atm, BankAccount bankAccount) throws Exception {
        if (bankAccount.getByAccountBalance() < amount) {
            System.out.println("Insufficient balance");
            throw new Exception("Insufficient balance");
        } else if (amount > 5000) {
            System.out.println("Insufficient funds in atm");
            throw new Exception("Insufficient fund in atm");
        } else {
            CashWithDrawProcessor processor = new TwoThousandProcessor(new FiveHundredProcessor(new OneHundredProcessor(null)));
            processor.processMoney(atm, amount);
            bankAccount.withDrawMoney(amount);
        }
    }

    public void cancelTransaction(ATM atm) {
        atm.SetAtmState(new IdleState(atm));

    }
}
