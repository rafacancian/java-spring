package springdata.college.adapters;

import springdata.college.dtos.PhoneDTO;
import springdata.college.entities.Phone;

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
