package com.javaspring.college.validations;

import org.springframework.util.ObjectUtils;

public class CpfValidation {

    public static void execute(String number) {
        if (ObjectUtils.isEmpty(number) ||
                !number.matches("\\d{3}\\.\\d{3}\\.\\d{3}\\-\\d{2}")) {
            throw new IllegalArgumentException("Invalid CPF");
        }
    }
}

