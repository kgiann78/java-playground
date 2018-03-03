package playground.designpatterns.singleton;

/*
    In case there might be an error in the constructor and we need to handle it,
    we need to initialize the object within a static block instead
 */
public class StaticBlockSingletonDemo {
    private static StaticBlockSingletonDemo instance;

    private StaticBlockSingletonDemo() throws Exception {
        throw new Exception("This is a custom error");
    }

    static {
        try {
            instance = new StaticBlockSingletonDemo();
        } catch (Exception e) {
            System.out.println("Error when instantiating StaticBlockSingletonDemo:\n" + e.getMessage());
        }
    }

    public static StaticBlockSingletonDemo getInstance() {
        return instance;
    }


    public static void main(String[] args) {
        StaticBlockSingletonDemo singleton = StaticBlockSingletonDemo.getInstance();
    }
}
