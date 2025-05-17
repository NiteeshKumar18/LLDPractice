package DesignPatterns.WithBridgePattern;

public class LivingThings {

    private BreatheProcess breatheProcess;


    public BreatheProcess getBreatheProcess() {
        return this.breatheProcess;
    }


    public LivingThings(BreatheProcess breatheProcessLocal) {
        this.breatheProcess = breatheProcessLocal;
    }
}
