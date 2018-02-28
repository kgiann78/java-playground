package playground;

import java.util.ArrayList;
import java.util.List;

public class ThreadSafeSingleton {

    private String name;


    private ThreadSafeSingleton() {
        this.name = "Hello from class " + this.toString();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static ThreadSafeSingleton getInstance() {
        return InnerClass.instance;
    }

    private final static class InnerClass {
        private static ThreadSafeSingleton instance = new ThreadSafeSingleton();
    }
}

class MainThreadSafeSingleton {
    static List<ThreadSafeSingleton> singletons = new ArrayList<ThreadSafeSingleton>();

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                ThreadSafeSingleton safeSingleton = ThreadSafeSingleton.getInstance();
                System.out.println(safeSingleton.getName());
                MainThreadSafeSingleton.addToList(singletons, safeSingleton);
            }).start();
        }

        System.out.println(singletons.size());
        for (ThreadSafeSingleton singleton : singletons) {
            System.out.println("what?");
            System.out.println(singleton.getName());
        }
    }

    public static synchronized void addToList(List<ThreadSafeSingleton> singletons, ThreadSafeSingleton safeSingleton) {
        safeSingleton.setName("Hello from thread " + Thread.currentThread().getName());
        singletons.add(safeSingleton);
        System.out.println(safeSingleton.getName());
    }
}
