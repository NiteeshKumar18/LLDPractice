package VendingMachine;

public class VendingMachine {

    private State state;

    private int totalMoney;

    private Inventory inventory;

    public VendingMachine(){

    }

    private int currentlyUserEnteredMoney;


    public void setState(State state){
        this.state = state;
    }

    public void withDrawMoney(){
        System.out.println("withdrawing the money ");
        this.totalMoney =0;
    }

    public int getCurrentlyUserEnteredMoney(){
       return this.currentlyUserEnteredMoney;
    }

    public void setCurrentlyUserEnteredMoney(int money){
        this.currentlyUserEnteredMoney = money;
    }

    public Inventory getInventory(){
        return this.inventory;
    }


}
