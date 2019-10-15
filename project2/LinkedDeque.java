import java.util.Iterator;
import java.util.NoSuchElementException;

// Deque implementation using a linked list.
public class LinkedDeque<Item> implements Iterable<Item> {
    private Node head;
    private Node tail; 
    private int size;

    // Helper doubly-linked list class.
    private class Node {
        private Item item;
        private Node next;
        private Node prev;
        public Node(Item item){
            this.item = item;
            this.next = null;
            this.prev = null;
        }
    }

    // Construct an empty deque.
    public LinkedDeque() {
        head = null;
        tail = null; 
        size = 0;
    }

    // Is the deque empty?
    public boolean isEmpty() {return size==0;}

    // The number of items on the deque.
    public int size() {return size;}

    // Add item to the front of the deque.
    public void addFirst(Item item) {
        if(item == null){throw new NullPointerException();}
        Node temp = new Node(item);
        if(isEmpty()){
            head = temp;
            tail = temp;
        }else{
            temp.next = head;
            head.prev = temp;
            head = temp;
        }
        size++;
    }

    // Add item to the end of the deque.
    public void addLast(Item item) {
        if(item == null){throw new NullPointerException();}
        Node temp = new Node(item);
        if(isEmpty()){
            head = temp;
            tail = temp;
        }else{
            temp.last = tail;
            tail.next = temp;
            tail = temp;
        }
    }

    // Remove and return item from the front of the deque.
    public Item removeFirst() {
        if(isEmpty()){throw new NoSuchElementException();}
            Item item = head.item;
            if(size==1){
                head = null;
                tail = null;
            }else{
                head = head.next;
                head.prev = null;
            }
            size--;
            return item;
    }

    // Remove and return item from the end of the deque.
    public Item removeLast() {
        if(isEmpty()){throw new NoSuchElementException();}
        Item item = tail.item;
        if(size==1){
            head = null;
            tail = null;
        }else{
            tail = tail.prev;
            tail.next = null;
        }
        size--;
        return item;
    }

    // An iterator over items in the queue in order from front to end.
    public Iterator<Item> iterator() {
        return new DequeIterator();
    }
    
    // An iterator, doesn't implement remove() since it's optional.
    private class DequeIterator implements Iterator<Item> {
        private Node current;
        
        DequeIterator() {this.current = head;}

        public boolean hasNext()  {return current != null;}

        public void remove() {throw new UnsupportedOperationException();}

        public Item next() {
            Item item = current.item;
            current = current.next;
            return item;

        }
    }

    // A string representation of the deque.
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (Item item : this) {
            s.append(item + " ");
        }
        return s.toString().substring(0, s.length() - 1);
    }
    
    // Test client. [DO NOT EDIT]
    public static void main(String[] args) {
        LinkedDeque<Character> deque = new LinkedDeque<Character>();
        String quote = "There is grandeur in this view of life, with its " 
            + "several powers, having been originally breathed into a few " 
            + "forms or into one; and that, whilst this planet has gone " 
            + "cycling on according to the fixed law of gravity, from so " 
            + "simple a beginning endless forms most beautiful and most " 
            + "wonderful have been, and are being, evolved. ~ " 
            + "Charles Darwin, The Origin of Species";
        int r = StdRandom.uniform(0, quote.length());
        for (int i = quote.substring(0, r).length() - 1; i >= 0; i--) {
            deque.addFirst(quote.charAt(i));
        }
        for (int i = 0; i < quote.substring(r).length(); i++) {
            deque.addLast(quote.charAt(r + i));
        }
        StdOut.println(deque.isEmpty());
        StdOut.printf("(%d characters) ", deque.size());
        for (char c : deque) {
            StdOut.print(c);
        }
        StdOut.println();
        double s = StdRandom.uniform();
        for (int i = 0; i < quote.length(); i++) {
            if (StdRandom.bernoulli(s)) {
                deque.removeFirst();
            }
            else {
                deque.removeLast();
            }
        }
        StdOut.println(deque.isEmpty());
    }
}
