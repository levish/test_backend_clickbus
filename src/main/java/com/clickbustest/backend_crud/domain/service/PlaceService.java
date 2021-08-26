package com.clickbustest.backend_crud.domain.service;


import com.clickbustest.backend_crud.domain.exception.ResourceNotFoundException;
import com.clickbustest.backend_crud.domain.model.Place;
import com.clickbustest.backend_crud.domain.repository.PlaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
public class PlaceService {
    public static final String MSG_PLACE_NOTFOUND = "Nao existe cadastro de lugar com o coddgo %d";
    @Autowired

    private PlaceRepository placeRepository;

    public Place toSave(Place place){
        return placeRepository.save(place);
    }

    public Place findOrFail(Long placeId){
        return placeRepository.findById(placeId).orElseThrow(
                ()-> new ResourceNotFoundException(String.format(MSG_PLACE_NOTFOUND,placeId)));
    }

    public void toDelete(Long placeId){
        try {
            placeRepository.deleteById(placeId);
        } catch (EmptyResultDataAccessException e){
            throw new ResourceNotFoundException(String.format(MSG_PLACE_NOTFOUND,placeId));
        }
    }

}
