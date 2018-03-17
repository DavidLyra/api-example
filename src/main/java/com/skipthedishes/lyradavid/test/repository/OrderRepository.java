package com.skipthedishes.lyradavid.test.repository;

import com.skipthedishes.lyradavid.test.model.Order;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

/**
 * Created by david on 17/03/2018.
 */
@Repository
public interface OrderRepository extends PagingAndSortingRepository<Order, Integer> {

}