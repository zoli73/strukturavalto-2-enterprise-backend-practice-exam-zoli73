package com.codecool.train.service;

import com.codecool.train.dto.WagonDto;
import com.codecool.train.dto.mapper.WagonMapper;
import com.codecool.train.entity.Wagon;
import com.codecool.train.repository.WagonDAO;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class WagonService {
    private WagonDAO wagonDAO;

    public WagonService(WagonDAO wagonDAO) {
        this.wagonDAO = wagonDAO;
    }

    public void saveWagon(WagonDto wagonDto) {
        wagonDAO.save(WagonMapper.dtoToWagon(wagonDto));
    }

    public List<Wagon> listAllWagon() {
        return wagonDAO.findAll();
    }

    public Wagon getWagonById(String id) {
        return wagonDAO.findById(id)
                .orElseThrow(() ->
                        new ResponseStatusException(HttpStatus.BAD_REQUEST, "Wagon not found with the given id!"));
    }

    public void updateWagon(String id, WagonDto wagonDto) {
        Wagon wagon = getWagonById(id);
        wagon.setId(wagonDto.getId());
        wagon.setWeight(wagonDto.getWeight());
        wagon.setWagonType(wagonDto.getWagonType());
        wagonDAO.save(wagon);
    }

    public void deleteWagon(String id) {
        Wagon wagon = getWagonById(id);
        wagonDAO.delete(wagon);
    }
}
