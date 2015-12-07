class CountNumTwos {
    public static int countTwosInDigit(int digit) {
        if ( digit < 10 ) {
            if ( digit == 2) {
                return 1;
            }
            else {
                return 0;
            }
        }
        else {
            if ( digit % 10 == 2 ) {
                return 1 + countTwosInDigit(digit / 10);
            }
            else {
                return countTwosInDigit(digit / 10);
            }
        }
    }
    
    /* count number of twos from zero to n */
    public static int countTwos(int n) {
        int count = 0;
        int i = 0;
        while ( i <= n ) {
            count += countTwosInDigit(i);
            i++;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(countTwos(27));   
    }
}
