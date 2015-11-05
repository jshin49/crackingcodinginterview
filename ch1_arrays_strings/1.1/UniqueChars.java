import java.util.HashSet;
import java.util.ArrayList;

class UniqueChars {
    public static void main(String[] args) {
        UniqueChars u = new UniqueChars();
        System.out.println(u.uniqueChars("abcfdef"));
        System.out.println(u.uniqueCharsNoDS("abcfdef"));
    }

    // use set to identify duplicates
    // java set is abstract, can use hashset
    // if add returns false, then not added because duplicate exists
    public boolean uniqueChars(String characters) {
        HashSet<Character> uniqueCharacters = new HashSet<Character>();
        for (int i = 0; i < characters.length(); i++) {
            if (!uniqueCharacters.add(characters.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    // no additional data structures
    // brute force -> store characters in arraylist, look up if previously
    // exists
    public boolean uniqueCharsNoDS(String characters) {
        //ArrayList<Character> uniqueCharacters = new ArrayList<Character>();
        for (Character c: characters.toCharArray()) {
            for (Character c2: characters.toCharArray()) {
            //for (Character c2: uniqueCharacters) {
                if (c == c2) {
                    return false;
                }
            }
            //uniqueCharacters.add(c);
        }
        return true;
    }

    // solution
    
    // is string ASCII or Unicode?
    // ASCII is 128 characters
    // if length of string greater than 128 characters, then return false
    // because there is at least one duplicate
    
    // can just boolean array with char as index

    public boolean isUniqueChars(String str) {
        if (str.length() > 128) return false;

        boolean[] char_set = new boolean[128];
        for (int i = 0; i < str.length(); i++) {
            int val = str.charAt(i);
            if (char_set[val]) {
                return false;
            }
            char_set[val] = true;
        }
        return true;
    }
}
