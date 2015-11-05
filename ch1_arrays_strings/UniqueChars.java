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
        ArrayList<Character> uniqueCharacters = new ArrayList<Character>();
        for (Character c: characters.toCharArray()) {
            for (Character u: uniqueCharacters) {
                if (c == u) {
                    return false;
                }
            }
            uniqueCharacters.add(c);
        }
        return true;
    }


}
