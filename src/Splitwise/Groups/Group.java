package Splitwise.Groups;

import Splitwise.Expense.Expense;
import Splitwise.Expense.ExpenseController;
import Splitwise.User.User;

import java.util.ArrayList;
import java.util.List;

public class Group {

    private final String groupId;

    private final String groupName;

    private final String groupDescription;

    private List<Expense> allExpenses;

    private final ExpenseController expenseController;

    private List<User> allUsers;


    public Group(String groupId, String groupName, String groupDescription) {
        this.groupId = groupId;
        this.groupName = groupName;
        this.groupDescription = groupDescription;
        this.allExpenses = new ArrayList<>();
        this.expenseController = new ExpenseController();
    }


    public void addUser(User user) {
        this.allUsers.add(user);
    }

    public void addExpenseToGroup(Expense expense) throws Exception {
        expenseController.addExpense(expense);
        this.allExpenses.add(expense);
    }
}
