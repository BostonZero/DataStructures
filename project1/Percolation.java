import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;



// Models an N-by-N percolation system.
public class Percolation {
	private int N;
	private boolean[][] open;
	private int openSites;
	private WeightedQuickUnionUF uf;

    // Creates an N-by-N grid, with all sites blocked.
    public Percolation(int N) {
        if (N <= 0) throw new IllegalArgumentException("Input is 0 or less. User is a dummy.");
        this.N = N;
        uf = new WeightedQuickUnionUF(this.N*this.N);
        open = new boolean[this.N][this.N];
        openSites = 0;
    }

    // Opens site (i, j) if it is not open already.
    public void open(int i, int j) {
        if (i > N || j > N || i < 0 || j < 0) throw new IllegalArgumentException("Tried to open a nonexistent coordinate. User is a dummy.");
	    if (open[i][j] == false){
            open[i][j] = true;
            openSites++;
	    }
    }

    // Checks if site (i, j) is open.
    public boolean isOpen(int i, int j) {
              // System.out.println("i is: " + i + " j is: " + j);
               if (i > N || j > N || i < 0 || j < 0) throw new IllegalArgumentException("Tried to isOpen a nonexistent coordinate. User is a dummy.");
	
        if (open[i][j] == false){
		    return false;
	    }
	    else return true;
    }

    // Checks if site (i, j) is full.
    public boolean isFull(int i, int j) {
        if(uf.connected(0,encode(i,j)) == true){
            return true;
        }
        return false;
    }

    // Returns the number of open sites.
    public int numberOfOpenSites() {
        return openSites; //simple incrementation
    }

    // Checks if the system percolates.
    public boolean percolates() {
        //in order to addresss the corner case of things being filled through the sink i will just check each of the last row squares against the source directly
	//switch cases do this in row order middle check first since that will be the most popular case
        for(int row = 0; row < N; row++){
            for(int col = 0; col < N; col++){
              //  System.out.println("checking coords ("+  row + "," + col + ")");
                if(isOpen(row,col) == true){
                    if(row != 0 && isOpen(row - 1, col) == true){
                        uf.union(encode(row,col),encode(row-1,col));
                    }//checknorth
                    if(col < N - 1 && isOpen(row,col+1) == true){
                        uf.union(encode(row,col),encode(row,col + 1));
                    }//checkeast
                    if(col != 0 && isOpen(row,col-1) == true){
                        uf.union(encode(row,col),encode(row,col-1));
                    }//checkwest
                    if(row < N - 1 && isOpen(row+1,col) == true){
                        uf.union(encode(row,col),encode(row+1,col));
                    }//checksouth
                    //checks and unions complete
                    if (row == 0){
                        uf.union(0,encode(row,col));
                    }//connect source to top row

                }//only process square if it's open.
            }
        }
        for(int col = 0; col < N; col++){
            if(isFull(N-1, col) == true){
                return true;
            } 
        }
        return false;
    }


    // Returns an integer ID (1...N) for site (i, j).
    private int encode(int i, int j) {
        return i*7+j+1;
    }

    // Test client. [DO NOT EDIT]
    public static void main(String[] args) {
        String filename = args[0];
        In in = new In(filename);
        int N = in.readInt();
        Percolation perc = new Percolation(N);
        while (!in.isEmpty()) {
            int i = in.readInt();
            int j = in.readInt();
            perc.open(i, j);
        }
        StdOut.println(perc.numberOfOpenSites() + " open sites");
        if (perc.percolates()) {
            StdOut.println("percolates");
        }
        else {
            StdOut.println("does not percolate");
        }
        
        // Check if site (i, j) optionally specified on the command line
        // is full.
        if (args.length == 3) {
            int i = Integer.parseInt(args[1]);
            int j = Integer.parseInt(args[2]);
            StdOut.println(perc.isFull(i, j));
        }
    }
}
