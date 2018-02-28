package playground.underthehood;

import java.util.Dictionary;
import java.util.Enumeration;
import java.util.Hashtable;

public class LocalVariables {
    int alpha;
    int beta;

    public void initializingOrNotALocalVariable() {
        int age = 1;

        System.out.println("The following line will create a compiler error\n" +
                "age = age + 7;\n" +
                "unless 'age' is initialized!");
        age = age + 7;

        System.out.println(age);
    }

    public void assigningValuesToVariables(LocalVariables localVariables) {
        localVariables = new LocalVariables();
        localVariables.alpha = 1;
        localVariables.beta = 2;

        System.out.println("Local localVariables: " + localVariables);
    }

    public void swapFunction(int a, int b) {
        System.out.println("Before swapping(Inside), a = " + a + " b = " + b);

        // Swap n1 with n2
        int c = a;
        a = b;
        b = c;
        System.out.println("After swapping(Inside), a = " + a + " b = " + b);
    }

    @Override
    public String toString() {
        return "LocalVariables{" +
                "alpha=" + alpha +
                ", beta=" + beta +
                '}';
    }

    public static void main(String[] args) {
        LocalVariables localVariables = new LocalVariables();
        localVariables.initializingOrNotALocalVariable();

        localVariables.alpha = 5;
        localVariables.beta = 10;

        localVariables.assigningValuesToVariables(localVariables);
        System.out.println(localVariables);

        int a = 30;
        int b = 45;
        localVariables.swapFunction(a, b);
        System.out.println("After swapping(Outside), a = " + a + " b = " + b);

        localVariables.swapFunction(localVariables.alpha, localVariables.beta);
        System.out.println("After swapping(Outside), a = " + localVariables.alpha + " b = " + localVariables.beta);

        Dictionary<String, String> dictionary = new Hashtable<>();

        dictionary.put("hello", "world");
        dictionary.put("hello2", "world");
        dictionary.put("hello3", "world");
        dictionary.put("hello", "world2");
//        dictionary.put(null, "world2");

        System.out.println(dictionary);



    }
}
