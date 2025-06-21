package DesignPatterns.SingletonPattern;

public class DoubleLocking {
    private static volatile LazyInitialization lazyInitialization;

    public LazyInitialization getInstance() {
        if (lazyInitialization == null) {
            synchronized (DoubleLocking.class) {
                if (lazyInitialization == null) {
                    lazyInitialization = new LazyInitialization();
                }
            }
        }
        return lazyInitialization;
    }

    /*
    Take away is here we haad a null check at start only, if its available we are returning, operation is gng to sync mode only if its null
    | Concept           | Purpose                                                |
| ----------------- | ------------------------------------------------------ |
| `volatile`        | Prevents instruction reordering and ensures visibility |
| First null check  | Avoids locking every time (perf)                       |
| Second null check | Ensures only one instance created (safety)             |

     */
}
