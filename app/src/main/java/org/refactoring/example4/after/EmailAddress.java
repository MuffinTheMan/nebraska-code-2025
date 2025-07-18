package org.refactoring.example4.after;

public record EmailAddress(String fullEmail) {
    public boolean isValidEmail() {
        return fullEmail != null && fullEmail.matches("^[\\w.%+-]+@[\\w.-]+\\.[a-zA-Z]{2,}$");
    }

    public String getDomain() {
        if (fullEmail == null || !fullEmail.contains("@")) {
            throw new IllegalArgumentException("Invalid email");
        }
        return fullEmail.substring(fullEmail.indexOf('@') + 1);
    }

    public String getLocalPart() {
        if (fullEmail == null || !fullEmail.contains("@")) {
            throw new IllegalArgumentException("Invalid email");
        }
        return fullEmail.substring(0, fullEmail.indexOf('@'));
    }

    public boolean isCorporateEmail() {
        return getDomain().endsWith("yourcompany.com");
    }

    public String trim() {
        return fullEmail == null ? null : fullEmail.trim();
    }
}
