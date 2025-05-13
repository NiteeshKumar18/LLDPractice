package Splitwise;

import Splitwise.Expense.Expense;
import Splitwise.Expense.Splits;
import Splitwise.User.User;

import java.util.List;

public class BalanceSheetController {

    public void upDateBalanceSheetsForExpense(Expense expense) {
        int amountPaid = expense.getAmount();
        List<Splits> splits = expense.getSplits();
        User paidBy = expense.getPaidBy();
        UserBalanceSheet paidByUserBalanceSheet = paidBy.getUserBalanceSheet();
        paidByUserBalanceSheet.setTotalAmountPaidByMe(paidByUserBalanceSheet.getTotalAmountPaidByMe() + amountPaid);


        for (Splits split : expense.getSplits()) {


            User oweUser = split.getUser();
            UserBalanceSheet oweUserBalanceSheet = oweUser.getUserBalanceSheet();
            int splitAmount = split.getAmount();

            if (paidBy.getUserId() == split.getUser().getUserId()) {
                paidByUserBalanceSheet.setTotalAmountSpent((paidByUserBalanceSheet.getTotalAmountSpent() + split.getAmount()));
            } else {
                UserBalanceSheet splitUserBalanceSheet = split.getUser().getUserBalanceSheet();
                paidByUserBalanceSheet.setTotalAmountIOwe(paidByUserBalanceSheet.getTotalAmountIOwe() + split.getAmount());

                if (paidByUserBalanceSheet.getUserBalanceMap().get(split.getUser()) != null) {
                    Balance splitUserBalance = paidByUserBalanceSheet.getUserBalanceMap().get(split.getUser());
                    splitUserBalance.setAmountGetBack(splitUserBalanceSheet.getTotalAmountIGet() + split.getAmount());
                } else {
                    Balance balance = new Balance(0, split.getAmount());
                    var userToBalanceMapLocal = paidByUserBalanceSheet.getUserBalanceMap();
                    userToBalanceMapLocal.put(split.getUser(), balance);
                }


                oweUserBalanceSheet.setTotalAmountIOwe(oweUserBalanceSheet.getTotalAmountIOwe() + splitAmount);
                oweUserBalanceSheet.setTotalAmountSpent(oweUserBalanceSheet.getTotalAmountSpent() + splitAmount);


                if (oweUserBalanceSheet.getUserBalanceMap().get(paidBy) != null) {
                    Balance balance = oweUserBalanceSheet.getUserBalanceMap().get(paidBy);
                    balance.setAmountOwe(balance.getAmountOwe() + splitAmount);
                } else {
                    Balance balance = new Balance(split.getAmount(), 0);
                    var oweUserBalanceMapLocal = oweUserBalanceSheet.getUserBalanceMap();
                    oweUserBalanceMapLocal.put(paidBy, balance);
                }

            }
        }
    }

    public void printUserBalanceSheet(User user) {
        System.out.println(user.getUserBalanceSheet().getTotalAmountPaidByMe());
        System.out.println(user.getUserBalanceSheet().getTotalAmountSpent());
        System.out.println(user.getUserBalanceSheet().getTotalAmountIGet());
        System.out.println(user.getUserBalanceSheet().getTotalAmountIOwe());

        for (User splitUser : user.getUserBalanceSheet().getUserBalanceMap().keySet()) {
            Balance balance = user.getUserBalanceSheet().getUserBalanceMap().get(user);
            System.out.println("Amount owe" + balance.getAmountOwe());
            System.out.println("Return amount " + balance.getAmountGetBack());
        }

    }
}
