package com.codecool.train.service;

import com.codecool.train.dto.TrainDto;
import com.codecool.train.dto.mapper.TrainMapper;
import com.codecool.train.dto.TrainWagonDto;
import com.codecool.train.entity.Train;
import com.codecool.train.entity.Wagon;
import com.codecool.train.repository.TrainDAO;
import com.codecool.train.repository.WagonDAO;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

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
        wagon.setTrain(train);
        wagonService.saveWagon(wagon);
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

    public List<Train> listHeavyWagons() {
        List<Train> trains = trainDAO.findAll();
        return trains.stream()
                .filter(train -> (
                        train.getWagons()
                                .stream().mapToInt(Wagon::getWeight)
                                .reduce((weight, sum) -> sum += weight)).orElse(0) > 25).toList();
    }
}
