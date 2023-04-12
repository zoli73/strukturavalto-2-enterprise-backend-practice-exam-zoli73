package com.codecool.train.controller;

import com.codecool.train.dto.WagonDto;
import com.codecool.train.entity.Wagon;
import com.codecool.train.service.WagonService;
import lombok.Getter;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/wagon")
public class WagonController {
    private WagonService wagonService;

    public WagonController(WagonService wagonService) {
        this.wagonService = wagonService;
    }

    @PostMapping
    public void saveWagon(WagonDto wagonDto) {
        wagonService.saveWagon(wagonDto);
    }

    @GetMapping
    public List<Wagon> listAllWagon() {
        return wagonService.listAllWagon();
    }

    @PutMapping("/{id}")
    public void updateWagon(@PathVariable("id") String id, @RequestBody WagonDto wagonDto) {
        wagonService.updateWagon(id, wagonDto);
    }

    @DeleteMapping("/{id}")
    public void deleteWagon(@PathVariable("id") String id) {
        wagonService.deleteWagon(id);
    }
}
