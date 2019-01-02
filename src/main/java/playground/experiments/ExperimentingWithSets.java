package playground.experiments;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ExperimentingWithSets {
    private static Logger logger = Logger.getLogger(ExperimentingWithSets.class.getName());

    public static void main(String[] args) {

        Set<Custom> set = new HashSet<>();

        String addOne = String.valueOf(set.add(new Custom().withName("one").withNumber(1)));
        String addTwo = String.valueOf(set.add(new Custom().withName("two").withNumber(2)));
        String addThree = String.valueOf(set.add(new Custom().withName("three").withNumber(3)));
        String addFour = String.valueOf(set.add(new Custom().withName("four").withNumber(4)));
        String addOneAgain = String.valueOf(set.add(new Custom().withName("one").withNumber(1)));
        String addTwoAgain = String.valueOf(set.add(new Custom().withName("two").withNumber(2)));
        String addThreeAgain = String.valueOf(set.add(new Custom().withName("three").withNumber(3)));
        String addFourAgain = String.valueOf(set.add(new Custom().withName("four").withNumber(4)));

        logger.log(Level.INFO, addOne);
        logger.log(Level.INFO, addTwo);
        logger.log(Level.INFO, addThree);
        logger.log(Level.INFO, addFour);
        logger.log(Level.INFO, addOneAgain);
        logger.log(Level.INFO, addTwoAgain);
        logger.log(Level.INFO, addThreeAgain);
        logger.log(Level.INFO, addFourAgain);

        logger.log(Level.INFO, set.toString());
    }

    static class Custom {
        String name;
        int number;

        public Custom withName(String name) {
            this.name = name;
            return this;
        }

        public Custom withNumber(int number) {
            this.number = number;
            return this;
        }

        @Override
        public boolean equals(Object o) {
//            if (this == o) return true;
//            if (o == null || getClass() != o.getClass()) return false;
//            Custom custom = (Custom) o;
//            return number == custom.number &&
//                    Objects.equals(name, custom.name);
            return true;
        }

        @Override
        public int hashCode() {

//            return Objects.hash(name, number);
            return 0;
        }

        @Override
        public String toString() {
            return "Custom{" +
                    "name='" + name + '\'' +
                    ", number=" + number +
                    '}';
        }
    }

}
