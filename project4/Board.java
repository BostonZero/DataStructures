// Models a board in the 8-puzzle game or its generalization.
public class Board {
    ...
    
    // Construct a board from an N-by-N array of tiles, where 
    // tiles[i][j] = tile at row i and column j, and 0 represents the blank 
    // square.
    public Board(int[][] tiles) {
        ...
    }

    // Tile at row i and column j.
    public int tileAt(int i, int j) {
        ...
    }
    
    // Size of this board.
    public int size() {
        ...
    }

    // Number of tiles out of place.
    public int hamming() {
        ...
    }

    // Sum of Manhattan distances between tiles and goal.
    public int manhattan() {
        ...
    }

    // Is this board the goal board?
    public boolean isGoal() {
        ...
    }

    // Is this board solvable?
    public boolean isSolvable() {
        ...
    }

    // Does this board equal that?
    public boolean equals(Board that) {
        ...
    }

    // All neighboring boards.
    public Iterable<Board> neighbors() {
        ...
    }

    // String representation of this board.
    public String toString() {
        String s = N + "\n";
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                s += String.format("%2d", tiles[i][j]);
                if (j < N - 1) {
                    s += " ";
                }
            }
            if (i < N - 1) {
                s += "\n";
            }
        }
        return s;
    }

    // Helper method that returns the position (in row-major order) of the 
    // blank (zero) tile.
    private int blankPos() {
        ...
    }

    // Helper method that returns the number of inversions.
    private int inversions() {
        ...
    }

    // Helper method that clones the tiles[][] array in this board and 
    // returns it.
    private int[][] cloneTiles() {
        ...
    }

    // Test client. [DO NOT EDIT]
    public static void main(String[] args) {
        In in = new In(args[0]);
        int N = in.readInt();
        int[][] tiles = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                tiles[i][j] = in.readInt();
            }
        }
        Board board = new Board(tiles);
        StdOut.println(board.hamming());
        StdOut.println(board.manhattan());
        StdOut.println(board.isGoal());
        StdOut.println(board.isSolvable());
        for (Board neighbor : board.neighbors()) {
            StdOut.println(neighbor);
        }
    }
}
