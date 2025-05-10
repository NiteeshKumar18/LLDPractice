package VendingMachine;

public class DispenseState implements State {


    public DispenseState(VendingMachine machine, int codeNumber) throws Exception {
        System.out.println("System is in dispense state");
        dispenseProduct(machine,codeNumber);
    }

    @Override
    public void pressInsertCoinButton(VendingMachine machine) throws Exception {

    }

    @Override
    public void returnFullMoney(VendingMachine machine) throws Exception {

    }

    @Override
    public void takeMoney(VendingMachine machine, int money) throws Exception {

    }

    @Override
    public void returnChange(VendingMachine machine, int diff) throws Exception {

    }

    @Override
    public void dispenseProduct(VendingMachine machine, int codeNo) throws Exception {
        Inventory inventory = machine.getInventory();
        inventory.dispenseProduct(codeNo);
        machine.setState(new IdleState(machine));
    }

    @Override
    public void selectProduct(VendingMachine machine, int code) throws Exception {

    }

    @Override
    public void pressChooseProductButton(VendingMachine machine) throws Exception {

    }

    @Override
    public void cancelOrder(VendingMachine machine) throws Exception {

    }
}
