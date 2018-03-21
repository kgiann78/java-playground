package playground.designpatterns.decorator;

public class Espresso extends Beverage {
    @Override
    String getDescription() {
        return "Esspresso";
    }

    @Override
    double getCost() {
        return 1.70;
    }
}
