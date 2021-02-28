package com.javaspring.college.validations;

import org.springframework.util.ObjectUtils;

public class EmailValidation {

    public static void execute(String email) {
        if (ObjectUtils.isEmpty(email) || !email.matches("^[a-zA-Z0-9._]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$")) {
            throw new IllegalArgumentException("Email invalid");
        }

    }
}
