package DesignPatterns.WithBridgePattern;

public class Main {
    public static void main(String[] args) {
        LivingThings livingThings = new LivingThings(new LandBreatheImplementation());
        livingThings.getBreatheProcess().printBreatheProcess();


        /*
        Take away is before if we want new breathe process and rest of the fields are same, still we have to create new class.Now we have moved the breathe process away
         */
    }
}
