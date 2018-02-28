package playground.java8;

import java.util.Date;
import java.util.Optional;
import java.util.Random;

public class WorkingWithOptionals {
    static class Foo {
        String name;

        public Foo(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Foo{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }

    public Optional<Foo> createFoo() {

        Random random = new Random(new Date().getTime());
        int rand = random.nextInt();
        Foo foo = (rand % 2 == 0) ? new Foo("foo") : null;

        return Optional.of(foo);

    }


    public static void main(String[] args) {
        WorkingWithOptionals workingWithOptionals = new WorkingWithOptionals();

        for (int i = 0; i < 100; i++) {
            Foo foo = workingWithOptionals.createFoo().orElse(new WorkingWithOptionals.Foo("bar"));
            System.out.println(foo);
        }
    }


}
