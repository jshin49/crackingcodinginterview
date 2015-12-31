/*
 * Given numRows, generate the first numRows of Pascal's triangle.
 *
 * Pascal's triangle : To generate A[C] in row R, 
 * sum up A'[C] and A'[C-1] from previous row R - 1.
 *
 * Example:
 *
 * Given numRows = 5,
 *
 * Return
 *
 * [
 *  [1],
 *  [1,1],
 *  [1,2,1],
 *  [1,3,3,1],
 *  [1,4,6,4,1]
 * ]
 *
 */

import java.util.ArrayList;

public class Pascal1 {
	public ArrayList<ArrayList<Integer>> generate(int a) {
        ArrayList<ArrayList<Integer>> lists = new ArrayList<ArrayList<Integer>>();
    
        int index = a - 1;
        
        // no rows
        if (index < 0) {
            return lists;
        }

        // create first case
        ArrayList<Integer> one = new ArrayList<Integer>();
        one.add(1);
        lists.add(one);

        // if first return
        if (index == 0) {
            return lists;
        }

        // create second case
        ArrayList<Integer> two = new ArrayList<Integer>();
        two.add(1);
        two.add(1);
        lists.add(two);

        // if second return
        if (index == 1) {
            return lists;
        }

        // subsequent cases
        for (int row = 2; row <= index; row++) {
            ArrayList<Integer> list = new ArrayList<Integer>();
            list.add(1);
            for (int i = 1; i < row; i++) {
                list.add(lists.get(row - 1).get(i) + lists.get(row - 1).get(i - 1));
            }
            list.add(1);
            lists.add(list);
        }
	    return lists;
    }

    public static void testSuite() {
      test("0");
      test("1");
      test("2");
      test("3");
      test("4");
      test("5");
      test("6");
    }

    public static void test(String input) {
      Pascal1 p = new Pascal1();
      // convert input
      int num = convertInput(input);
      // print input
      printInput(num);
      // modify
      ArrayList<ArrayList<Integer>> rows = p.generate(num);
      // print output
      printOutput(rows);
    }

    /* where input is a single integer
     */
    public static int convertInput(String input) {
        return Integer.parseInt(input);
    }

    public static void printInput(int num) {
      System.out.println(num);
    }

    public static void printOutput(ArrayList<ArrayList<Integer>> lists) {
      for (ArrayList<Integer> list : lists) {
        printArrayList(list);
      }
      System.out.println();
    }

    public static void printArrayList(ArrayList<Integer> ints) {
        for (Integer i : ints) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
      testSuite();
    }
}
