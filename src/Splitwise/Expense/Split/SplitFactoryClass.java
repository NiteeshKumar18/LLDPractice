package Splitwise.Expense.Split;

import Splitwise.Expense.SplitType;

public class SplitFactoryClass {

    public Split createSplitObject(SplitType splitType) {
        switch (splitType) {
            case EQUAL -> {
                return new EqualSplit();
            }
            case UN_EQUAL -> {
                return new UnEqualSplit();
            }

            case PERCENTAGES -> {
                return new PercentageSplit();
            }

            default -> {
                return null;
            }
        }
    }
}
