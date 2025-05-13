package Splitwise.Expense;


import Splitwise.User.User;

public class Splits {

    private final int amount;

    private final User user;


    public Splits(int amount, User user) {
        this.amount = amount;
        this.user = user;
    }

    public int getAmount() {
        return this.amount;
    }

    public User getUser() {
        return this.user;
    }

}
