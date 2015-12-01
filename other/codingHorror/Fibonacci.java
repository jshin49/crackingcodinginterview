class Fibonacci {
    public int fibonacci(int n) {
        if (n < 2) {
            return n;
        }
        else {
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }

    public int fibonacciDynamic(int n) {
        // store results in array
        int[] f = new int[n + 1 + 1]; 
        // n+1 because start with zero in zero indexed array
        // but java expects number of elements so another +1
        int i;

        // base case
        f[0] = 0;
        f[1] = 1;
        
        for (i = 2; i <= n; i++) {
            // compute fibonacci number
            f[i] = f[i - 1] + f[i - 2];
        }

        return f[n];
    }

    public static void main(String[] args) {
        Fibonacci f = new Fibonacci();
        int num = 0;
        int end = 42;
        while (num <= end) {
            //System.out.println(f.fibonacci(num));
            num++;
        }


        num = 0;
        while (num <= end) {
            //System.out.println(f.fibonacciDynamic(num));
            num++;
        }
        
    }
}
