package com.codecool.train.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TrainWagonDto {
    private String trainId;
    private String wagonId;
}
