package com.skipthedishes.lyradavid.test.repository;

import com.skipthedishes.lyradavid.test.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by david on 17/03/2018.
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
}
