package playground.designpatterns.decorator;

public class SoyMilkDecorator extends AddOnDecorator {
    public SoyMilkDecorator(Beverage beverage) {
        super(beverage);
    }

    @Override
    String getDescription() {
        return super.getDescription() + " soy milk";
    }

    @Override
    double getCost() {
        return super.getCost() + 0.5;
    }
}
