package ATM.State;

import ATM.ATM;
import ATM.ATMCard;

public class AUthenticationState extends ATMState {

    public AUthenticationState(ATM atm){
      System.out.println("ATm is currently in auth state");
    }

    @Override
    public void AuthenticateCard(ATMCard card, int pin,ATM atm) throws Exception{
      if(card.isCorrectPinEntered(pin)){
          System.out.println("Correct pin entered, proceeding to select option state");
          atm.SetAtmState(new SelectionState(atm));
      }
    }
}
