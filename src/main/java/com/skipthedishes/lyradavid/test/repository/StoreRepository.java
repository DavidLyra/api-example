package com.skipthedishes.lyradavid.test.repository;

import com.skipthedishes.lyradavid.test.model.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by david on 17/03/2018.
 */
@Repository
public interface StoreRepository extends JpaRepository<Store, Integer> {

    @Query("select s from Store s where s.cousine.id = ?1")
    List<Store> findByCousineId(Long cousineId);

}