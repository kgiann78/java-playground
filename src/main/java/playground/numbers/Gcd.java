package playground.numbers;

public class Gcd {

    public int euclideGcd(int n1, int n2) {
        if (n2 == 0) {
            return n1;
        } else {
            return euclideGcd(n1, n1 % n2);
        }
    }

    public int binaryGcd(int n1, int n2) {
        if (n1 == 0) return n2;
        if (n2 == 0) return n1;

        if (n1 % 2 == 0 && n2 % 2 == 0) {
            return 2 * binaryGcd(n1 / 2, n2 / 2);
        } else if (n1 % 2 == 0 && n2 % 2 != 0) {
            return 2 * binaryGcd(n1 / 2, n2);
        } else if (n2 % 2 == 0 && n1 % 2 != 0) {
            return 2 * binaryGcd(n1, n2 / 2);
        } else {
            if (n1 >= n2) {
                return binaryGcd((n1-n2)/2, n2);
            } else {
                return binaryGcd(n1, (n2-n1)/2);
            }
        }
    }

    

    public static void main(String[] args) {
        Gcd myGcd = new Gcd();
        int result = myGcd.euclideGcd(4, 6);
        System.out.println(result);

        result = myGcd.binaryGcd(4, 6);
        System.out.println(result);

    }
}
