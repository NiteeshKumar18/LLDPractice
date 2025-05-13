package Splitwise.Expense.Split;

import Splitwise.Expense.Splits;

import java.util.List;

public class PercentageSplit implements Split{
    @Override
    public boolean validate(List<Splits> splits) throws Exception {
        return false;
    }
}
