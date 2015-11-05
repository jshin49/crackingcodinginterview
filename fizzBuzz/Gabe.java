class Gabe {
    public static void main(String[] args) {
        Gabe.fizzBuzz(100);
    }
    public static void fizzBuzz(int n) {
        int count = 0;
        while (count <= n) {
            if (count % 3 == 0 || count % 5 == 0) {
                if (count % 3 == 0) {
                    System.out.print("fizz");
                }
                if(count % 5 == 0){
                    System.out.print("buzz");
                }
                System.out.print(" ");
            }
            else{
                System.out.print(count + " ");
            }
            count++;
        }
    }
}
