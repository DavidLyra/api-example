package com.skipthedishes.lyradavid.test.repository;

import com.skipthedishes.lyradavid.test.model.Cousine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CousineRepository extends JpaRepository<Cousine, Long> {
    List<Cousine> findByNameContaining(String searchText);
}
