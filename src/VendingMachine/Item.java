package VendingMachine;

public class Item {

    private final int itemId;
    private final int price;

    private final Drink drink;

    private final String itemName;


    public Item(int itemId, int price, Drink drink, String itemName) {
        this.itemId = itemId;
        this.price = price;
        this.drink = drink;
        this.itemName = itemName;
    }


    public int getItemPrice(){
        return this.price;
    }
}
