package ATM.WithDrawlProcessor.java;

import ATM.ATM;

public abstract class CashWithDrawProcessor {

    private CashWithDrawProcessor nextProcessor;


    public CashWithDrawProcessor(CashWithDrawProcessor nextProcessorLocal) {
        this.nextProcessor = nextProcessorLocal;
    }

    public void processMoney(ATM atm, int amount) {
        if (nextProcessor != null) {
            nextProcessor.processMoney(atm, amount);
        }
    }

}
