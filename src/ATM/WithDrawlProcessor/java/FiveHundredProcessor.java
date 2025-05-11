package ATM.WithDrawlProcessor.java;

import ATM.ATM;

public class FiveHundredProcessor extends CashWithDrawProcessor {
    public FiveHundredProcessor(CashWithDrawProcessor nextProcessorLocal) {
        super(nextProcessorLocal);
    }

    @Override
    public void processMoney(ATM atm, int amount) {
        int required = amount / 500;
        int remainingBalance = amount % 500;

        if (atm.getNoOf5KNotes() >= required) {
            System.out.println("5k processor released " + required + " 5k notes");
            atm.setNoOf5KNotes(atm.getNoOf5KNotes() - required);
        } else {
            System.out.println("5k processor released" + atm.getNoOf5KNotes() + " 5k notes");
            remainingBalance = remainingBalance + ((required - atm.getNoOf5KNotes()) * 500);
            atm.setNoOf5KNotes(0);
        }
        if (remainingBalance > 0) {
            super.processMoney(atm, remainingBalance);
        }
    }
}
