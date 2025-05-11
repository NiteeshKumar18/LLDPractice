package ATM;

public class User {

    private final int userId;

    private final ATMCard card;

    private final BankAccount bankAccount;

    public User(int userIdLocal, ATMCard card, BankAccount account){
        this.bankAccount = account;
        this.userId = userIdLocal;
        this.card = card;
    }

    public BankAccount getBankAccount(){
        return this.bankAccount;
    }

    public ATMCard card(){
        return this.card;
    }
}
