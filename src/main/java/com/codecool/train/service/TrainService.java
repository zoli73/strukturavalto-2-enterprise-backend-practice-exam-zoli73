package com.codecool.train.service;

import com.codecool.train.repository.TrainDAO;
import org.springframework.stereotype.Service;

@Service
public class TrainService {
    private TrainDAO trainDAO;

    public TrainService(TrainDAO trainDAO) {
        this.trainDAO = trainDAO;
    }
}
