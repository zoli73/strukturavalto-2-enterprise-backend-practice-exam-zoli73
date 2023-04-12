package com.codecool.train.controller;

import com.codecool.train.dto.TrainDto;
import com.codecool.train.dto.TrainWagonDto;
import com.codecool.train.entity.Train;
import com.codecool.train.service.TrainService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/train")
public class TrainController {
    private TrainService trainService;

    public TrainController(TrainService trainService) {
        this.trainService = trainService;
    }

    @PostMapping
    public void saveTrain(@RequestBody TrainDto trainDto) {
        trainService.saveTrain(trainDto);
    }

    @PostMapping("/addWagon")
    public void addWagonToTrain(@RequestBody TrainWagonDto trainWagonDto) {
        trainService.addWagonToTrain(trainWagonDto);
    }

    @GetMapping("/{id}")
    public Train getTrainById(@PathVariable("id") String id) {
        return trainService.getTrainById(id);
    }

    @PutMapping("/{id}")
    public void updateTrain(@PathVariable("id") String id, @RequestBody TrainDto trainDto) {
        trainService.updateTrain(id, trainDto);
    }

    @DeleteMapping("/{id}")
    public void deleteTrain(@PathVariable("id") String id) {
        trainService.deleteTrain(id);
    }

    @GetMapping("/heavy")
    public List<Train> listHeavyWagons() {
        return trainService.listHeavyWagons();
    }
}
