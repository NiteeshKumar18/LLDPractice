package DesignPatterns.SingletonPattern;

public class SynchronizedInitialization {
    private static LazyInitialization lazyInitialization;

    synchronized public LazyInitialization getInstance() {
        if (lazyInitialization != null) {
            return lazyInitialization;
        }
        return lazyInitialization = new LazyInitialization();
    }

    /*
    SOlves the thread problem from lazy but very heavy operation if more threads are trying to access
     */
}
