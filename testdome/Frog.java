/*
 * A frog only moves forward, but it can move in steps 1 inch long or in jumps 
 * 2 inches long. A frog can cover the same distance using different 
 * combinations of steps and jumps.
 *
 * Write a function that calculates the number of different combinations a 
 * frog can use to cover a given distance.
 *
 * For example, a distance of 3 inches can be covered in three ways: 
 * step-step-step, step-jump, and jump-step.
 *
 */

public class Frog {
    
    
    public static int numberOfWays(int n) {
        
        int[] lookup;
        
        // step = 1 inch
        // jump = 2 inches

        // dynamic programming approach, memoization (store expensive results)
        if (lookup == null) {
            lookup = new int[n];
        }

        // naive solution, recalculates numbers with recursive calls
        /*
        if (n == 1) {
            // step
            return 1;
        }
        else if (n == 2) {
            // step-step, jump
            return 2;
        }
        else {
            
            // http://stackoverflow.com/questions/32202911/all-combinations-of-1-2-that-adds-to-n
            return numberOfWays(n - 1) + numberOfWays(n - 2);   
            
            // if 3 inches
            // nOW(3 - 1) + nOW(3 - 2)
            // = nOW(2) + nOW(1)
            // = 2 + 1
            // = 3
            
            // if 4 inches
            // nOW(4 - 1) + nOW(4 - 2)
            // = nOW(3) + nOW(2)
            // = nOW(3 - 1) + nOW(3 - 2) + 2
            // = nOW(2) + nOW(1) + 2
            // = 2 + 1 + 2
            // = 5
        }
        */
    }

    public static void main(String[] args) {
        
        // 1 inch
        // should be 1 way
        // step
        System.out.println(numberOfWays(1));

        // 2 inches
        // should be 2 ways
        // step-step, jump
        System.out.println(numberOfWays(2));
        
        // 3 inches
        // should be 3 ways
        // step-step-step, step-jump, jump-step
        System.out.println(numberOfWays(3));
       
        // 4 inches
        // should be 5 ways
        // step-step-step-step, step-step-jump, step-jump-step, jump-step-step,
        // jump-jump
        System.out.println(numberOfWays(4));

        // 5 inches
        // should be 8 ways
        // step-step-step-step-step, step-jump-jump, jump-step-jump,
        // jump-jump-step, step-step-step-jump, step-step-jump-step,
        // step-jump-step-step, jump-step-step-step
        System.out.println(numberOfWays(5));
    }
}
