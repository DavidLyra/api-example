package com.skipthedishes.lyradavid.test.repository;

import com.skipthedishes.lyradavid.test.model.Order;
import com.skipthedishes.lyradavid.test.model.OrderItem;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Created by david on 17/03/2018.
 */
@RepositoryRestResource(collectionResourceRel = "orderitem", path = "orderitem")
public interface OrderItemRepository extends PagingAndSortingRepository<OrderItem, Integer> {

}