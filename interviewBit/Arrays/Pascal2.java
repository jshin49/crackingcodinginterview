/*
 * Given an index k, return the kth row of the Pascal's triangle.
 *
 * Pascal's triangle : To generate A[C] in row R, 
 * sum up A'[C] and A'[C-1] from previous row R - 1.
 *
 * Example:
 * Input : k = 3
 * Return : [1,3,3,1]
 *
 * NOTE : k is 0 based. k = 0, corresponds to the row [1]. 
 *
 * Note:Could you optimize your algorithm to use only O(k) extra space?
 */

import java.util.ArrayList;

public class Pascal2 {
	public ArrayList<Integer> getRow(int index) {
        ArrayList<ArrayList<Integer>> lists = new ArrayList<ArrayList<Integer>>();
        
        // create first case
        ArrayList<Integer> one = new ArrayList<Integer>();
        one.add(1);
        lists.add(one);

        // create second case
        ArrayList<Integer> two = new ArrayList<Integer>();
        two.add(1);
        two.add(1);
        lists.add(two);

        // return if first or second
        if (index < 2) {
            return lists.get(index);
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
        return lists.get(index);
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
      Pascal2 p = new Pascal2();
      // convert input
      int num = convertInput(input);
      // print input
      printInput(num);
      // modify
      ArrayList<Integer> row = p.getRow(num);
      // print output
      printOutput(row);
    }

    /* where input is a single integer
     */
    public static int convertInput(String input) {
        return Integer.parseInt(input);
    }

    public static void printInput(int num) {
      System.out.println(num);
    }

    public static void printOutput(ArrayList<Integer> ints) {
      for (Integer i : ints) {
        System.out.print(i + " ");
      }
      System.out.println();
    }

    public static void main(String[] args) {
      testSuite();
    }
}
