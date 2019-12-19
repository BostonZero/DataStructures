public class Spell {
    public static void main(String[] args) {
        In in = new In(args[0]);
        String[] lines = in.readAllLines();
        in.close();

        // Create an ArrayST<String, String> object called st. 
        ArrayST<String, String> st = new ArrayST<String, String>(); 

        // For each line in lines, split it into two tokens using
        // "," as delimiter; insert into st the key-value pair
        // (token 1, token 2).
        for(int i = 0; i < lines.length; i++){
        	String[] half = lines[i].split(","); //split the string into 2 tokens
       		st.put(half[0], half[1]);//put the halves in the array
        }//end for 
            
        // Read from standard input one line at a time; increment
        // a line number counter; split the line into words using
        // "\\b" as the delimiter; for each word in words, if it
        // exists in st, write the (misspelled) word, its line number, and
        // corresponding value (correct spelling) from st.
        int count = 0; //counter for number of lines addressed
		while (!StdIn.isEmpty ()){
			string line = args[count]; //get the line
			String[] pieces = line.split("\\b");//break into words
			for(int i=0;i<pieces.length;i++){// for each word
				if (st.get(pieces[i]) != null){//if key exist
					StdOut.println(String.format("%s: %i -> %s", pieces[i],count,st.get(pieces[i])));//print the misspelled word, line, correct spelling
			}//for end
			count++; //increment the line counter
			
			
		}//while end
    }
}
