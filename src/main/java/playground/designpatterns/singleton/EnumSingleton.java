package playground.designpatterns.singleton;

/*
    Enums by default are singleton but there are some issues with that:
    1. they cannot be inherited
    2. serialization is not good with enum objects as singleton objects
 */
public enum EnumSingleton {
    INSTANCE;

    int value;

    // by default the enum constructor is private, so there is no need to add the private keyword
    EnumSingleton() {
        value = 42;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}

class Demo {
    public static void main(String[] args) {
        System.out.println(EnumSingleton.INSTANCE.getValue());
    }
}