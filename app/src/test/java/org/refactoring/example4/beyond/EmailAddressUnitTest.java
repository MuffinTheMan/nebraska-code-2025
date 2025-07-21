package org.refactoring.example4.beyond;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

class EmailAddressUnitTest {
    @Test
    void isValidEmail() {
        assertAll(
            () -> assertThat(new EmailAddress(null).isValidEmail()).isFalse(),
            () -> assertThat(new EmailAddress("").isValidEmail()).isFalse(),
            () -> assertThat(new EmailAddress("bademail").isValidEmail()).isFalse(),
            () -> assertThat(new EmailAddress("@").isValidEmail()).isFalse(),
            () -> assertThat(new EmailAddress("@hi.com").isValidEmail()).isFalse(),
            () -> assertThat(new EmailAddress("a@gmail").isValidEmail()).isFalse(),
            () -> assertThat(new EmailAddress("me@gmail.com").isValidEmail()).isTrue(),
            () -> assertThat(new EmailAddress("me@gmail.org").isValidEmail()).isTrue(),
            () -> assertThat(new EmailAddress("me@gmail.net").isValidEmail()).isTrue(),
            () -> assertThat(new EmailAddress("me@gmail.dev").isValidEmail()).isTrue(),
            () -> assertThat(new EmailAddress("a+b@gmail.dev").isValidEmail()).isTrue()
        );
    }

    @Test
    void getDomain() {
        assertAll(
            () -> assertThatThrownBy(() -> new EmailAddress(null).getDomain()).isInstanceOf(IllegalArgumentException.class),
            () -> assertThatThrownBy(() -> new EmailAddress("").getDomain()).isInstanceOf(IllegalArgumentException.class),
            () -> assertThatThrownBy(() -> new EmailAddress("  ").getDomain()).isInstanceOf(IllegalArgumentException.class),
            () -> assertThatThrownBy(() -> new EmailAddress("invalid").getDomain()).isInstanceOf(IllegalArgumentException.class),
            () -> assertThatThrownBy(() -> new EmailAddress("invalid.com").getDomain()).isInstanceOf(IllegalArgumentException.class),
            () -> assertThat(new EmailAddress("howdy@gmail.com").getDomain()).isEqualTo("gmail.com"),
            () -> assertThat(new EmailAddress("me@yahoo.com").getDomain()).isEqualTo("yahoo.com"),
            () -> assertThat(new EmailAddress("you@hotmail.com").getDomain()).isEqualTo("hotmail.com"),
            () -> assertThat(new EmailAddress("jeff@yourcompany.com").getDomain()).isEqualTo("yourcompany.com")
        );
    }

    @Test
    void getLocalPart() {
        assertAll(
            () -> assertThatThrownBy(() -> new EmailAddress(null).getLocalPart()).isInstanceOf(IllegalArgumentException.class),
            () -> assertThatThrownBy(() -> new EmailAddress("").getLocalPart()).isInstanceOf(IllegalArgumentException.class),
            () -> assertThatThrownBy(() -> new EmailAddress("  ").getLocalPart()).isInstanceOf(IllegalArgumentException.class),
            () -> assertThatThrownBy(() -> new EmailAddress("invalid").getLocalPart()).isInstanceOf(IllegalArgumentException.class),
            () -> assertThatThrownBy(() -> new EmailAddress("invalid.com").getLocalPart()).isInstanceOf(IllegalArgumentException.class),
            () -> assertThat(new EmailAddress("howdy@gmail.com").getLocalPart()).isEqualTo("howdy"),
            () -> assertThat(new EmailAddress("me@yahoo.com").getLocalPart()).isEqualTo("me"),
            () -> assertThat(new EmailAddress("jeff@yourcompany.com").getLocalPart()).isEqualTo("jeff"),
            () -> assertThat(new EmailAddress("you@hotmail.com").getLocalPart()).isEqualTo("you")
        );
    }

    @Test
    void isCorporateEmail() {
        assertAll(
            () -> assertThatThrownBy(() -> new EmailAddress(null).isCorporateEmail()).isInstanceOf(IllegalArgumentException.class),
            () -> assertThatThrownBy(() -> new EmailAddress("").isCorporateEmail()).isInstanceOf(IllegalArgumentException.class),
            () -> assertThatThrownBy(() -> new EmailAddress("  ").isCorporateEmail()).isInstanceOf(IllegalArgumentException.class),
            () -> assertThatThrownBy(() -> new EmailAddress("invalid").isCorporateEmail()).isInstanceOf(IllegalArgumentException.class),
            () -> assertThatThrownBy(() -> new EmailAddress("invalid.com").isCorporateEmail()).isInstanceOf(IllegalArgumentException.class),
            () -> assertThat(new EmailAddress("me@gmail.com").isCorporateEmail()).isFalse(),
            () -> assertThat(new EmailAddress("you@hotmail.com").isCorporateEmail()).isFalse(),
            () -> assertThat(new EmailAddress("jeff@yourcompany.com").isCorporateEmail()).isTrue(),
            () -> assertThat(new EmailAddress("you@yourcompany.com").isCorporateEmail()).isTrue()
        );
    }

    @Test
    void trim() {
        assertAll(
            () -> assertThat(new EmailAddress(null).trim()).isNull(),
            () -> assertThat(new EmailAddress("").trim()).isEqualTo(""),
            () -> assertThat(new EmailAddress(" ").trim()).isEqualTo(""),
            () -> assertThat(new EmailAddress("howdy").trim()).isEqualTo("howdy"),
            () -> assertThat(new EmailAddress(" howdy@gmail.com ").trim()).isEqualTo("howdy@gmail.com"),
            () -> assertThat(new EmailAddress(" howdy@gmail.com").trim()).isEqualTo("howdy@gmail.com"),
            () -> assertThat(new EmailAddress("howdy@gmail.com ").trim()).isEqualTo("howdy@gmail.com"),
            () -> assertThat(new EmailAddress("howdy@gmail.com").trim()).isEqualTo("howdy@gmail.com")
        );
    }
}