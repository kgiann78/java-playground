package playground.designpatterns.decorator;


/**
 * Decorator Pattern
 *
 * As seen in Decorator Pattern – Design Patterns (ep 3) from Christopher Okhravi
 * [https://www.youtube.com/watch?v=GCraGHx6gso]
 */

public class App {
    public static void main(String[] args) {
        Beverage espresso = new Espresso();
        Beverage decaffeinate = new Decaffeinate();

        System.out.println("A plain " + espresso.getDescription() + " costs " + espresso.getCost());
        System.out.println("A plain " + decaffeinate.getDescription() + " costs " + decaffeinate.getCost());

        Beverage espressoWithCaramel = new CaramelDecorator(espresso);
        Beverage decaffeinateWithSoyMilk = new SoyMilkDecorator(decaffeinate);
        Beverage espressoWithCaramelAndSoyMilk = new SoyMilkDecorator(new CaramelDecorator(espresso));

        System.out.println(espressoWithCaramel.getDescription() + " costs " + espressoWithCaramel.getCost());
        System.out.println(decaffeinateWithSoyMilk.getDescription() + " costs " + decaffeinateWithSoyMilk.getCost());
        System.out.println(espressoWithCaramelAndSoyMilk.getDescription() + " costs " + espressoWithCaramelAndSoyMilk.getCost());
    }
}
