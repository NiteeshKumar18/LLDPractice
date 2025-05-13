package Splitwise.Expense;

public enum SplitType {

    EQUAL(1), UN_EQUAL(2), PERCENTAGES(3);


    private int value;

    SplitType(int valueLocal) {
        this.value = valueLocal;
    }
}
