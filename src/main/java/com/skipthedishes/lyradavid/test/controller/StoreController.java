package com.skipthedishes.lyradavid.test.controller;

import com.skipthedishes.lyradavid.test.model.Store;
import com.skipthedishes.lyradavid.test.repository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by david on 17/03/2018.
 */
@RestController
@RequestMapping("/api/v1/store")
public class StoreController {

    @Autowired
    private StoreRepository cousineRepository;

    @GetMapping
    public List<Store> storeList() {
        return cousineRepository.findAll();
    }

    // Get All Cousines
    @GetMapping("/api/v1/cousine")
    public List<Store> getAllCousine() {
        return cousineRepository.findAll();
    }

    // Get a Single Store
    @GetMapping("/api/v1/cousine/{id}/stores")
    public Store getCousineById(@PathVariable(value = "id") Integer cousineId) {
        return cousineRepository.findOne(cousineId);
        //   .orElseThrow(() -> new ResourceNotFoundException("Store", "id", cousineId));
    }

    /*
    // Get Cousines By Text
    @GetMapping("/api/v1/cousine/search/{searchText}")
    public Store getCousineByText(@PathVariable(value = "searchText") String text) {
        List<Registration> findByPlaceContaining(String text);
        return
    }
    */
}