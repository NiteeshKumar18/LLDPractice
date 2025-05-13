package Splitwise;

import Splitwise.User.User;

import java.util.HashMap;
import java.util.Map;

public class UserBalanceSheet {

    private int totalAmountPaidByMe;

    private int totalAmountSpent;

    private int totalAmountIOwe;

    private int totalAmountIGet;

    private Map<User, Balance> userBalanceMap = new HashMap<>();


    public void setTotalAmountPaidByMe(int amount) {
        this.totalAmountPaidByMe = amount;
    }

    public int getTotalAmountPaidByMe() {
        return this.totalAmountPaidByMe;
    }

    public void setTotalAmountSpent(int amount) {
        this.totalAmountSpent = amount;
    }

    public int getTotalAmountSpent() {
        return this.totalAmountSpent;
    }

    public void setTotalAmountIOwe(int amount) {
        this.totalAmountIOwe = amount;
    }

    public int getTotalAmountIOwe() {
        return this.totalAmountIOwe;
    }

    public void setTotalAmountIGet(int amount) {
        this.totalAmountIGet = amount;
    }

    public int getTotalAmountIGet() {
        return this.totalAmountIGet;
    }

    public Map<User, Balance> getUserBalanceMap() {
        return this.userBalanceMap;
    }

    public void setUserBalanceMap(Map<User, Balance> userBalanceMapLocal) {
        this.userBalanceMap = userBalanceMapLocal;
    }
}
