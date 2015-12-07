public class Run {
    public static int indexOfLongestRun(String str) {
        
        // run is a consecutive sequence of same character
        // if more than one run with same length, return index of first one

        char[] chars = str.toCharArray();
        
        int longestRun = -1;
        int indexOf = -1;
        
        char previousChar = '\0';
        int currentRun = -1;
        int currentRunIndexOf = -1;

        for (int i = 0; i < chars.length; i++) {
            
            if (previousChar != chars[i]) {
                previousChar = chars[i];
                currentRun = 1;
                currentRunIndexOf = i;
            }
            else {
                currentRun++;
            }

            if (currentRun > longestRun) {
                longestRun = currentRun;
                indexOf = currentRunIndexOf;
            }
        }

        return indexOf;
    }

    public static void main(String[] args) {
        System.out.println(indexOfLongestRun("a"));
        System.out.println(indexOfLongestRun("ab"));
        System.out.println(indexOfLongestRun("aab"));
        System.out.println(indexOfLongestRun("abbcccddddcccbba"));
    }
}
