package com.codecool.train.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Train {
    @Id
    private String id;
    private String driver;
    private String destination;
    private Boolean isLate;

    @OneToMany(mappedBy = "train")
    private List<Wagon> wagons;
}
