package ATM.State;

import ATM.ATM;
import ATM.ATMCard;

public class IdleState extends ATMState {
    public IdleState(ATM atm){
        System.out.println("ATM is in Idle state");
    }

    @Override
    public void insertCard(ATMCard card,  ATM atm){
        System.out.println("Got the card, moving the system to Authentication state");
        atm.SetAtmState(new AUthenticationState(atm));
    }
}
