package ATM.State;

import ATM.ATM;

public class SelectionState extends ATMState{

    public SelectionState(ATM atm){
        System.out.println("System is in selection state");
        System.out.println("Displaying options to user");
        for(ATMOptions options : ATMOptions.values()){
            System.out.println(options);
        }
    }


    public void cancelTransaction(ATM atm){
        atm.SetAtmState(new IdleState(atm));
        System.out.println("System is going back to idle state");
    }


    public void selectOption(int option,ATM atm) throws Exception{
        if(option == 1){
            atm.SetAtmState(new CashWithDrawlState(atm));
        }else if(option ==2){
            atm.SetAtmState(new BalanceEnquiryState(atm));
        }else {
            throw new Exception("Invalid entry");
        }
    }
}
