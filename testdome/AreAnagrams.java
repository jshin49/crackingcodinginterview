public class AreAnagrams {
    public static boolean areAnagrams(String a, String b) {
        
        // if strings are not same length
        if (a.length() != b.length()) {
            return false;
        }

        // if sort strings then should be same
        return sortString(a).equals(sortString(b));
    }

    public static String sortString(String unsorted) {
        char[] chars = unsorted.toCharArray();
        java.util.Arrays.sort(chars);
        return new String(chars);
    }

    public static void main(String[] args) {
        System.out.println(areAnagrams("momdad", "dadmom"));
    }
}
