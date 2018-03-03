package playground.designpatterns.singleton;

import java.io.*;

/*
 The Singleton design pattern let us instantiate an object but it avoids creating other instances of that object
 This is useful i.e. when creating a connection to a database where we need to call multiple queries and
 we don't want to instantiate the Connection object multiple times
 */
public class SingletonDemo {



    public static void main(String[] args) throws Exception {
        SimpleSingleton singleton = SimpleSingleton.getInstance();
        String filename = "singleton.bin";
        saveToFile(singleton, filename);
        singleton.setValue(123);
        SimpleSingleton singleton2 = (SimpleSingleton)readFromFile(filename);

        System.out.println(singleton == singleton2);
        System.out.println(singleton);
        System.out.println(singleton2);
    }

    private static void saveToFile(SimpleSingleton singleton, String filename) throws Exception {
        try (FileOutputStream outputStream = new FileOutputStream(filename);
             ObjectOutputStream out = new ObjectOutputStream(outputStream)) {
            out.writeObject(singleton);
        }
    }

    private static Object readFromFile(String filename) throws Exception {
        try (FileInputStream inputStream = new FileInputStream(filename);
             ObjectInputStream in = new ObjectInputStream(inputStream)) {
            return in.readObject();
        }
    }
}

/*
    Problems that occur from the simple approach:
    1. Reflection - through reflection one can implement multiple instances of the same object
    2. Serialization - when not implemented properly, serialization may create multiple instances of the same object.
        Though this can be easily solved (method readResolve).

 */
class SimpleSingleton implements Serializable {

    private int value;
    private static final SimpleSingleton INSTANCE = new SimpleSingleton();

    private SimpleSingleton() {}

    public static SimpleSingleton getInstance() {
        return INSTANCE;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    // The following method resolves the serialization problem
    protected Object readResolve() {
        return INSTANCE;
    }

    @Override
    public String toString() {
        return "SimpleSingleton{" +
                "value=" + value +
                '}';
    }
}
