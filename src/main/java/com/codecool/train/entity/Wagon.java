package com.codecool.train.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Wagon wagon = (Wagon) o;
        return Objects.equals(id, wagon.id) && Objects.equals(weight, wagon.weight) && wagonType == wagon.wagonType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, weight, wagonType);
    }
}
