/*
 * Given a non-negative number represented as an array of digits,
 * add 1 to the number ( increment the number represented by the digits ).
 * The digits are stored such that the most significant digit is at the head
 * of the list.
 *
 * Example:
 *
 * If the vector has [1, 2, 3]
 * the returned vector should be [1, 2, 4]
 * as 123 + 1 = 124.
 *
 * NOTE: Certain things are intentionally left unclear in this question
 * which you should practice asking the interviewer.
 *
 * For example, for this problem, following are some good questions to ask :
 * Q : Can the input have 0's before the most significant digit. Or in other
 * words, is 0 1 2 3 a valid input?
 * A : For the purpose of this question, YES
 * Q : Can the output have 0's before the most significant digit? Or in other
 * words, is 0 1 2 4 a valid output?
 * A : For the purpose of this question, NO. Even if the input has zeroes before
 * the most significant digit.
 */

import java.util.ArrayList;

public class Plus1 {
	public ArrayList<Integer> plusOne(ArrayList<Integer> a) {

	  // test cases:
	  // 08 -> 8
	  // 0809 -> 809
	  // 06064881 -> 6064881

	  // clean data of leading zeroes

	  // remove zeroes, starting from front and dont remove the last element
	  // once encounter non-zero element, should stop
	  int k = 0;
	  while (k < a.size() - 1) {
	    if (a.get(k) == 0) {
	      a.remove(k);
	    }
	    else {
	      break;
	    }
	    // don't increment because either removed element or exited from loop
	    // if incremented, would skip next element which has been moved to kth position
	  }

	  // test cases:
	  // 88 -> 89
	  // 89 -> 90
	  // 90 -> 91
	  // 199 -> 200
	  // 99 -> 100

	  // loop through digits
	  // if first digit is [0-8], add current digit plus 1 to new arraylist
	  // if first digit is 9, add zero to new arraylist, and add 1 to next column

	  // we need to keep track of the carry, so just make carry 0 or 1

	  ArrayList<Integer> b = new ArrayList<Integer>();

	  // most significant digit is stored first
	  // so check last digit (aka ones column)
	  int last = a.size() - 1;

	  // add digits to front of arraylist
	  int front = 0;

	  // check digit in ones column, add one and set carry
	  int onesDigit = a.get(last);
	  int carry;
	  if (onesDigit < 9) {
	    b.add(front, ++onesDigit);
	    carry = 0;
	  } else {
	    b.add(front, 0); // digit is 9, so ones column set to zero and carry the one
	    carry = 1;
	  }

	  // loop through remaining digits backwards (from least significant to most)
	  for (int i = last - 1; i >= 0; i--) {
	    int digit = a.get(i);
	    if (digit + carry <= 9) {
	      b.add(front, digit + carry); // add
	      carry = 0;
	    } else {
	      b.add(front, 0);
	      carry = 1;
	    }
	  }

	  // if loop ends and still need to add a carry
	  if (carry == 1) {
	    b.add(front, carry);
	  }

	  // could insert each new element at beginning of list
	  return b;

	  // or reverse at the very end
	  /*
      ArrayList<Integer> c = new ArrayList<Integer>();
	  for (int j = b.size() - 1; j >= 0; j--) {
	    c.add(b.get(j));
	  }
	  return c;
      */



	  /* integer can only hold 2^16-1 digits */
	  /*
	  // convert arraylist of numbers to string
	  String numStr = "";
	  for (int i = 0; i < a.size(); i++) {
	    numStr+=a.get(i);
	  }

	  // convert string to int and increment
	  int numInt = Integer.parseInt(numStr);
	  numInt++;

	  // convert into to string and then to character array
	  String numPlusOneStr = Integer.toString(numInt);
	  char[] numPlusOneChars = numPlusOneStr.toCharArray();

	  // create new arraylist and add each char to it
	  ArrayList<Integer> b = new ArrayList<Integer>();
	  for (int j = 0; j < numPlusOneChars.length; j++) {
	    b.add(j, Character.getNumericValue(numPlusOneChars[j]));
	  }

	  // return new arraylist
	  return b;
	  */
	}

    public static void testSuite() {
      test("2 8 8");
      test("2 8 9");
      test("2 9 0");
      test("2 9 9");
    }

    public static void test(String input) {
      Plus1 p = new Plus1();

      // convert input
      ArrayList<Integer> ints = convertInput(input);

      // print input
      print(ints);

      // modify
      ArrayList<Integer> plussed = p.plusOne(ints);

      // print output
      print(plussed);
    }

    /* where input is list of numbers
     * and first number is size of arraylist
     * and remaining numbers are the elements
     * (separated by a space)
     */
    public static ArrayList<Integer> convertInput(String input) {
      String[] strArr = input.split(" ");
      ArrayList<Integer> ints = new ArrayList<Integer>();
      for (int i = 1; i < strArr.length; i++) {
        ints.add(Integer.parseInt(strArr[i]));
      }
      return ints;
    }

    public static void print(ArrayList<Integer> ints) {
      for (Integer i : ints) {
        System.out.print(i + "");
      }
      System.out.println();
    }

    public static void main(String[] args) {
      testSuite();
    }
}
