class reverseString {

    public static String reverseString(String str) {
        char[] characters = str.toCharArray();
        for (int i = 0; i < characters.length / 2; i++) {
            char temp = characters[i];
            characters[i] = characters[characters.length - i - 1];
            characters[characters.length - i - 1] = temp;
        }
        return new String(characters);
    }

    public static void main(String[] args) {
        String original = new String("Original :");
        String reversed = " , Reversed: ";

        String test1 = "abc";
        String test2 = "abcdefghijklmnopqrstuvwxyz";

        System.out.println(original + test1 + reversed + reverseString(test1));
        System.out.println(original + test2 + reversed + reverseString(test2));
    }
}
