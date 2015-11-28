public class Palindrome {
    public static boolean isPalindrome(String str) {
   
        // only order of English alphabet letters (A-Z and a-z) should
        // be considered, other characters should be ignored
        
        // http://docs.oracle.com/javase/7/docs/api/java/util/regex/Pattern.html#sum
        // replace all characters that are not a-z or A-Z with empty string
        String cleaned = str.replaceAll("[^a-zA-Z]", "");

        // convert to lower case to ignore case sensitivity
        String lowercase = cleaned.toLowerCase();
    
        // if length of string less than 2, return false
        if (lowercase.length() < 2) {
            return false;
        }

        // check pairs of start and end characters until reach middle
        for (int i = 0; i < lowercase.length() / 2; i++) {
            
            // if first character and last are not the same, then return false
            if (lowercase.charAt(i) != lowercase.charAt(lowercase.length() - 1 - i)) {
                return false;
            }
        }

        // if no problems, return true;
        return true; 
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("Noel sees Leon."));
    }
}
