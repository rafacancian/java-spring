package com.javaspring.college.validations;

import org.springframework.util.ObjectUtils;

public class PhoneValidation {

    public static void execute(String ddd, String number) {

        if (ObjectUtils.isEmpty(ddd) || ObjectUtils.isEmpty(number)) {
            throw new IllegalArgumentException("DDD and number are require");
        }

        if (!ddd.matches("\\d{2}")) {
            throw new IllegalArgumentException("Invalid DDD");
        }

        if (!number.matches("\\d{8}|\\d{9}")) {
            throw new IllegalArgumentException("Invalid Number");
        }
    }
}
