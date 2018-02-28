package playground.amazon;

/*
    For two given rectangles find the amount of area when these rectangles are overlapping
    A rectangle is represented by two points in the cartesian axes, one of the top right most corner
    and one of the bottom left most one.
 */
public class OverlappingRectangles {
    enum Axes {
        X,
        Y;
    }

    public static void main(String[] args) {
        int[] Rectangle1Bottom = {2, 1};
        int[] Rectangle1Top = {5, 5};
        int[] Rectangle2Bottom = {3, 2};
        int[] Rectangle2Top = {5, 7};

        System.out.println(getOverlappingArea(Rectangle1Bottom, Rectangle2Bottom, Rectangle1Top, Rectangle2Top));
    }

    private static int max(int a, int b) {
        if (a > b) return a;
        return b;
    }

    private static int min(int a, int b) {
        if (a > b) return b;
        return a;
    }

    private static int getOverlappingArea(int[] rect1B, int[] rect2B, int[] rect1T, int[] rect2T) {

        int xDistance = getDistance(rect1B, rect2B, rect1T, rect2T, Axes.X);
        int yDistance = getDistance(rect1B, rect2B, rect1T, rect2T, Axes.Y);

        if (xDistance < 0 || yDistance < 0) return -1;
        else
            return xDistance * yDistance;
    }

    private static int getDistance(int[] rect1B, int[] rect2B, int[] rect1T, int[] rect2T, Axes axes) {
        int max;
        int min;

        if (axes == Axes.X) {
            max = max(rect1B[0], rect2B[0]);
            min = min(rect1T[0], rect2T[0]);
        } else {
            max = max(rect1B[1], rect2B[1]);
            min = min(rect1T[1], rect2T[1]);
        }

        return min - max;
    }
}
