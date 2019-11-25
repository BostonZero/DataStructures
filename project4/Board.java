// Models a board in the 8-puzzle game or its generalization.
public class Board {
    private final int[][] tiles;
    private final int n;

    // Construct a board from an N-by-N array of tiles, where 
    // tiles[i][j] = tile at row i and column j, and 0 represents the blank 
    // square.
    public Board(int[][] tiles) {//iterate through, copying to this
		this.n = tiles.length;
    	this.tiles = new int[n][n];
    	for (int i = 0; i < n; i++){
        	for (int j = 0; j < n; j++){
            	this.tiles[i][j] = tiles[i][j];
    		}//inner for
		}//outer for
    }//board

    // Tile at row i and column j.
    public int tileAt(int i, int j) {return this.tiles[i][j];}//simple return
    
    // Size of this board.
    public int size() {return this.n;}//simple return

    // Number of tiles out of place.
    public int hamming() {
    int dist=0;
    int count=1;
    for(int i=0;i<n;i++){
        for(int j=0;j<n;j++){
            if(i==n-1&&j==n-1&&tiles[i][j]!=0)
                dist++;
            else if(tiles[i][j]!=count)
                dist++;
        }
    }
    return dist;
    }

    // Sum of Manhattan distances between tiles and goal.
    public int manhattan() {
    int dist=0;
    for(int i=0;i<n;i++){
        for(int j=0;j<n;j++){
            if(tiles[i][j]==0){
                dist+=(n-1-i)+(n-1-j);
            }
            else{
                int tj=(tiles[i][j]-1)%n;
                int ti=(tiles[i][j]-1)/n;
                dist+=Math.abs(ti-i)+Math.abs(tj-j);
            }
        }
    }
    return dist;
    }

    // Is this board the goal board?
    public boolean isGoal() {
    if(hamming()==0){return true;}
    return false;    
	}

    // Is this board solvable?
    public boolean isSolvable() {
    if(inversions()%2==0){return true;}
    return false;
	}

    // Does this board equal that?
    public boolean equals(Board that) {
	if(this.n!=that.n){return false;} //quick check on size
    for(int i=0;i<n;i++){
		for(int j=0;j<n;j++){
			if(this.tiles[i][j]!=that.tiles[i][j]){
			return false;}//check through board for a tile mismatch
        }//inner
    }//outer
    return true;
    }

    // All neighboring boards.
    public Iterable<Board> neighbors() {
		int pos=blankPos()-1;
		int i=pos/n;
		int j=pos%n;
		int a[][]=null;
		Board temp=null;
		List<Board> list=new ArrayList<Board>();
		if(i>0){
			a=cloneTiles();
			int t=a[i][j];
			a[i][j]=a[i-1][j];
			a[i-1][j]=t;
			list.add(new Board(a));
		}
		if(i<n-1){
			 a=cloneTiles();
			int t=a[i][j];
			a[i][j]=a[i+1][j];
			a[i+1][j]=t;
			list.add(new Board(a));
		}
		if(j>0){
			 a=cloneTiles();
			int t=a[i][j];
			a[i][j]=a[i][j-1];
			a[i][j-1]=t;
			list.add(new Board(a));
		}
		if(j<n-1){
			a=cloneTiles();
			int t=a[i][j];
			a[i][j]=a[i][j+1];
			a[i][j+1]=t;
			list.add(new Board(a));
		}
		return list;
	}//class end

    // String representation of this board. DONE FOR ME
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
    }//TOSTRING DONE FOR ME

    // Helper method that returns the position (in row-major order) of the 
    // blank (zero) tile.
    private int blankPos() {//this will iterate and every block it encounters will up the counter until we hit the 0 empty block
		int pos =0;
		for (int i = 0; i < n; i++){
			for (int j = 0; j < n; j++){
				if(tiles[i][j] == 0){return pos;}
				else {pos++;}
				}//if
			}//innerfor
		}//outerfor
    }//blankpos

    // Helper method that returns the number of inversions.
    private int inversions() {
    int inversion=0;
    for (int i=0;i<n;i++) {
        for (int j=0;j<n;j++) {
            for(int i2=0;i2<n;i2++){
            	for(int j2=0;j2<n;j2++){
                     if ((i2*n+l)>(i*n+j)&&tiles[i][j]!=0&&tiles[i2][j2]!=0&&tiles[i][j]>tiles[i2][j2]){
                        inversion++;}
                }//innermost j2
            }//inner i2
        }//outer j
    }//outermost i
    return inversion;
    }

    // Helper method that clones the tiles[][] array in this board and 
    // returns it.
    private int[][] cloneTiles() {
    int a[][]=new int[n][n];
    for(int i=0;i<n;i++){
        for(int j=0;j<n;j++){
            a[i][j]=tiles[i][j];
        }//inner for
    }//outer for
    return a;
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
