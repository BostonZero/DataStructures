public class Josephus {
    public static void main(String[] args) {
        // Get N and M from command line as ints.
        ...
        
        // Create a queue q and enqueue integers
        // 1, 2, ... N.
        ...
        
        int i = 0;
        // As long as q is not empty: increment i;
        // dequeue an element pos; if M divides i,
        // write pos, otherwise enqueue pos.
        ...
    }
}
