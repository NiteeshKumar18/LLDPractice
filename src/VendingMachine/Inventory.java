package VendingMachine;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Inventory {

    private List<ItemShelf> inventoryList = new ArrayList<>();


    public void initiateInventory() {
        int itemCount = ThreadLocalRandom.current().nextInt(5, 10);
        int startCode = 101;
        for (int i = 0; i <= itemCount; i++) {
            Item item = new Item(ThreadLocalRandom.current().nextInt(), 40, Drink.getDrinkFromValue(ThreadLocalRandom.current().nextInt(1, 4)), "SPRITE");
            ItemShelf itemShelf = new ItemShelf(startCode++, true, 10, item);
            inventoryList.add(itemShelf);
        }
    }


    public Item getItem(int code) throws Exception {
        for (ItemShelf itemShelf : inventoryList) {
            if (itemShelf.getShelfCode() == code) {
                if (itemShelf.isAvailable()) {
                    return itemShelf.getItem();
                } else {
                    throw new Exception("Item sold out");
                }
            }
        }

        throw new Exception("Invalid code");
    }

    public void dispenseProduct(int codeNo) throws Exception {
        ItemShelf shelf = getItemShelf(codeNo);
        shelf.dispenseOne();
        System.out.println("Dispensing one item"+ shelf.getItem());
    }

    public ItemShelf getItemShelf(int codeNo) throws Exception {
        for (ItemShelf itemShelf : inventoryList) {
            if (itemShelf.getShelfCode() == codeNo) {
                return itemShelf;
            }
        }

        throw new Exception("Invalid code");
    }

    public List<ItemShelf> getInventoryList(){
        return this.inventoryList;
    }
}
