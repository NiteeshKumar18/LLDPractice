package Splitwise.Expense;

import Splitwise.Expense.Split.Split;
import Splitwise.Expense.Split.SplitFactoryClass;

import java.util.ArrayList;
import java.util.List;

public class ExpenseController {

    private List<Expense> allExpenses = new ArrayList<>();


    public List<Expense> getAllExpenses() {
        return this.allExpenses;
    }

    public void addExpense(Expense expense) throws Exception {
        SplitFactoryClass splitFactoryClass = new SplitFactoryClass();
        Split split = splitFactoryClass.createSplitObject(expense.getSPlitType());
        allExpenses.add(expense);
    }
}
