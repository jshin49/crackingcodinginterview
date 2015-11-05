class Michael {
    public static void main(String[] args) {
        Michael.fizzBuzz(100);
    }
    public static void fizzBuzz(int n) {
        for (int i = 0; i <= n; i++) {
            if (i % 3 != 0 && i % 5 != 0) {
                System.out.print(i);
            }
            if (i % 3 == 0) {
                System.out.print("Fizz");
            }
            if (i % 5 == 0) {
                System.out.print("Buzz");
            }
            System.out.println("");
        }
    }
}
