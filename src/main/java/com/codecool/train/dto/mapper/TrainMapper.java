package com.codecool.train.dto.mapper;

import com.codecool.train.dto.TrainDto;
import com.codecool.train.entity.Train;

public class TrainMapper {
    public static Train dtoToTrain(TrainDto trainDto) {
        return Train.builder()
                .id(trainDto.getId())
                .driver(trainDto.getDriver())
                .destination(trainDto.getDestination())
                .isLate(trainDto.getIsLate())
                .build();
    }
}
