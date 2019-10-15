import java.util.*; 

// An immutable data type to systematically iterate over the
// first n primes.
public class Primes implements Iterable<Integer> {
    private final int n; // need first n primes

    // Construct an iterable Primes object given the number
    // of primes needed.
    public Primes(int n) {
        this.n = n; //only thing the type needs is how many primes to iterate
    }
    
    // A PrimesIterator object.
    public Iterator<Integer> iterator() {
        return new PrimesIterator(); //returns a new obeject but adds the iterator to it
    }
    
    // Primes iterator.
    private class PrimesIterator implements Iterator<Integer> {
        private int count; // number of primes returned
        private int p;     // current prime

        // Construct a PrimesIterator object.
        PrimesIterator() {
            count = 0;
            p = 1;
        }
        
        // Are there anymore primes left to be iterated?
        public boolean hasNext() { 
            return count < n;
        }//method close

        // The next prime.
        public Integer next() {
            // Increment count by 1.
            count++; //count incrementation 
            while(true){
                p++; //up the number, check for prime, come back here if it isnt
                if(isPrime(p)) return p;
            }//while close
        }//method close

        // Remove is not supported.
        public void remove() {
            // nothing to do
        }
        // Is x (>= 2) prime?
        private boolean isPrime(int x) {
            for (int i = 2; i <= x / i; i++) {
                if (x % i == 0) {
                    return false;
                }
            }
            return true;
        }
    }
    // Test client. [DO NOT EDIT]
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        for (int i : new Primes(n)) {
            StdOut.println(i);
        }
    }
}
