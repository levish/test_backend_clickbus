package com.clickbustest.backend_crud.domain.repository;

import com.clickbustest.backend_crud.domain.model.Place;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PlaceRepository extends JpaRepository<Place,Long> {

    @Query(value = "select u from Place u where trim (u.name) like %?1%")
    List<Place> findPlaceByNam(String name);
}
