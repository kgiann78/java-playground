package playground.designpatterns.singleton;

/*
    Lazy singleton is when we instantiate the object only when needed

    This approach may cause issues with threads trying to instantiate an already instantiated object
    In order to resolve this there are some workarounds that are not so supported anymore.
 */
class LazySingleton {
    private static LazySingleton instance;
    private LazySingleton(){}

    public static LazySingleton getInstance() {
        if (instance == null) instance = new LazySingleton();
        return instance;
    }
}

/*
    One way to make a Singleton thread safe is to call the synchronize keyword.
    The other is called the double check pattern which is as follow.
 */
public class ThreadSafeLazySingleton {
    private static ThreadSafeLazySingleton instance;
    private ThreadSafeLazySingleton() {}

    public static ThreadSafeLazySingleton getInstance() {
        // first check
        if (instance == null) {
            synchronized (ThreadSafeLazySingleton.class) {
                // second check
                if (instance == null) {
                    instance = new ThreadSafeLazySingleton();
                }
            }
        }
        return instance;
    }
}