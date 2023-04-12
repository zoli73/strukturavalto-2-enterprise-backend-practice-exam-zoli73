package com.codecool.train.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Train {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
    private String driver;
    private String destination;
    private Boolean isLate;

    @OneToMany(mappedBy = "train")
    private List<Wagon> wagons;
}
