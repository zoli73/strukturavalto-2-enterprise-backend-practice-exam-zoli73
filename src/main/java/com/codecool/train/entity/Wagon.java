package com.codecool.train.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Wagon {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
    private Integer weight;
    private WagonType wagonType;

    @ManyToOne
    @JoinColumn(name = "train_id")
    private Train train;
}
