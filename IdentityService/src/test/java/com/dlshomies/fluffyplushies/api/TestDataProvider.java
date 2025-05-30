package com.dlshomies.fluffyplushies.api;

import com.dlshomies.fluffyplushies.dto.rest.CreateUserRequest;
import org.junit.jupiter.params.provider.Arguments;

import java.util.function.Consumer;
import java.util.stream.Stream;

public class TestDataProvider {

    public static Stream<String> invalidEmailAddresses() {
        return Stream.of(INVALID_EMAIL_TEST_CASES);
    }

    public static Stream<String> validEmailAddresses() {
        return Stream.of(VALID_EMAIL_TEST_CASES);
    }

    public static Stream<String> invalidPasswords() {
        return Stream.of(INVALID_PASSWORD_TEST_CASES);
    }

    private static final String[] INVALID_EMAIL_TEST_CASES = {
            "plainaddress",
            "@noLocalPart.com",
            "Outlook Contact <outlook-contact@domain.com>",
            "no-at.domain.com",
            ";beginning-semicolon@domain.co.uk",
            "middle-semicolon@domain.co;uk",
            "trailing-semicolon@domain.com;",
            "\"email+leading-quotes@domain.com",
            "email+middle\"-quotes@domain.com",
            "lots-of-dots@domain..com",
            "two-dots..in-local@domain.com",
            "multiple@domains@domain.com",
            "spaces in local@domain.com",
            "spaces-in-domain@dom ain.com",
            "comma,in-local@domain.com",
            "comma-in-domain@domain,com",
            "pound-sign-in-local#domain.com",
            "missing-username@.com",
            "missing-domain@domain.",
            "missing-at-sign.com",
            "missing-local-and-at@.com",
            "invalid@domain,com",
            "invalid@domain..com",
            "invalid@-domain.com",
            "invalid@domain-.com",
            "invalid@.domain.com"
    };

    private static final String[] VALID_EMAIL_TEST_CASES = {
            "janedoe@example.com",                      // Basic ascii lowercase
            "JANEDOE@EXAMPLE.COM",                      // Basic ascii uppercase
            "mixedCASE@DOMAin.coM",                     // Basic ascii mixed case
            "very.common@example.com",                  // Local part with period
            "Jane!Doe@example.org",                     // Local part with exclamation mark
            "Jane#Doe@example.org",                     // Local part with hash
            "Jane$Doe@example.org",                     // Local part with dollar sign
            "Jane%Doe@example.org",                     // Local part with percent sign
            "Jane&Doe@example.org",                     // Local part with ampersand
            "Jane'Doe@example.org",                     // Local part with single quote
            "Jane*Doe@example.org",                     // Local part with star
            "Jane/Doe@example.org",                     // Local part with forward slash
            "Jane=Doe@example.org",                     // Local part with equals
            "Jane?Doe@example.org",                     // Local part with question mark
            "Jane^Doe@example.org",                     // Local part with up arrow
            "Jane_Doe@example.org",                     // Local part with underscore
            "Jane-Doe@example.org",                     // Local part with dash
            "Jane`Doe@example.org",                     // Local part with back tick
            "Jane{}Doe@example.org",                    // Local part with curly braces
            "Jane|Doe@example.org",                     // Local part with pipe
            "Jane~Doe@example.org",                     // Local part with tilda
            "Jane+Jill@example.co.uk",                  // Local part with plus
            "kittycat@sub-domain.co.uk",                // Domain with hyphen
            "doge@Domain456.net",                       // Domain with numbers
            "username@domain_name.com",                 // Domain with underscore
            "user@[127.0.0.1]",                         // IPv4 literal domain
            "user@[IPv6:2001:db8:85a3::8a2e:370:7334]", // IPv6 literal domain
    };

    private static final String [] INVALID_PASSWORD_TEST_CASES = {
            "alllowercase1!",      // missing uppercase
            "ALLUPPERCASE1!",      // missing lowercase
            "MixedCaseNoDigit!",   // missing digit
            "MixedCase1NoSpecial", // missing special character
            "TooShort1!",          // too short (11 chars)
            "tooLONGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGG1!",
            "Has White1!",         // contains whitespace
            ""                     // empty
    };

    public static Stream<Arguments> nullAndEmptyFieldProvider() {
        return Stream.of(
                // For username
                Arguments.of((Consumer<CreateUserRequest.CreateUserRequestBuilder<?, ?>>) b -> b.username(null), "username"),
                Arguments.of((Consumer<CreateUserRequest.CreateUserRequestBuilder<?, ?>>) b -> b.username(""), "username"),
                // For email
                Arguments.of((Consumer<CreateUserRequest.CreateUserRequestBuilder<?, ?>>) b -> b.email(null), "email"),
                Arguments.of((Consumer<CreateUserRequest.CreateUserRequestBuilder<?, ?>>) b -> b.email(""), "email"),
                // For phone
                Arguments.of((Consumer<CreateUserRequest.CreateUserRequestBuilder<?, ?>>) b -> b.phone(null), "phone"),
                Arguments.of((Consumer<CreateUserRequest.CreateUserRequestBuilder<?, ?>>) b -> b.phone(""), "phone"),
                // For password
                Arguments.of((Consumer<CreateUserRequest.CreateUserRequestBuilder<?, ?>>) b -> b.password(null), "password"),
                Arguments.of((Consumer<CreateUserRequest.CreateUserRequestBuilder<?, ?>>) b -> b.password(""), "password"),
                // For address
                Arguments.of((Consumer<CreateUserRequest.CreateUserRequestBuilder<?, ?>>) b -> b.address(null), "address")
        );
    }
}