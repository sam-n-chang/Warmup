package warmup;

import java.util.Set;
import java.util.HashSet;

public class Quadratic {
    
    

    /**
     * Find the integer roots of a quadratic equation, ax^2 + bx + c = 0.
     * @param a coefficient of x^2
     * @param b coefficient of x
     * @param c constant term.  Requires that a, b, and c are not ALL zero.
     * @return all integers x such that ax^2 + bx + c = 0.
     */
    public static Set<Integer> roots(int a, int b, int c) throws IllegalArgumentException {
        double sol;          // rational solution of this equation
        double n;            // temp variable to hold 4*a*c
        double discriminant; // b^2 - 4*a*c
        final Set<Integer> solSet = new HashSet<Integer>(); // set of integer solutions
        
        if (a == 0) { // a is zero:
            if (b == 0) {
                if (c == 0) {  // if a, b, and c are ALL zero, throw an exception!
                    throw new IllegalArgumentException ("a, b, and c are ALL zero!");
                } else {  // if a=b=0, c is not zero, invalid equation!
                    throw new IllegalArgumentException ("Invalid function!");
                }
            } else { // if a=0, b is not zero, the solution is x = -c/b.
                sol = -c/b;
                if (sol == (int) sol)  {// check if the solution is an integer
                    solSet.add(-c/b);
                }
            }
        } else { // a is not zero then use quadratic formula:
                 // x = (-b + sqrt (b^2 - 4*a*c))/2*a
                 // x = (-b - sqrt (b^2 - 4*a*c))/2*a
            // We have to make sure b^2 - 4*a*c >= 0 to have rational solutions first.
            n = (double ) 4*a*c; // make sure we are big enough
            discriminant = Math.pow(b, 2) - n;
            if (discriminant < 0) {
                System.out.println ("No rational solutions!");
                return solSet;
            }
             sol = (-b + Math.sqrt (discriminant))/(2*a);
            if (sol == (int) sol)  {  // check if the solution is an integer 
                solSet.add((int) sol);
            }
            else {  // the solution exists but not an integer
                System.out.println("Solution is not an integer: " + sol);
            }
            sol = (-b - Math.sqrt (discriminant))/(2*a);
            if (sol == (int) sol)  {  // check if the solution is an integer 
                solSet.add((int) sol);
            } else {  // the solution exists but not an integer
                    System.out.println("Solution is not an integer: " + sol);
            }
        }
        assert solSet.size() <= 2;  // make sure the no. of solutions is normal.
        solSet.forEach(x -> {assert Math.abs(a*x*x+b*x+c) < 0.0001;}); // correctness of solutions.
        return solSet;
    }

    
    /**
     * Main function of program.
     * @param args command-line arguments
     */
    public static void main(String[] args) {
        System.out.println("For the equation x^2 - 4x + 3 = 0, the possible solutions are:");
        Set<Integer> result = roots(1, -4, 3);
        System.out.println(result);
    }

    /* Copyright (c) 2016 MIT 6.005 course staff, all rights reserved.
     * Redistribution of original or derived work requires explicit permission.
     * Don't post any of this code on the web or to a public Github repository.
     */
}
