package org.refactoring.example4.after;

public class EmailUtils {
    public static boolean isValidEmail(String email) {
        return new EmailAddress(email).isValidEmail();
    }

    public static String getDomain(String email) {
        return new EmailAddress(email).getDomain();
    }

    public static String getLocalPart(String email) {
        return new EmailAddress(email).getLocalPart();
    }

    public static boolean isCorporateEmail(String email) {
        return new EmailAddress(email).isCorporateEmail();
    }

    public static String trim(String email) {
        return new EmailAddress(email).trim();
    }
}
