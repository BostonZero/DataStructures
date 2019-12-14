public class KdTreePointST<Value> implements PointST<Value> {
    ...
    
    // 2d-tree (generalization of a BST in 2d) representation.
    private class Node {
        private Point2D p;   // the point
        private Value val;   // the symbol table maps the point to this value
        private RectHV rect; // the axis-aligned rectangle corresponding to 
                             // this node
        private Node lb;     // the left/bottom subtree
        private Node rt;     // the right/top subtree

        // Construct a node given the point, the associated value, and the 
        // axis-aligned rectangle corresponding to the node.
        Node(Point2D p, Value val, RectHV rect) {
            this.p = p;
            this.val = val;
            this.rect = rect;
        }
    }

    // Construct an empty symbol table of points.
    public KdTreePointST() {
        ...
    }

    // Is the symbol table empty?
    public boolean isEmpty() { 
        ...
    }

    // Number of points in the symbol table.
    public int size() {
        ...
    }

    // Associate the value val with point p.
    public void put(Point2D p, Value val) {
        ...
    }

    // Helper for put(Point2D p, Value val).
    private Node put(Node x, Point2D p, Value val, RectHV rect, boolean lr) {
        ...
    }

    // Value associated with point p.
    public Value get(Point2D p) {
        ...
    }

    // Helper for get(Point2D p).
    private Value get(Node x, Point2D p, boolean lr) {
        ...
    }

    // Does the symbol table contain the point p?
    public boolean contains(Point2D p) {
        ...
    }

    // All points in the symbol table, in level order.
    public Iterable<Point2D> points() {
        ...
    }

    // All points in the symbol table that are inside the rectangle rect.
    public Iterable<Point2D> range(RectHV rect) {
        ...
    }

    // Helper for public range(RectHV rect).
    private void range(Node x, RectHV rect, Queue<Point2D> q) {
        ...
    }

    // A nearest neighbor to point p; null if the symbol table is empty.
    public Point2D nearest(Point2D p) {
        ...
    }
    
    // Helper for public nearest(Point2D p).
    private Point2D nearest(Node x, Point2D p, Point2D nearest, 
                            double nearestDistance, boolean lr) {
        ...
    }

    // k points that are closest to point p.
    public Iterable<Point2D> nearest(Point2D p, int k) {
        ...
    }

    // Helper for public nearest(Point2D p, int k).
    private void nearest(Node x, Point2D p, int k, MaxPQ<Point2D> pq, 
                         boolean lr) {
        ...
    }

    // Test client. [DO NOT EDIT]
    public static void main(String[] args) {
        KdTreePointST<Integer> st = new KdTreePointST<Integer>();
        double qx = Double.parseDouble(args[0]);
        double qy = Double.parseDouble(args[1]);
        double rx1 = Double.parseDouble(args[2]);
        double rx2 = Double.parseDouble(args[3]);
        double ry1 = Double.parseDouble(args[4]);
        double ry2 = Double.parseDouble(args[5]);
        int k = Integer.parseInt(args[6]);
        Point2D query = new Point2D(qx, qy);
        RectHV rect = new RectHV(rx1, ry1, rx2, ry2);
        int i = 0;
        while (!StdIn.isEmpty()) {
            double x = StdIn.readDouble();
            double y = StdIn.readDouble();
            Point2D p = new Point2D(x, y);
            st.put(p, i++);
        }
        StdOut.println("st.empty()? " + st.isEmpty());
        StdOut.println("st.size() = " + st.size());
        StdOut.println("First " + k + " values:");
        i = 0;
        for (Point2D p : st.points()) {
            StdOut.println("  " + st.get(p));
            if (i++ == k) {
                break;
            }
        }
        StdOut.println("st.contains(" + query + ")? " + st.contains(query));
        StdOut.println("st.range(" + rect + "):");
        for (Point2D p : st.range(rect)) {
            StdOut.println("  " + p);
        }
        StdOut.println("st.nearest(" + query + ") = " + st.nearest(query));
        StdOut.println("st.nearest(" + query + ", " + k + "):");
        for (Point2D p : st.nearest(query, k)) {
            StdOut.println("  " + p);
        }
    }
}
