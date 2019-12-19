public class ArrayST<Key, Value> {
    private static final int INIT_CAPACITY = 2;
    private Key[] keys;
    private Value[] values;
    private int N;

    // Create a symbol table with INIT_CAPACITY.
    public ArrayST() {
	keys = (Key[])   new Object[INIT_CAPACITY];
        values = (Value[]) new Object[INIT_CAPACITY];
    }

    // Create a symbol table with given capacity.
    public ArrayST(int capacity) {
        keys = (Key[])   new Object[capacity];
        values = (Value[]) new Object[capacity];
    }

    // Return the number of key-value pairs in the table.
    public int size() {
        return n;
    }

    // Return true if the table is empty and false otherwise.
    public boolean isEmpty() {
        if (size() == 0){return true;}
	return false;
    }

    // Return true if the table contains key and false otherwise.
    public boolean contains(Key key) {
	for (int i = 0; i < n; i++){
            if (keys[i].equals(key)) {return true;} //iterate through looking for key, if found return true
		}//end for
        return false; //if not found, false
    }

    // Return the value associated with key, or null.
    public Value get(Key key) {
        for (int i = 0; i < n; i++){
            if (keys[i].equals(key)) {return values[i];} //iterates through and finds matching key, then returns its value
	}//end for
		
        return null;//if key not found, return null
    }

    // Put the key-value pair into the table; remove key from table 
    // if value is null.
    public void put(Key key, Value value) {
        delete(key); //deleting the key first ensures that the there arent multiple entries of one key
        if (n >= values.length) {resize(2*n); //makes array twice as big if we need to
        values[n] = value; //set val
        keys[n] = key; //set key
        n++; //increment the counter for num of keys
    }

    // Remove key (and its value) from table.
    public void delete(Key key) {
		for (int i = 0; i < n; i++) {
			if (key.equals(keys[i])) {   //if the current iteration is the key we are trying to delete
                keys[i] = keys[n-1];  	 //change the key/value of the "deleted" entry to the last ones in array
                values[i] = values[n-1]; //^^
                keys[n-1] = null;		 //null last key/value
                values[n-1] = null;		 //^^ 
                n--; 					 //decrement the size counter  
                if (n > 0 && n == keys.length/4){
					resize(keys.length/2); //resize the array
				} //end if 
                return; //exit 
            }//end key if
        }//end for
    }//end method

    // Return all the keys in the table.
    public Iterable<Key> keys()  {
	Queue<Key> queue = new PriorityQueue<Key>();
        for (int i = 0; i < n; i++){
            queue.add(keys[i]);
	}//end for
        return queue;
		//makes the a queue and puts all keys in it, returns it
    }

    // Resize the internal arrays to capacity.
    private void resize(int capacity) {
        Key[] tempk = (Key[]) new Object[capacity];
        Value[] tempv = (Value[]) new Object[capacity];
        for (int i = 0; i < N; i++) {
            tempk[i] = keys[i];
            tempv[i] = values[i];
        }
        values = tempv;
        keys = tempk;
    }

    // Test client. [DO NOT EDIT]
    public static void main(String[] args) {
        ArrayST<String, Integer> st = new ArrayST<String, Integer>();
        int count = 0;
        while (!StdIn.isEmpty()) {
            String s = StdIn.readString();
            st.put(s, ++count);
        }
        for (String s : args) {
            st.delete(s);
        }
        for (String s : st.keys()) {
            StdOut.println(s + " " + st.get(s));
        }
    }
}
