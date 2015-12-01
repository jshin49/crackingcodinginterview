class MultiplicationTable {
  
  public static void multiplyRow(int num, int start, int end) {
    for (int i = start; i <= end; i++) {
      System.out.print(num * i + " ");
    }
    System.out.println("");
  }

  public static void multiplyTable(int n) {
    for (int i = 1; i <= n; i++) {
      multiplyRow(i, 1, n);
    }
  }

  public static void main(String[] args) {
    multiplyTable(12);
  }
}
