package playground.polymorphism;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Overloading {

    private static Logger logger = Logger.getLogger(Overloading.class.getName());

    void foo() {
        logger.log(Level.INFO, "a plain foo method");
    }

    int foo(int i) {
        logger.log(Level.INFO, "foo method overloading. This supposes to return i=" + i);
        return i;
    }

    int getI(Foo foo) {
        logger.log(Level.INFO, "This is the foo overloading");
        return foo.getI();
    }

    int getI(Bar bar) {
        logger.log(Level.INFO, "This is the bar overloading");
        return bar.getI();
    }

    public static void main(String[] args) {
//        Overloading overloading = new Overloading();
//        overloading.foo();
//        System.out.println(overloading.foo(5));
//
//        // we declare Foo object
//        Foo fooBar = new Bar(5);
//        // Dynamically it will execute the Bar's getI
//        fooBar.getI();
//
//        // statically it is used as Foo as the parameter of overloading's getI
//        // but inside it will execute whatever the dynamic state of the object is.
//        // Only the selection of the getI method is done statically.
//
//        overloading.getI(fooBar);


        Foo foo = new Foo(1);
        Foo barAsFoo = new Bar(2);
        Bar bar = new Bar(3);

        logger.log(Level.INFO, "getting i's");
        foo.getI();
        barAsFoo.getI();
        bar.getI();

        logger.log(Level.INFO, "getting foo's from foo");

        foo.get(foo);
        foo.get(barAsFoo);
        foo.get(bar);

        logger.log(Level.INFO, "getting foo's from barAsFoo");
        barAsFoo.get(foo);
        barAsFoo.get(barAsFoo);
        barAsFoo.get(bar);

        logger.log(Level.INFO, "getting foo's from bar");

        bar.get(foo);
        bar.get((Bar)barAsFoo);
        bar.get(bar);
    }
}

class Foo {
    private static Logger logger = Logger.getLogger(Foo.class.getName());

    protected int i;

    Foo(int i) {
        this.i = i;
    }

    int getI() {
        logger.log(Level.INFO, "This is Foo's i " + i);
        return i;
    }

    int get(Foo foo) {
        return foo.getI();

    }
}

class Bar extends Foo {
    private static Logger logger = Logger.getLogger(Bar.class.getName());

    Bar(int i) {
        super(i);
    }

    @Override
    int getI() {
        logger.log(Level.INFO, "This is Bar's i " + i);
        return i;
    }
}
