import java.util.Arrays;
import java.util.Comparator;

// An immutable data type representing a 3D point.
public class Point3D implements Comparable<Point3D> {
    private final double x; // x coordinate
    private final double y; // y coordinate
    private final double z; // z coordinate

    // Construct a point in 3D given its coordinates.
    public Point3D(double x, double y, double z) {
        ...
    }

    // The Euclidean distance between this point and that.
    public double distance(Point3D that) {
        ...
    }

    // -1, 0, or 1 depending on this point's Euclidean
    // distance to the origin (0, 0, 0) is less than,
    // equal to, or greater than that point's Euclidean
    // distance to the origin.
    public int compareTo(Point3D that) {
        ...
    }

    // An x-coordinate comparator.
    public static Comparator<Point3D> xOrder() {
        ...
    }

    // Helper x-coordinate comparator.
    private static class XOrder implements Comparator<Point3D> {
        // -1, 0, or 1 depending on whether p1's x-coordinate
        // is less than, equal to, or greater than p2's
        // x-coordinate.
        public int compare(Point3D p1, Point3D p2) {
            ...
        }
    }

    // A y-coordinate comparator.
    public static Comparator<Point3D> yOrder() {
        ...
    }
    
    // Helper y-coordinate comparator.
    private static class YOrder implements Comparator<Point3D> {
        // -1, 0, or 1 depending on whether p1's y-coordinate
        // is less than, equal to, or greater than p2's
        // y-coordinate.
        public int compare(Point3D p1, Point3D p2) {
            ...
        }
    }

    // A z-coordinate comparator.
    public static Comparator<Point3D> zOrder() {
        ...
    }

    // Helper z-coordinate comparator.
    private static class ZOrder implements Comparator<Point3D> {
        // -1, 0, or 1 depending on whether p1's z-coordinate
        // is less than, equal to, or greater than p2's
        // z-coordinate.
        public int compare(Point3D p1, Point3D p2) {
            ...
        }
    }

    // A string representation of the point, as "(x, y, z)".
    public String toString() {
        ...
    }

    // Test client. [DO NOT EDIT]
    public static void main(String[] args) {
        int n = StdIn.readInt();
        Point3D[] points = new Point3D[n];
        for (int i = 0; i < n; i++) {
            double x = StdIn.readDouble();
            double y = StdIn.readDouble();
            double z = StdIn.readDouble();
            points[i] = new Point3D(x, y, z);
        }
        for (Point3D point : points) {
            StdOut.println(point);
        }
        Arrays.sort(points);
        for (Point3D point : points) {
            StdOut.println(point);
        }
        Arrays.sort(points, Point3D.xOrder());
        for (Point3D point : points) {
            StdOut.println(point);
        }
        Arrays.sort(points, Point3D.yOrder());
        for (Point3D point : points) {
            StdOut.println(point);
        }
        Arrays.sort(points, Point3D.zOrder());
        for (Point3D point : points) {
            StdOut.println(point);
        }
    }
}
