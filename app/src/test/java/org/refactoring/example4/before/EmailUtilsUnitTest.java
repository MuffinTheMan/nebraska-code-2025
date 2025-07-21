package org.refactoring.example4.before;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

class EmailUtilsUnitTest {

    @Test
    void isValidEmail() {
        assertAll(
            () -> assertThat(EmailUtils.isValidEmail(null)).isFalse(),
            () -> assertThat(EmailUtils.isValidEmail("")).isFalse(),
            () -> assertThat(EmailUtils.isValidEmail("bademail")).isFalse(),
            () -> assertThat(EmailUtils.isValidEmail("@")).isFalse(),
            () -> assertThat(EmailUtils.isValidEmail("@hi.com")).isFalse(),
            () -> assertThat(EmailUtils.isValidEmail("a@gmail")).isFalse(),
            () -> assertThat(EmailUtils.isValidEmail("me@gmail.com")).isTrue(),
            () -> assertThat(EmailUtils.isValidEmail("me@gmail.org")).isTrue(),
            () -> assertThat(EmailUtils.isValidEmail("me@gmail.net")).isTrue(),
            () -> assertThat(EmailUtils.isValidEmail("me@gmail.dev")).isTrue(),
            () -> assertThat(EmailUtils.isValidEmail("a+b@gmail.dev")).isTrue()
        );
    }

    @Test
    void getDomain() {
        assertAll(
            () -> assertThatThrownBy(() -> EmailUtils.getDomain(null)).isInstanceOf(IllegalArgumentException.class),
            () -> assertThatThrownBy(() -> EmailUtils.getDomain("")).isInstanceOf(IllegalArgumentException.class),
            () -> assertThatThrownBy(() -> EmailUtils.getDomain("  ")).isInstanceOf(IllegalArgumentException.class),
            () -> assertThatThrownBy(() -> EmailUtils.getDomain("invalid")).isInstanceOf(IllegalArgumentException.class),
            () -> assertThatThrownBy(() -> EmailUtils.getDomain("invalid.com")).isInstanceOf(IllegalArgumentException.class),
            () -> assertThat(EmailUtils.getDomain("howdy@gmail.com")).isEqualTo("gmail.com"),
            () -> assertThat(EmailUtils.getDomain("me@yahoo.com")).isEqualTo("yahoo.com"),
            () -> assertThat(EmailUtils.getDomain("you@hotmail.com")).isEqualTo("hotmail.com"),
            () -> assertThat(EmailUtils.getDomain("jeff@yourcompany.com")).isEqualTo("yourcompany.com")
        );
    }

    @Test
    void getLocalPart() {
        assertAll(
            () -> assertThatThrownBy(() -> EmailUtils.getLocalPart(null)).isInstanceOf(IllegalArgumentException.class),
            () -> assertThatThrownBy(() -> EmailUtils.getLocalPart("")).isInstanceOf(IllegalArgumentException.class),
            () -> assertThatThrownBy(() -> EmailUtils.getLocalPart("  ")).isInstanceOf(IllegalArgumentException.class),
            () -> assertThatThrownBy(() -> EmailUtils.getLocalPart("invalid")).isInstanceOf(IllegalArgumentException.class),
            () -> assertThatThrownBy(() -> EmailUtils.getLocalPart("invalid.com")).isInstanceOf(IllegalArgumentException.class),
            () -> assertThat(EmailUtils.getLocalPart("howdy@gmail.com")).isEqualTo("howdy"),
            () -> assertThat(EmailUtils.getLocalPart("me@yahoo.com")).isEqualTo("me"),
            () -> assertThat(EmailUtils.getLocalPart("jeff@yourcompany.com")).isEqualTo("jeff"),
            () -> assertThat(EmailUtils.getLocalPart("you@hotmail.com")).isEqualTo("you")
        );
    }

    @Test
    void isCorporateEmail() {
        assertAll(
            () -> assertThatThrownBy(() -> EmailUtils.isCorporateEmail(null)).isInstanceOf(IllegalArgumentException.class),
            () -> assertThatThrownBy(() -> EmailUtils.isCorporateEmail("")).isInstanceOf(IllegalArgumentException.class),
            () -> assertThatThrownBy(() -> EmailUtils.isCorporateEmail("  ")).isInstanceOf(IllegalArgumentException.class),
            () -> assertThatThrownBy(() -> EmailUtils.isCorporateEmail("invalid")).isInstanceOf(IllegalArgumentException.class),
            () -> assertThatThrownBy(() -> EmailUtils.isCorporateEmail("invalid.com")).isInstanceOf(IllegalArgumentException.class),
            () -> assertThat(EmailUtils.isCorporateEmail("me@gmail.com")).isFalse(),
            () -> assertThat(EmailUtils.isCorporateEmail("you@hotmail.com")).isFalse(),
            () -> assertThat(EmailUtils.isCorporateEmail("jeff@yourcompany.com")).isTrue(),
            () -> assertThat(EmailUtils.isCorporateEmail("you@yourcompany.com")).isTrue()
        );
    }

    @Test
    void trim() {
        assertAll(
            () -> assertThat(EmailUtils.trim(null)).isNull(),
            () -> assertThat(EmailUtils.trim("")).isEqualTo(""),
            () -> assertThat(EmailUtils.trim(" ")).isEqualTo(""),
            () -> assertThat(EmailUtils.trim("howdy")).isEqualTo("howdy"),
            () -> assertThat(EmailUtils.trim(" howdy@gmail.com ")).isEqualTo("howdy@gmail.com"),
            () -> assertThat(EmailUtils.trim(" howdy@gmail.com")).isEqualTo("howdy@gmail.com"),
            () -> assertThat(EmailUtils.trim("howdy@gmail.com ")).isEqualTo("howdy@gmail.com"),
            () -> assertThat(EmailUtils.trim("howdy@gmail.com")).isEqualTo("howdy@gmail.com")
        );
    }
}