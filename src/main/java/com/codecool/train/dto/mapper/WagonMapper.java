package com.codecool.train.dto.mapper;

import com.codecool.train.dto.WagonDto;
import com.codecool.train.entity.Wagon;

public class WagonMapper {
    public static Wagon dtoToWagon(WagonDto wagonDto) {
        return Wagon.builder()
                .id(wagonDto.getId())
                .weight(wagonDto.getWeight())
                .wagonType(wagonDto.getWagonType())
                .build();
    }
}
