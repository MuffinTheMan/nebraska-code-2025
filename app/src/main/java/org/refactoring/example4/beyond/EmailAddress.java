package org.refactoring.example4.beyond;

public record EmailAddress(String fullEmail) {
    public EmailAddress(String fullEmail) {
        this.fullEmail = fullEmail == null ? null : fullEmail.trim();
        if (this.fullEmail == null || !this.fullEmail.matches("^[\\w.%+-]+@[\\w.-]+\\.[a-zA-Z]{2,}$")) {
            throw new IllegalArgumentException("Invalid email");
        }
    }

    public String getDomain() {
        return fullEmail.substring(fullEmail.indexOf('@') + 1);
    }

    public String getLocalPart() {
        return fullEmail.substring(0, fullEmail.indexOf('@'));
    }

    public boolean isCorporateEmail() {
        return "yourcompany.com".equalsIgnoreCase(getDomain());
    }

    @Override
    public String toString() {
        return fullEmail;
    }
}
