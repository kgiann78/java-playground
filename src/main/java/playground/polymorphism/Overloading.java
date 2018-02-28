package playground.polymorphism;

public class Overloading {

    void foo() {
        System.out.println("a plain foo method");
    }

    int foo(int i) {
        System.out.println("foo method overloading. This supposes to return i=" + i);
        return i;
    }

    int getI(Foo foo) {
        System.out.println("This is the foo overloading");
        return foo.getI();
    }

    int getI(Bar bar) {
        System.out.println("This is the bar overloading");
        return bar.getI();
    }

    public static void main(String[] args) {
        Overloading overloading = new Overloading();

        overloading.foo();
        System.out.println(overloading.foo(5));

        // we declare Foo object
        Foo fooBar = new Bar(5);
        // Dynamically it will execute the Bar's getI
        fooBar.getI();

        // statically it is used as Foo as the parameter of overloading's getI
        // but inside it will execute whatever the dynamic state of the object is.
        // Only the selection of the getI method is done statically.

        overloading.getI(fooBar);
    }
}

class Foo {
    protected int i;

    Foo(int i) {
        this.i = i;
    }

    int getI() {
        System.out.println("This is Foo's i " + i);
        return i;
    }
}

class Bar extends Foo {

    Bar(int i) {
        super(i);
    }

    @Override
    int getI() {
        System.out.println("This is Bar's i " + (i + 1));
        return i + 1;
    }
}
