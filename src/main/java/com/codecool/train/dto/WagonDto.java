package com.codecool.train.dto;

import com.codecool.train.entity.WagonType;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WagonDto {
    private String id;
    private Integer weight;
    private WagonType wagonType;
}
