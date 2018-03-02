package playground.designpatterns.prototype;

class Point
{
    public int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Point(Point other) {
        this.x = other.x;
        this.y = other.y;
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}

class Line
{
    public Point start, end;

    public Line(Point start, Point end) {
        this.start = new Point(start);
        this.end = new Point(end);
    }

    public Line deepCopy()
    {
        // todo
        return new Line(start, end);
    }

    @Override
    public String toString() {
        return "Line{" +
                "start=" + start +
                ", end=" + end +
                '}';
    }
}

public class DeepCopy {
    public static void main(String[] args) {
        Point start = new Point(4, 5);
        Point end = new Point(7,8);
        Line line = new Line(start, end);
        Line line2 = line.deepCopy();

        line2.start.x = 5;
        line2.end.x = 6;

        System.out.println(line);
        System.out.println(line2);
    }
}
