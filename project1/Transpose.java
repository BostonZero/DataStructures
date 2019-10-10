import edu.princeton.cs.algs4.*;
import edu.princeton.cs.algs4.StdOut;

public class Transpose {
    // Returns a new matrix that is the transpose of x.
    private static double[][] transpose(double[][] x) {
        // Create a new 2D matrix t (for transpose) with
        // dimensions n x m, where m x n are the dimensions
        // of x.
	int rows = x.length;
	int columns = x[0].length;
        double[][] t = new double[rows][columns];

        // For each 0 <= i < m and 0 <= j < n, set t[j][i]
        // to x[i][j].
        	for(int i=0; i < rows;i++){
			for (int j=0; j < columns;j++){
			t[j][i] = x[i][j];
			}
		}

        // Return t.
        return t;
    }

    // Entry point. [DO NOT EDIT]
    public static void main(String[] args) {
        double[][] x = StdArrayIO.readDouble2D();
        StdArrayIO.print(transpose(x));
    }
}
