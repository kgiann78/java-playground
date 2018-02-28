package playground.google;

/*
    It is given an array of towers (integers). Actually the array contains their heights but each position represents a building.
    A hopper is set in the top of the first building. The hopper should move to the end of the array and over it,
    by jumping from building to building.

    The amount of positions he moves towards the end of the array depends on how tall is the building is standing
    at the current moment.

    i.e. If the hopper is standing on a building of height 4, he can jump UP TO 4 positions
    to the right. The hopper can jump less than 4, if he believes that a building high enough is located in position
    2 or 3 (other than 4) that he can take advantage of its height.

    The game ends when the hopper reaches not at the end of the array but beyond it.
    Create a method that returns if the hopper can cross the array of towers.
 */
public class TowerHopper {
    public static void main(String[] args) {
        int[] towers = {4, 2, 0, 0, 4, 0};

        long start = System.nanoTime();
        System.out.println(hopperCanCrossArray(towers));
        long stop = System.nanoTime();
        System.out.println("Time consumption: " + (stop - start));

        start = System.nanoTime();
        System.out.println(hopperCanCrossArrayNextStepApproach(towers));
        stop = System.nanoTime();
        System.out.println("Time consumption: " + (stop - start));
    }

    private static boolean hopperCanCrossArray(int[] towers) {
        return hopperCanCrossArray(towers, 0);
    }

    private static boolean hopperCanCrossArray(int[] towers, int index) {
        if (index >= towers.length) return true;

        int currentHeight = towers[index];
        if (currentHeight == 0) return false;

        for (int i = 1; i <= currentHeight; i++) {
            if (hopperCanCrossArray(towers, index + i)) return true;
        }

        return false;
    }

    private static boolean hopperCanCrossArrayNextStepApproach(int[] towers) {
        int index = 0;
        int maxStep = 0;
        do {
            maxStep = nextStep(towers, index);
            if (maxStep == 0 && index >= towers.length) return true;
            else if (maxStep == 0) return false;
            else index += maxStep;
        } while (maxStep > 0);
        return false;
    }

    private static int nextStep(int[] towers, int index) {
        if (index >= towers.length) return 0;
        if (towers[index] == 0) return 0;
        int maxStep = 0;
        int max = 0;
        for (int i = 1; i <= towers[index]; i++) {
            if (index + i >= towers.length) return i;
            if (towers[index + i] > max) {
                maxStep = i;
            }
        }

        return maxStep;
    }
}
