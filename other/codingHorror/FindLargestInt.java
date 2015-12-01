class FindLargestInt {

  public static int largestValue(int[] ints) {
    int largest = Integer.MIN_VALUE;
      for (int i = 0; i < ints.length; i++) {
        if (ints[i] > largest) {
          largest = ints[i];
        }
      }
    return largest;
  }

  public static void main(String[] args) {
    int[] integers = { 1,2,3,4,5,6 };
    System.out.println(largestValue(integers));
  }

}
