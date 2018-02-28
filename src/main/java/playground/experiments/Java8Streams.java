package playground.experiments;

import java.util.*;
import java.util.stream.Collectors;

public class Java8Streams {

    public static void main(String[] args) {
        List<InnerClass> classes = new ArrayList<>();

        classes.add(new InnerClass(1, "alekos"));
        classes.add(new InnerClass(2, "aleksandros"));
        classes.add(new InnerClass(3, "aleksis"));

        String classesString = "";
        classesString = "";
        System.out.println(classes.stream().map(InnerClass::getName).collect(Collectors.toList()).toString().replaceAll("\\[|\\]", ""));
    }
}

class InnerClass {
    int value;
    String name;

    InnerClass(int value, String name) {
        this.value = value;
        this.name = name;
    }

    public String getName() {
        return name;
    }
}