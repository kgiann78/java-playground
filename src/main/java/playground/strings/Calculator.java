package playground.strings;

import java.util.Stack;

public class Calculator {

    public static double calculate(String digitText) {

        if (digitText.isEmpty()) return -1.0;

        Stack<Double> additions = new Stack<>();
        Stack<Double> digits = new Stack<>();
        Stack<String> symbols = new Stack<>();
        double calc;

        for (String digit : digitText.split(" ")) {
            if (digit.equals("+")
                    || digit.equals("-")
                    || digit.equals("*")
                    || digit.equals("/")) {
                symbols.add(digit);
            } else {
                try {
                    digits.add(Double.parseDouble(digit));
                } catch (NumberFormatException e) {
                    return -1.0;
                }
            }
        }

        if (digits.isEmpty()) return -1.0;

        calc = digits.pop();

        while (!digits.isEmpty()) {
            double tmp1 = digits.pop();

            if (symbols.peek() != null) {
                String symbol = symbols.pop();
//                System.out.print(calc + symbol + tmp1 + "=");

                switch (symbol) {
                    case "*":
                        calc *= tmp1;
                        break;
                    case "/":
                        calc = tmp1 / calc;
                        break;
                    case "+":
                        additions.add(calc);
                        calc = tmp1;
                        break;
                    case "-":
                        calc *= (-1.0);
                        additions.add(calc);
                        calc = tmp1;
                        break;
                }

//                System.out.println(calc);
            }
        }

        while (!additions.isEmpty()) {
            calc += additions.pop();
        }

        return calc;
    }

    public static void main(String[] args) {
        System.out.println(calculate("1.0 * 2.0 / 3.0 * 4.0 - 25.0 / 5.0"));
    }
}
