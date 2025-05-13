package Splitwise.Expense.Split;

import Splitwise.Expense.Splits;

import java.util.List;

public interface Split {
    boolean validate(List<Splits> splits) throws Exception;
}
