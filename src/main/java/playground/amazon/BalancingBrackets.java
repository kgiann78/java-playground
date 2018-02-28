package playground.amazon;

import java.util.Stack;

public class BalancingBrackets {

    public int areBracketsBalanced(String input) {
        Stack<Character> brackets = new Stack<Character>();

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            switch (c) {
                case '(':
                case '[':
                case '{':
                case '<':
                    brackets.push(c);
                    break;
                case ')':
                    if (!brackets.isEmpty() && brackets.peek().equals('(')) brackets.pop();
                    else return 0;
                    break;
                case ']':
                    if (!brackets.isEmpty() && brackets.peek().equals('[')) brackets.pop();
                    else return 0;
                    break;
                case '}':
                    if (!brackets.isEmpty() && brackets.peek().equals('{')) brackets.pop();
                    else return 0;
                    break;
                case '>':
                    if (!brackets.isEmpty() && brackets.peek().equals('<')) brackets.pop();
                    else return 0;
                    break;
            }
        }

        if (!brackets.isEmpty()) return 0;

        return 1;
    }

    public static void main(String[] args) {
        BalancingBrackets balancingBrackets = new BalancingBrackets();
        String input = "{{[[$fe]|43(fs;())]}}";

        System.out.println(balancingBrackets.areBracketsBalanced(input));
    }

}
