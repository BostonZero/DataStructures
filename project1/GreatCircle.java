import edu.princeton.cs.algs4.*;
import edu.princeton.cs.algs4.StdOut;

public class GreatCircle {
    public static void main(String[] args) {
        // Get angles x1, y1, x2, and y2 from command line as
        // double
	double x1 = Double.parseDouble(args[0]);
	double y1 = Double.parseDouble(args[1]);
	double x2 = Double.parseDouble(args[2]);
	double y2 = Double.parseDouble(args[3]);
	double d; // will be used for the final int later


        
        // Convert the angles to radians.
       //LIBRARY FUNCTION FOR CONVERSION DO NOT MAKE YOUR OWN METHOD 
	x1 = Math.toRadians(x1);
	x2 = Math.toRadians(x2);
	y1 = Math.toRadians(y1);
	y2 = Math.toRadians(y2);





        // Calculate great-circle distance d.
	double s1 = Math.sin(x1);
	double s2 = Math.sin(x2);
	double c1 = Math.cos(x1);
	double c2 = Math.cos(x2);
	double c3 = Math.cos(y1-y2);
	double ac = Math.acos(s1*s2+c1*c2*c3);
        d = 111*ac;

	
	
	
	//convert back to degrees
	d = Math.toDegrees(d);

	
        // Write d
	System.out.println(d);
    }
}
