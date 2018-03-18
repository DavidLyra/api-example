package com.skipthedishes.lyradavid.test.controller;

import com.skipthedishes.lyradavid.test.model.Cousine;
import com.skipthedishes.lyradavid.test.model.Store;
import com.skipthedishes.lyradavid.test.repository.CousineRepository;
import com.skipthedishes.lyradavid.test.repository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.io.Serializable;
import java.util.List;

@RestController
@RequestMapping("/api/v1/cousine")
public class CousineController implements Serializable {


    @Autowired
    private CousineRepository repo;

    @Autowired
    private StoreRepository storeRepository;

    @GetMapping
    public List<Cousine> cousineList() {
        return repo.findAll();
    }

    @GetMapping("/search/{searchText}")
    public List<Cousine> cousineList(@PathVariable("searchText") String searchText) {
        return repo.findByNameContaining(searchText);
    }

    @GetMapping("/{cousineId}/stores")
    public List<Store> cousineList(@PathVariable("cousineId") Long cousineId) {
        return storeRepository.findByCousineId(cousineId);
    }
}
