package playground.designpatterns.prototype;


import org.apache.commons.lang3.SerializationUtils;

import java.io.Serializable;

/*
    By using serialization we can achieve a deep copy of an object
 */
class Foo implements Serializable {
    private int number;
    private String whatever;

    public Foo(int number, String whatever) {
        this.number = number;
        this.whatever = whatever;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getWhatever() {
        return whatever;
    }

    public void setWhatever(String whatever) {
        this.whatever = whatever;
    }

    @Override
    public String toString() {
        return "Foo{" +
                "number=" + number +
                ", whatever='" + whatever + '\'' +
                '}';
    }
}

public class SerializableRoundtrip {
    public static void main(String[] args) {
        Foo foo = new Foo(123, "life");
        Foo foo2 = SerializationUtils.roundtrip(foo);
        foo2.setWhatever("na naaa na na na");
        System.out.println(foo);
        System.out.println(foo2);
    }
}
