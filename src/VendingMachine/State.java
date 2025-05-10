package VendingMachine;

public interface State {

    public void pressInsertCoinButton(VendingMachine machine) throws Exception;

    public void cancelOrder(VendingMachine machine) throws Exception;

    public void pressChooseProductButton(VendingMachine vendingMachine) throws Exception;

    public void selectProduct(VendingMachine machine, int code) throws Exception;

    public void dispenseProduct(VendingMachine machine, int codeNo) throws Exception;

    public void returnChange(VendingMachine machine, int diff) throws Exception;

    public void takeMoney(VendingMachine vendingMachine, int money) throws Exception;

    public void returnFullMoney(VendingMachine machine) throws Exception;

}
