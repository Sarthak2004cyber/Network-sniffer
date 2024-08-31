import java.util.Scanner;
import java.util.regex.Pattern;

public class PasswordStrengthChecker {

    public static String checkPasswordStrength(String password) {
        int strengthScore = 0;

        // Check length
        if (password.length() >= 8) {
            strengthScore++;
        }

        // Check for uppercase letters
        if (Pattern.compile("[A-Z]").matcher(password).find()) {
            strengthScore++;
        }

        // Check for lowercase letters
        if (Pattern.compile("[a-z]").matcher(password).find()) {
            strengthScore++;
        }

        // Check for digits
        if (Pattern.compile("[0-9]").matcher(password).find()) {
            strengthScore++;
        }

        // Check for special characters
        if (Pattern.compile("[^a-zA-Z0-9]").matcher(password).find()) {
            strengthScore++;
        }

        // Determine strength based on score
        switch (strengthScore) {
            case 5:
                return "Very Strong";
            case 4:
                return "Strong";
            case 3:
                return "Moderate";
            case 2:
                return "Weak";
            default:
                return "Very Weak";
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a password to check its strength: ");
        String password = scanner.nextLine();

        String strength = checkPasswordStrength(password);
        System.out.println("Password Strength: " + strength);
    }
}