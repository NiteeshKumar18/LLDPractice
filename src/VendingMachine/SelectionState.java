package VendingMachine;

public class SelectionState implements State {


    public SelectionState() {
        System.out.println("System currently is in selection state");
    }

    @Override
    public void pressInsertCoinButton(VendingMachine machine) throws Exception {

    }

    @Override
    public void returnChange(VendingMachine machine, int diff) throws Exception {
        System.out.println("Returning the balance amount");
        machine.setCurrentlyUserEnteredMoney(machine.getCurrentlyUserEnteredMoney() - diff);
    }

    @Override
    public void takeMoney(VendingMachine vendingMachine, int money) throws Exception {

    }

    @Override
    public void returnFullMoney(VendingMachine machine) throws Exception {
        System.out.println("Returning full money" + machine.getCurrentlyUserEnteredMoney());
        machine.setCurrentlyUserEnteredMoney(0);
    }

    @Override
    public void dispenseProduct(VendingMachine machine, int codeNo) throws Exception {

    }

    @Override
    public void selectProduct(VendingMachine machine, int code) throws Exception {
        Item item = machine.getInventory().getItem(code);
        int itemPrice = item.getItemPrice();
        int amountPaidByUser = machine.getCurrentlyUserEnteredMoney();

        if (itemPrice > amountPaidByUser) {
            System.out.println("Insufficient funds, returning money");
            returnFullMoney(machine);
            machine.setState(new IdleState(machine));
        } else if (amountPaidByUser > itemPrice) {
            System.out.println("returning the balance amount");
            returnChange(machine, amountPaidByUser - itemPrice);
            machine.setState(new DispenseState(machine, code));
        }
    }

    @Override
    public void pressChooseProductButton(VendingMachine vendingMachine) throws Exception {

    }

    @Override
    public void cancelOrder(VendingMachine machine) throws Exception {

    }
}
