package com.codecool.train.repository;

import com.codecool.train.entity.Wagon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WagonDAO extends JpaRepository<Wagon, String> {
}
