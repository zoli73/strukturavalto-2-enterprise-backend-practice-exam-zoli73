package com.codecool.train.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TrainDto {
    private String id;
    private String driver;
    private String destination;
    private Boolean isLate;
}
