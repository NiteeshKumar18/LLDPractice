package VendingMachine;

public class MoneyState implements State {


    public MoneyState() {
        System.out.println("Currently system is in money state");
    }


    @Override
    public void pressInsertCoinButton(VendingMachine machine) throws Exception {

    }

    @Override
    public void cancelOrder(VendingMachine machine) throws Exception {
        System.out.println("Cancelling the order and returning the money" + machine.getCurrentlyUserEnteredMoney());
        machine.setCurrentlyUserEnteredMoney(0);
        machine.setState(new IdleState(machine));

    }

    @Override
    public void returnChange(VendingMachine machine, int diff) throws Exception {

    }

    @Override
    public void takeMoney(VendingMachine machine, int money) throws Exception {
        machine.setCurrentlyUserEnteredMoney(money);
        machine.setState(new SelectionState());
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
