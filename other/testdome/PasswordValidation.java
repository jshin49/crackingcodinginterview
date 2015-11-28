import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * Implement strongPassword function which accepts a password and returns true
 * if password is strong and false if it's not.
 *
 * A password is strong if it satisfies the following rules:
 *
 * It is at least 12 characters long.
 * 
 * It contains at least one uppercase letter, at least one lowercase letter
 * and at least one digit.
 *
 * Letters should be split by digits into at least two groups (like
 * "Strong1Password").
 *
 * For example, "strong1password" is not a strong password because it does not
 * contain any uppercase letters.
 */

public class PasswordValidation {
    public static Boolean strongPassword(String password) {
        // if not enough characters, return false
        if (password.length() < 12) {
            return false;
        }
        // if no uppercase, return false
        if (!Pattern.compile("[A-Z]").matcher(password).find()) {
            return false;
        }
        // if no lowercase, return false
        if (!Pattern.compile("[a-z]").matcher(password).find()) {
            return false;
        }
        // if no digits, return false
        if (!Pattern.compile("[0-9]").matcher(password).find()) {
            return false;
        }
        // if not at least two groups, return false
        if (!Pattern.compile("[A-Za-z]+[0-9]+[A-Za-z]+").matcher(password).find()) {
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        
        // true
        System.out.println("true: " + strongPassword("Strong1Password"));
        
        // false, less than 12 chars
        System.out.println("false: " + strongPassword("s"));
        
        // false, no uppercase
        System.out.println("false: " + strongPassword("strong1password"));
        
        // false, no lowercase
        System.out.println("false: " + strongPassword("STRONG2PASSWORD"));
        
        // false, no digits
        System.out.println("false: "  + strongPassword("STRONGqPASSWORD"));

        // false, no groups
        System.out.println("false: " + strongPassword("strongPASSWORD2"));
    }
}
