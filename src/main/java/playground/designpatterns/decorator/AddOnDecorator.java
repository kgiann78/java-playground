package playground.designpatterns.decorator;

public abstract class AddOnDecorator extends Beverage {
    private Beverage beverage;

    /*
        We hide the no arguments constructor because we want explicitly
        out addon decorator to have a Beverage instance.
     */
    private AddOnDecorator() {

    }

    public AddOnDecorator(Beverage beverage) {
        this.beverage = beverage;
    }

    /*
        In order to hide the beverage element and still access the Beverage methods
        we are implementing these methods here.

        A twist to the example shown in the video...

        When our beverage is a concrete object (such as an espresso or a decaffeinate)
        and we add something in/on it for the first time the we usually say:
        An espresso with cream, or, an espresso with caramel.

        On the other hand, if the beverage is already an addon (an espresso with caramel)
        then adding something more would go more naturally with, 'and', i.e
        an espresso with caramel and soy milk
     */
    @Override
    String getDescription() {
        if (beverage instanceof AddOnDecorator)
            return beverage.getDescription() + " and";
        else
            return beverage.getDescription() + " with";
    }

    @Override
    double getCost() {
        return beverage.getCost();
    }
}
