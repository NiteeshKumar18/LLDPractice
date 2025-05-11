package ATM;

import java.util.concurrent.ThreadLocalRandom;

public class BankAccount {

    private final int accountNo;

    private int bankBalance;

    public BankAccount() {
        this.accountNo = ThreadLocalRandom.current().nextInt(100, 1500);
        this.bankBalance = 5000;
    }

    public void depositMoney(int amount) {
        this.bankBalance = this.bankBalance + amount;
    }

    public void withDrawMoney(int amount) {

        System.out.println("withdrawed money" + amount);
        this.bankBalance = this.bankBalance - amount;
    }

    public int getByAccountBalance(){
        return this.bankBalance;
    }
}
