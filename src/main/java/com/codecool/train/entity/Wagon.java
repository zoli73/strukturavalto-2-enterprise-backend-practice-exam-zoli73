package com.codecool.train.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Entity
public class Wagon {
    @Id
    private String id;
    private Integer weight;
    @Enumerated(EnumType.STRING)
    private WagonType wagonType;

    @ManyToOne
    @JoinColumn(name = "train_id")
    @JsonIgnore
    private Train train;
}
