package com.clickbustest.backend_crud.api.controller;


import com.clickbustest.backend_crud.domain.service.PlaceService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.clickbustest.backend_crud.domain.repository.PlaceRepository;
import com.clickbustest.backend_crud.domain.model.Place;

import java.util.List;

@RestController
@RequestMapping("/places")
public class PlaceController {

    @Autowired
    PlaceRepository placeRepository;

    @Autowired
    PlaceService placeService;

    @GetMapping
    public List<Place> placeList(){
        return placeRepository.findAll();
    }

    @GetMapping("/{placeId}")
    public Place findPlaceById(@PathVariable Long placeId){
        return placeService.findOrFail(placeId);
    }

    @GetMapping("/search/{placeName}")
    public List<Place> findPlaceByName(@PathVariable String placeName){
        return placeRepository.findPlaceByNam(placeName);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Place createPlace(@RequestBody Place place){
        return placeRepository.save(place);
    }

    @DeleteMapping("/{placeId}")
    public void deletePlace(@PathVariable Long placeId){
        placeService.toDelete(placeId);
    }

    @PutMapping("/{placeId}")
    public Place updatePlace(@PathVariable Long placeId, @RequestBody Place place){
        Place place1 = placeService.findOrFail(placeId);
        BeanUtils.copyProperties(place, place1,"id","createdAt");
        return placeService.toSave(place1);
    }













}
