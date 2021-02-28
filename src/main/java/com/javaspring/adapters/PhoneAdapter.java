package com.javaspring.adapters;

import com.javaspring.dtos.PhoneDTO;
import com.javaspring.entities.Phone;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PhoneAdapter {

    public static List<Phone> ToModel(List<PhoneDTO> phones) {
        List<Phone> result = new ArrayList<>();
        result.addAll(phones.stream()
                .map(e -> Phone.builder()
                        .ddd(e.getDdd())
                        .number(e.getNumber())
                        .build())
                .collect(Collectors.toList()));
        return result;

    }
}
