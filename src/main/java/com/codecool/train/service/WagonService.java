package com.codecool.train.service;

import com.codecool.train.repository.WagonDAO;
import org.springframework.stereotype.Service;

@Service
public class WagonService {
    private WagonDAO wagonDAO;

    public WagonService(WagonDAO wagonDAO) {
        this.wagonDAO = wagonDAO;
    }


}
