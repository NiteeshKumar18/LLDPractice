package Splitwise;

public class Balance {

    private int amountOwe;

    private int amountGetBack;

    public Balance(int amountOweLocal, int amountGetBackLocal){
        this.amountGetBack = amountGetBackLocal;
        this.amountOwe = amountOweLocal;
    }

    public int getAmountOwe() {
        return amountOwe;
    }

    public void setAmountOwe(int amountOwe) {
        this.amountOwe = amountOwe;
    }

    public int getAmountGetBack() {
        return amountGetBack;
    }

    public void setAmountGetBack(int amountGetBack) {
        this.amountGetBack = amountGetBack;
    }
}
