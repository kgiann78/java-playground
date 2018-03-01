package playground.designpatterns.prototype;

import java.util.Arrays;

class Address {
    int number;
    private String addressName;

    Address(int number, String addressName) {
        this.number = number;
        this.addressName = addressName;
    }

    Address(Address address) {
        this(address.number, address.addressName);
    }

    @Override
    public String toString() {
        return "Address{" +
                "number=" + number +
                ", addressName='" + addressName + '\'' +
                '}';
    }
}

class Employee {
    String[] names;
    Address address;

    Employee(String[] names, Address address) {
        this.names = names;
        this.address = address;
    }

    Employee(Employee john) {
        this(john.names.clone(), new Address(john.address));
    }

    @Override
    public String toString() {
        return "Employee{" +
                "names=" + Arrays.toString(names) +
                ", address=" + address +
                '}';
    }
}

public class CopyConstructors {

    public static void main(String[] args) {
        Employee john = new Employee(new String[]{"john", "atkinson"}, new Address(19, "Leviathan street"));
        Employee cate = new Employee(john);

        cate.names[0] = "cate";
        cate.names[1] = "huchington";
        cate.address.number = 57;

        System.out.println(john);
        System.out.println(cate);
    }
}
