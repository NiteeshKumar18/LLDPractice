package Splitwise.Expense;

import Splitwise.User.User;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Expense {

    private final String expenseId;

    private final int amount;

    private final User paidBy;

    private final String description;

    private final SplitType splitType;

    private List<Splits> splits;


    public Expense(int amount, User paidByLocal, String DescriptionLocal, SplitType typeLocal, List<Splits> splitsLocal) {
        this.amount = amount;
        this.expenseId = String.valueOf(ThreadLocalRandom.current().nextInt(1, 1000));
        this.paidBy = paidByLocal;
        this.description = DescriptionLocal;
        this.splitType = typeLocal;
        this.splits = splitsLocal;
    }


    public SplitType getSPlitType() {
        return this.splitType;
    }


    public String getExpenseId() {
        return expenseId;
    }

    public int getAmount() {
        return amount;
    }

    public User getPaidBy() {
        return paidBy;
    }

    public String getDescription() {
        return description;
    }

    public SplitType getSplitType() {
        return splitType;
    }

    public List<Splits> getSplits() {
        return splits;
    }

    public void setSplits(List<Splits> splits) {
        this.splits = splits;
    }


}
