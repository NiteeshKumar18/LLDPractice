package ATM.WithDrawlProcessor.java;

import ATM.ATM;

public class OneHundredProcessor extends CashWithDrawProcessor {
    public OneHundredProcessor(CashWithDrawProcessor nextProcessorLocal) {
        super(nextProcessorLocal);
    }

    @Override
    public void processMoney(ATM atm, int amount) {
        int required = amount / 100;
        int remainingBalance = amount %100;

        if (atm.getNoOf1KNotes() >= required) {
            System.out.println("1k processor released " + required + " 1k notes");
            atm.setNoOf1KNotes(atm.getNoOf1KNotes() - required);
        } else {
            System.out.println("1k processor released" + atm.getNoOf1KNotes() + " 1k notes");
            remainingBalance = remainingBalance + ((required - atm.getNoOf1KNotes()) * 100);
            atm.setNoOf1KNotes(0);
        }
        if (remainingBalance > 0) {
            super.processMoney(atm, remainingBalance);
        }
    }
}
