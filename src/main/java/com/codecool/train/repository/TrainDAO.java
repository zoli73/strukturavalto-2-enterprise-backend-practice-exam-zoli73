package com.codecool.train.repository;

import com.codecool.train.entity.Train;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrainDAO extends JpaRepository<Train, String> {
}
