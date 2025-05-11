package ATM;

import ATM.State.ATMState;
import ATM.State.IdleState;

public class ATM {

    private ATMState state;

    private int noOf2KNotes;

    private int noOf5KNotes;

    private int noOf1KNotes;


    public ATM() {
        this.noOf5KNotes = 2;
        this.noOf2KNotes = 1;
        this.noOf1KNotes = 5;
    }

    public ATMState getState() {
        return this.state;
    }

    public void SetAtmState(ATMState state) {
        this.state = state;
    }

    public void bringAtmBackToIdle() {
        this.state = new IdleState(this);
    }

    public int getNoOf2KNotes() {
        return this.noOf2KNotes;
    }

    public void setNoOf2KNotes(int no) {
        this.noOf2KNotes = no;
    }

    public int getNoOf5KNotes() {
        return this.noOf5KNotes;
    }

    public void setNoOf5KNotes(int num) {
        this.noOf5KNotes = num;
    }

    public int getNoOf1KNotes() {
        return this.noOf1KNotes;
    }

    public void setNoOf1KNotes(int num) {
        this.noOf2KNotes = num;
    }

}
