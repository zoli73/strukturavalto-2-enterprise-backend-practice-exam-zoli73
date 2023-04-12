package com.codecool.train.service;

import com.codecool.train.dto.TrainDto;
import com.codecool.train.dto.TrainMapper;
import com.codecool.train.dto.TrainWagonDto;
import com.codecool.train.entity.Train;
import com.codecool.train.entity.Wagon;
import com.codecool.train.repository.TrainDAO;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class TrainService {
    private TrainDAO trainDAO;
    private WagonService wagonService;

    public TrainService(TrainDAO trainDAO, WagonService wagonService) {
        this.trainDAO = trainDAO;
        this.wagonService = wagonService;
    }

    public void saveTrain(TrainDto trainDto) {
        trainDAO.save(TrainMapper.dtoToTrain(trainDto));
    }

    public void addWagonToTrain(TrainWagonDto trainWagonDto) {
        Train train = getTrainById(trainWagonDto.getTrainId());
        Wagon wagon = wagonService.getWagonById(trainWagonDto.getWagonId());
        train.getWagons().add(wagon);
    }

    public Train getTrainById(String id) {
        return trainDAO.findById(id)
                .orElseThrow(() ->
                        new ResponseStatusException(HttpStatus.BAD_REQUEST, "Train not found with the given id!"));
    }

    public void updateTrain(String id, TrainDto trainDto) {
        Train train = getTrainById(id);
        train.setId(trainDto.getId());
        train.setDriver(trainDto.getDriver());
        train.setDestination(trainDto.getDestination());
        train.setIsLate(trainDto.getIsLate());
        trainDAO.save(train);
    }

    public void deleteTrain(String id) {
        Train train = getTrainById(id);
        trainDAO.delete(train);
    }
}
