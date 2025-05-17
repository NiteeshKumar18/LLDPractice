package DesignPatterns.SingletonPattern;

public class EagerInitialization {
    private static EagerInitialization eagerInitialization = new EagerInitialization();

    private EagerInitialization(){

    }

    public static EagerInitialization egtInstance(){
        return eagerInitialization;
    }
}
