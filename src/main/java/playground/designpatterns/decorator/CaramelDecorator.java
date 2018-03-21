package playground.designpatterns.decorator;

public class CaramelDecorator extends AddOnDecorator {
    public CaramelDecorator(Beverage beverage) {
        super(beverage);
    }

    @Override
    String getDescription() {
        return super.getDescription() + " caramel";
    }

    @Override
    double getCost() {
        return super.getCost() + 0.7;
    }
}
