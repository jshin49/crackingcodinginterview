/*
 * Write a function that, given a list and a target sum, returns zero-based 
 * indices of any two distinct elements whose sum is equal to the target sum. 
 * If there are no such elements, the function should return null.
 *
 * For example, findTwoSum(new int[] { 1, 3, 5, 7, 9 }, 12) should return any 
 * of the following tuples of indices:
 *
 * 1, 4 (3 + 9 = 12)
 * 2, 3 (5 + 7 = 12)
 * 3, 2 (7 + 5 = 12)
 * 4, 1 (9 + 3 = 12)
 */

public class TwoSum {
    public static int[] findTwoSum(int[] list, int sum) {

        // http://stackoverflow.com/questions/23460367/comparing-elements-of-the-same-array-in-java<F37>
        for (int x = 0; x < list.length; x++) {
            for (int y = x + 1; y < list.length; y++) {
                if (list[x] + list[y] == sum) {
                    return new int[] { x, y };
                }
            }
        }

        // brute force solution, time limit exceeded for tests
        /* 
        for (int i = 0; i < list.length; i++) {
            for (int j = 0; j < list.length; j++) {
                if ( i != j) {
                    if ( list[i] + list[j] == sum) {
                        return new int[] { i, j };
                    }
                }
            }
        }
        */
        
        return null;
    }

    public static void main(String[] args) {
        
        int[] indices = findTwoSum(new int[] { 1, 3, 5, 7, 9 }, 12);
        System.out.println(indices[0] + " " + indices[1]);
        
    }
}

/*
 * Example case: java.lang.UnsupportedOperationException at TwoSum.findTwoSum(TwoSum.java:3)
 * No solution: java.lang.UnsupportedOperationException at TwoSum.findTwoSum(TwoSum.java:3)
 * One solution: java.lang.UnsupportedOperationException at TwoSum.findTwoSum(TwoSum.java:3)
 * Performance test with a large number of elements: java.lang.UnsupportedOperationException at TwoSum.findTwoSum(TwoSum.java:3)
 */
