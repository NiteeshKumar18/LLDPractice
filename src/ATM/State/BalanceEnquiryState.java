package ATM.State;

import ATM.ATM;
import ATM.BankAccount;

public class BalanceEnquiryState extends ATMState {

    public BalanceEnquiryState(ATM atm) {
        System.out.println("System is in balance enquiry state");
    }


    public int getMyAccountBalance(BankAccount account){
      return account.getByAccountBalance();
    }
}
