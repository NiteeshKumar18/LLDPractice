package ATM.WithDrawlProcessor.java;

import ATM.ATM;

public class TwoThousandProcessor extends CashWithDrawProcessor {
    public TwoThousandProcessor(CashWithDrawProcessor nextProcessorLocal) {
        super(nextProcessorLocal);
    }

    @Override
    public void processMoney(ATM atm, int amount) {
        int required = amount / 2000;
        int remainingBalance = amount % 2000;

        if (atm.getNoOf2KNotes() >= required) {
            System.out.println("2k processor released " + required + " 2k notes");
            atm.setNoOf2KNotes(atm.getNoOf2KNotes() - required);
        } else {
            System.out.println("2k processor released" + atm.getNoOf2KNotes() + " 2k notes");
            remainingBalance = remainingBalance + ((required - atm.getNoOf2KNotes()) * 2000);
            atm.setNoOf2KNotes(0);
        }
        if (remainingBalance > 0) {
            super.processMoney(atm, remainingBalance);
        }
    }

}
