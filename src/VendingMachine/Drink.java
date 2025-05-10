package VendingMachine;

public enum Drink {

    COKE(1), SPRITE(2), MIRANDA(3);
    public int value;

    Drink(int value) {
        this.value = value;
    }

    public static Drink getDrinkFromValue(int value) {
        for (Drink d : Drink.values()) {
            if (d.value == value) {
                return d;
            }
        }
        throw new IllegalArgumentException("Unknown drink value: " + value);
    }
}
