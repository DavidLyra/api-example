package com.skipthedishes.lyradavid.test.repository;

import com.skipthedishes.lyradavid.test.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * Created by david on 17/03/2018.
 */

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}