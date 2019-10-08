// Estimates percolation threshold for an N-by-N percolation system.
public class PercolationStats {
    ...

    // Performs T independent experiments (Monte Carlo simulations) on an 
    // N-by-N grid.
    public PercolationStats(int N, int T) {
        ...
    }
    
    // Returns sample mean of percolation threshold.
    public double mean() {
        ...
    }

    // Returns sample standard deviation of percolation threshold.
    public double stddev() {
        ...
    }

    // Returns low endpoint of the 95% confidence interval.
    public double confidenceLow() {
        ...
    }

    // Returns high endpoint of the 95% confidence interval.
    public double confidenceHigh() {
        ...
    }

    // Test client. [DO NOT EDIT]
    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        int T = Integer.parseInt(args[1]);
        PercolationStats stats = new PercolationStats(N, T);
        StdOut.printf("mean           = %f\n", stats.mean());
        StdOut.printf("stddev         = %f\n", stats.stddev());
        StdOut.printf("confidenceLow  = %f\n", stats.confidenceLow());
        StdOut.printf("confidenceHigh = %f\n", stats.confidenceHigh());
    }
}
