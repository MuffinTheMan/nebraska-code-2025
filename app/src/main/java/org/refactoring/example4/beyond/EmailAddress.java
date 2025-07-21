package org.refactoring.example4.beyond;

public record EmailAddress(String fullEmail) {
    public EmailAddress(String fullEmail) {
        this.fullEmail = fullEmail == null ? null : fullEmail.trim();
        if (this.fullEmail == null || !this.fullEmail.matches("^[\\w.%+-]+@[\\w.-]+\\.[a-zA-Z]{2,}$")) {
            throw new IllegalArgumentException("Invalid email");
        }
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
}
