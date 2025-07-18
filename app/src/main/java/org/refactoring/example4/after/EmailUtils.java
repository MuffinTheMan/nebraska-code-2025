package org.refactoring.example4.after;

public class EmailUtils {
    public static boolean isValidEmail(String email) {
        return email != null && email.matches("^[\\w.%+-]+@[\\w.-]+\\.[a-zA-Z]{2,}$");
    }

    public static String getDomain(String email) {
        if (email == null || !email.contains("@")) {
            throw new IllegalArgumentException("Invalid email");
        }
        return email.substring(email.indexOf('@') + 1);
    }

    public static String getLocalPart(String email) {
        if (email == null || !email.contains("@")) {
            throw new IllegalArgumentException("Invalid email");
        }
        return email.substring(0, email.indexOf('@'));
    }

    public static boolean isCorporateEmail(String email) {
        return getDomain(email).endsWith("yourcompany.com");
    }

    public static String trim(String email) {
        return email == null ? null : email.trim();
    }
}
