package VendingMachine;

public class IdleState implements State {


    public IdleState(VendingMachine machine){
        System.out.println("Bringing back the machine to Idle state");
        machine.setCurrentlyUserEnteredMoney(0);
    }

    public void CompleteIdleStateIncludingMoney(VendingMachine machine){
      machine.withDrawMoney();
    }



    @Override
    public void pressInsertCoinButton(VendingMachine machine) throws Exception {
      System.out.println("Moving the state from idle to money state");
      machine.setState(new MoneyState());
    }

    @Override
    public void cancelOrder(VendingMachine machine) throws Exception {

    }

    @Override
    public void returnChange(VendingMachine machine, int diff) throws Exception {

    }

    @Override
    public void takeMoney(VendingMachine machine, int money) throws Exception {

    }

    @Override
    public void returnFullMoney(VendingMachine machine) throws Exception {

    }

    @Override
    public void dispenseProduct(VendingMachine machine, int codeNo) throws Exception {

    }

    @Override
    public void selectProduct(VendingMachine machine, int code) throws Exception {

    }

    @Override
    public void pressChooseProductButton(VendingMachine vendingMachine) throws Exception {

    }
}
