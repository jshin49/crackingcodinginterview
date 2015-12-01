class PrintOdds { 

  public static void printOddNumbers(int start, int end) {
    for (int i = start; i <= end; i++) {
      if (i % 2 != 0) {
        System.out.println(i);
      }
    }
  }

  public static void main(String[] args) {
    printOddNumbers(1, 99);
  }
}
