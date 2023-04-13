package com.codecool.train.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Train train = (Train) o;
        return Objects.equals(id, train.id) && Objects.equals(driver, train.driver) && Objects.equals(destination, train.destination) && Objects.equals(isLate, train.isLate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, driver, destination, isLate);
    }
}
