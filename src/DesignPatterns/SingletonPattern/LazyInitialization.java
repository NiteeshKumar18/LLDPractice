package DesignPatterns.SingletonPattern;

public class LazyInitialization {

    private static LazyInitialization lazyInitialization;

    public LazyInitialization getInstance() {
        if (lazyInitialization != null) {
            return lazyInitialization;
        }
        return lazyInitialization = new LazyInitialization();
    }

    /*
    @ threads can create new lazy if they try to create same time
     */
}
