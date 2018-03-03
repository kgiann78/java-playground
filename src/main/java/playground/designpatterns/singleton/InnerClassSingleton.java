package playground.designpatterns.singleton;

/*
    An easy and more clean way to provide a thread safe singleton approach
    is to use an inner class to provide you the instance of the object
 */
public class InnerClassSingleton {
    private InnerClassSingleton() {
        System.out.println("Still lazy instantiation!");
    }

    private static class Impl{
        private static InnerClassSingleton instance = new InnerClassSingleton();
    }

    public static InnerClassSingleton getInstance()  {
        System.out.println("Now calling instance");
        return Impl.instance;
    }

    public static void main(String[] args) {
        InnerClassSingleton singleton = InnerClassSingleton.getInstance();
    }
}
