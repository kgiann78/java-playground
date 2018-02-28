package playground.booking;

public class Vacancy {
    static class tuple {
        private final int key;
        private final int value;

        public tuple(int key, int value) {
            this.key = key;
            this.value = value;
        }

        public int getKey() {
            return key;
        }

        public int getValue() {
            return value;
        }

        @Override
        public String toString() {
            return "tuple{" +
                    "key=" + key +
                    ", value=" + value +
                    '}';
        }
    }

    public static void main(String[] args) {
        tuple[] bookings = new tuple[10];

        int arrival = 1;
        int departure = 3;

        for (int i = 0; i < bookings.length; i++) {
            bookings[i] = new tuple(arrival, departure);
            arrival += 1;
            System.out.println(bookings[i]);
        }

        int checkDate = 4;
        int total = 0;
        for (int i = 0; i < bookings.length; i++) {
            arrival = bookings[i].getKey();
            if (arrival > checkDate) break;

            if (arrival + bookings[i].getValue() >= checkDate)
                total++;
        }

        System.out.println(total);
    }
}
