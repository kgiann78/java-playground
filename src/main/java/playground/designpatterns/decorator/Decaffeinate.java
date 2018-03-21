package playground.designpatterns.decorator;

public class Decaffeinate extends Beverage {
    @Override
    String getDescription() {
        return "Decaffeine";
    }

    @Override
    double getCost() {
        return 1.70;
    }
}
