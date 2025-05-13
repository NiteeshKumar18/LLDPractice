package Splitwise.Expense.Split;

import Splitwise.Expense.Splits;

import java.util.List;

public class EqualSplit implements Split {
    @Override
    public boolean validate(List<Splits> splits) throws Exception {
        if (splits.isEmpty()) {
            return false;
        }
        int splitAmount = splits.get(0).getAmount();
        var badSplits = splits.stream().filter(split -> split.getAmount() != splitAmount).toList();
        return badSplits.isEmpty();

    }
}
