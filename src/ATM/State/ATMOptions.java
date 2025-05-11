package ATM.State;

public enum ATMOptions {

    WITHDRAW(1), DEPOSIT(2), BANK_BALANCE(3), CHANGE_PIN(4);

    private int value;

    ATMOptions(int val) {
        this.value = val;
    }

    public ATMOptions getOperationFromValue(int val) throws Exception{
        for(ATMOptions option : ATMOptions.values()){
            if(option.value == val){
                return option;
            }
        }

        System.out.println("Invalid input to select option");
        throw new Exception("Invalid input");
    }
}
