package org.refactoring.example4.beyond;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

class EmailAddressUnitTest {
    @Test
    void constructor() {
        assertAll(
            () -> assertThatThrownBy(() -> new EmailAddress(null)).isInstanceOf(IllegalArgumentException.class),
            () -> assertThatThrownBy(() -> new EmailAddress("")).isInstanceOf(IllegalArgumentException.class),
            () -> assertThatThrownBy(() -> new EmailAddress("bademail")).isInstanceOf(IllegalArgumentException.class),
            () -> assertThatThrownBy(() -> new EmailAddress("@")).isInstanceOf(IllegalArgumentException.class),
            () -> assertThatThrownBy(() -> new EmailAddress("@hi.com")).isInstanceOf(IllegalArgumentException.class),
            () -> assertThatThrownBy(() -> new EmailAddress("a@gmail")).isInstanceOf(IllegalArgumentException.class),
            () -> assertThat(new EmailAddress("me@gmail.com").fullEmail()).isEqualTo("me@gmail.com"),
            () -> assertThat(new EmailAddress("me@gmail.org").fullEmail()).isEqualTo("me@gmail.org"),
            () -> assertThat(new EmailAddress("me@gmail.net").fullEmail()).isEqualTo("me@gmail.net"),
            () -> assertThat(new EmailAddress("me@gmail.dev").fullEmail()).isEqualTo("me@gmail.dev"),
            () -> assertThat(new EmailAddress("a+b@gmail.dev").fullEmail()).isEqualTo("a+b@gmail.dev"),
            () -> assertThat(new EmailAddress("a+b@gmail.dev ").fullEmail()).isEqualTo("a+b@gmail.dev"),
            () -> assertThat(new EmailAddress(" a+b@gmail.dev").fullEmail()).isEqualTo("a+b@gmail.dev"),
            () -> assertThat(new EmailAddress(" a+b@gmail.dev ").fullEmail()).isEqualTo("a+b@gmail.dev")
        );
    }

    @Test
    void getDomain() {
        assertAll(
            () -> assertThatThrownBy(() -> new EmailAddress(null)).isInstanceOf(IllegalArgumentException.class),
            () -> assertThatThrownBy(() -> new EmailAddress("")).isInstanceOf(IllegalArgumentException.class),
            () -> assertThatThrownBy(() -> new EmailAddress("  ")).isInstanceOf(IllegalArgumentException.class),
            () -> assertThatThrownBy(() -> new EmailAddress("invalid")).isInstanceOf(IllegalArgumentException.class),
            () -> assertThatThrownBy(() -> new EmailAddress("invalid.com")).isInstanceOf(IllegalArgumentException.class),
            () -> assertThat(new EmailAddress("howdy@gmail.com").getDomain()).isEqualTo("gmail.com"),
            () -> assertThat(new EmailAddress("me@yahoo.com").getDomain()).isEqualTo("yahoo.com"),
            () -> assertThat(new EmailAddress("you@hotmail.com").getDomain()).isEqualTo("hotmail.com"),
            () -> assertThat(new EmailAddress("jeff@yourcompany.com").getDomain()).isEqualTo("yourcompany.com")
        );
    }

    @Test
    void getLocalPart() {
        assertAll(
            () -> assertThatThrownBy(() -> new EmailAddress(null)).isInstanceOf(IllegalArgumentException.class),
            () -> assertThatThrownBy(() -> new EmailAddress("")).isInstanceOf(IllegalArgumentException.class),
            () -> assertThatThrownBy(() -> new EmailAddress("  ")).isInstanceOf(IllegalArgumentException.class),
            () -> assertThatThrownBy(() -> new EmailAddress("invalid")).isInstanceOf(IllegalArgumentException.class),
            () -> assertThatThrownBy(() -> new EmailAddress("invalid.com")).isInstanceOf(IllegalArgumentException.class),
            () -> assertThat(new EmailAddress("howdy@gmail.com").getLocalPart()).isEqualTo("howdy"),
            () -> assertThat(new EmailAddress("me@yahoo.com").getLocalPart()).isEqualTo("me"),
            () -> assertThat(new EmailAddress("jeff@yourcompany.com").getLocalPart()).isEqualTo("jeff"),
            () -> assertThat(new EmailAddress("you@hotmail.com").getLocalPart()).isEqualTo("you")
        );
    }

    @Test
    void isCorporateEmail() {
        assertAll(
            () -> assertThatThrownBy(() -> new EmailAddress(null)).isInstanceOf(IllegalArgumentException.class),
            () -> assertThatThrownBy(() -> new EmailAddress("")).isInstanceOf(IllegalArgumentException.class),
            () -> assertThatThrownBy(() -> new EmailAddress("  ")).isInstanceOf(IllegalArgumentException.class),
            () -> assertThatThrownBy(() -> new EmailAddress("invalid")).isInstanceOf(IllegalArgumentException.class),
            () -> assertThatThrownBy(() -> new EmailAddress("invalid.com")).isInstanceOf(IllegalArgumentException.class),
            () -> assertThat(new EmailAddress("me@gmail.com").isCorporateEmail()).isFalse(),
            () -> assertThat(new EmailAddress("you@hotmail.com").isCorporateEmail()).isFalse(),
            () -> assertThat(new EmailAddress("jeff@notyourcompany.com").isCorporateEmail()).isFalse(),
            () -> assertThat(new EmailAddress("jeff@yourcompany.com").isCorporateEmail()).isTrue(),
            () -> assertThat(new EmailAddress("jeff@youRcoMpanY.com").isCorporateEmail()).isTrue(),
            () -> assertThat(new EmailAddress("you@yourcompany.com").isCorporateEmail()).isTrue()
        );
    }
}