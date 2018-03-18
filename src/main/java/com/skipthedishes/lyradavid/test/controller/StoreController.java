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
    private StoreRepository storeRepository;

    // Get All Stores
    @GetMapping
    public List<Store> storeList() {
        return storeRepository.findAll();
    }

    // Get a Single Store
    @GetMapping("/{id}")
    public Store getStoreId(@PathVariable(value = "id") Integer storeId) {
        return storeRepository.findOne(storeId);
    }

    @GetMapping("/search/{searchText}")
    public List<Store> storeList(@PathVariable("searchText") String searchText) {
        return storeRepository.findByNameContaining(searchText);
    }
}