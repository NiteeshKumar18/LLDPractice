package VendingMachine;

import java.util.List;

public class ItemShelf {

    private final int shelfCode;

    private boolean isAvailable;

    private int countAvailable;

    private final Item item;

    public ItemShelf(int shelfCode, boolean isAvailableLocal, int countAvailable, Item item) {
        this.shelfCode = shelfCode;
        this.countAvailable = countAvailable;
        this.item = item;
        this.isAvailable = countAvailable > 0;
    }


    public int getShelfCode() {
        return this.shelfCode;
    }


    public void setIsAvailable(boolean bool) {
        this.isAvailable = bool;
    }

    public boolean isAvailable() {
        return this.isAvailable;
    }

    public Item getItem() {
        return this.item;
    }

    public void dispenseOne() {
        --countAvailable;
        this.isAvailable = countAvailable > 0;

    }


}
