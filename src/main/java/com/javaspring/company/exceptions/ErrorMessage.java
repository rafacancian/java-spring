package com.javaspring.company.exceptions;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class ErrorMessage {

    private String type;
    private String message;

    @Override
    public String toString() {
        return type + " : " + message;
    }
}
